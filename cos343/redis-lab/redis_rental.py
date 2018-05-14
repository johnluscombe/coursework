import psycopg2
import redis


class Postgres:
    def __init__(self, connection_string):
        self.connection = psycopg2.connect(connection_string)
        self.cursor = self.connection.cursor()


class Redis:
    def __init__(self):
        self.connection = redis.StrictRedis(host='faraday.cse.taylor.edu', port=6407)

    def rpush(self, name, value):
        self.connection.rpush(name, value)

    def lrange(self, name, start, end):
        return self.connection.lrange(name, start, end)

    def sadd(self, name, value):
        self.connection.sadd(name, value)

    def smembers(self, name):
        return self.connection.smembers(name)
        
    def hset(self, name, key, value):
        self.connection.hset(name, key, value)

    def hget(self, name, key):
        return self.connection.hget(name, key)

    def hgetall(self, name):
        return self.connection.hgetall(name)

    def flushall(self):
        self.connection.flushall()


class DvdRental:
    def __init__(self, connection_string):
        self.pg = Postgres(connection_string)
        self.redis = Redis()
        self.redis.flushall()
        print("Loading film data (1/5)...")
        self.__load_data_from_sql('SELECT * FROM film', 'film')
        print("Loading film_actor data (2/5)...")
        self.__load_data_from_associative_entity('SELECT * FROM film_actor', 'actor', 'film')
        print("Loading actor data (3/5)...")
        self.__load_data_from_sql('SELECT * FROM actor', 'actor')
        print("Loading film_category data (4/5)...")
        self.__load_data_from_associative_entity('SELECT * FROM film_category', 'film', 'category')
        print("Loading category data (5/5)...")
        self.__load_data_from_sql('SELECT * FROM category', 'category')

    def __load_data_from_sql(self, sql, table_name):
        self.pg.cursor.execute(sql)
        fields = self.__get_fields_from_cursor()
        row_ids = []
        for row in self.pg.cursor:
            row_id = row[0]
            row_ids.append(row_id)
            hash_name = "%s:%s" % (table_name, row_id)
            for i in range(1, len(fields)):
                if fields[i] != 'last_update':
                    self.redis.hset(hash_name, fields[i], row[i])
        for row_id in row_ids:
            self.redis.rpush(table_name, row_id)

    def __load_data_from_associative_entity(self, sql, linking_table_1, linking_table_2):
        self.pg.cursor.execute(sql)
        set_name = "%s:%s" % (linking_table_1, linking_table_2)
        for row in self.pg.cursor:
            linking_table_1_id = row[0]
            linking_table_2_id = row[1]
            set_key = "%s:%s" % (linking_table_1_id, linking_table_2_id)
            self.redis.sadd(set_name, set_key)

    def __get_fields_from_cursor(self):
        fields = []
        for field in self.pg.cursor.description:
            fields.append(field[0])
        return fields

    def actor(self, actor_id):
        actor = self.redis.hgetall('actor:'+str(actor_id))
        actor[b'films'] = []
        film_actors = self.redis.smembers('actor:film')
        for film_actor_bytes in film_actors:
            film_actor = film_actor_bytes.decode('utf-8')
            film_actor_list = film_actor.split(':')
            if int(film_actor_list[0]) == actor_id:
                film_id = film_actor_list[1]
                film_title = self.redis.hget('film:'+film_id, 'title')
                actor[b'films'].append(film_title)
        return actor

    def film(self, film_id):
        film = self.redis.hgetall('film:'+str(film_id))
        film[b'actors'] = []
        film_actors = self.redis.smembers('actor:film')
        for film_actor_bytes in film_actors:
            film_actor = film_actor_bytes.decode('utf-8')
            film_actor_list = film_actor.split(':')
            if int(film_actor_list[1]) == film_id:
                actor_id = film_actor_list[0]
                actor_first_name = self.redis.hget('actor:'+actor_id, 'first_name').decode('utf-8')
                actor_last_name = self.redis.hget('actor:'+actor_id, 'last_name').decode('utf-8')
                actor_full_name = "%s %s" % (actor_first_name, actor_last_name)
                actor_full_name_bytes = str.encode(actor_full_name)
                film[b'actors'].append(actor_full_name_bytes)
        return film

    def categories(self):
        film_categories = []
        category_ids = self.redis.lrange('category', 0, -1)
        for category_id_bytes in category_ids:
            category_id = category_id_bytes.decode('utf-8')
            category = self.redis.hgetall('category:'+str(category_id))
            category[b'ID'] = int(category_id)
            film_categories.append(category)
        return film_categories

    def film_by_category(self, category_id):
        films_with_category = []
        film_categories = self.redis.smembers('film:category')
        for film_category_bytes in film_categories:
            film_category = film_category_bytes.decode('utf-8')
            film_category_list = film_category.split(':')
            if int(film_category_list[1]) == category_id:
                film_id = film_category_list[0]
                film = self.redis.hgetall('film:'+film_id)
                films_with_category.append(film)
        return films_with_category

    def add_actor_to_film(self, actor_id, film_id):
        set_key = "%s:%s" % (actor_id, film_id)
        self.redis.sadd('actor:film', set_key)
