from redis_rental import DvdRental

dvddb = DvdRental("host=faraday.cse.taylor.edu dbname=dvdrental user=readonly password=nerds4christ")


def test_actor(actor_id):
    print("\nActor Data:")
    films = []
    actor = dvddb.actor(actor_id)
    print(actor)
    first_name = actor[b'first_name'].decode('utf-8')
    last_name = actor[b'last_name'].decode('utf-8')
    for film_bytes in actor[b'films']:
        film = film_bytes.decode('utf-8')
        films.append(film)
    films.sort()
    for film in films:
        output = "%-10s %-10s %-25s" % (first_name, last_name, film)
        print(output)
    output = "(%s rows)" % len(films)
    print(output)


def test_film(film_id):
    print("\nFilm Data:")
    actors = []
    film = dvddb.film(film_id)
    print(film)
    film_title = film[b'title'].decode('utf-8')
    for actor_bytes in film[b'actors']:
        actor = actor_bytes.decode('utf-8')
        actors.append(actor)
    actors.sort()
    for actor in actors:
        actor_list = actor.split()
        first_name = actor_list[0]
        last_name = actor_list[1]
        output = "%-25s %-10s %-10s" % (film_title, first_name, last_name)
        print(output)
    output = "(%s rows)" % len(actors)
    print(output)


def test_categories():
    print("\nCategories:")
    film_categories = dvddb.categories()
    print(film_categories)
    for film_category in film_categories:
        category_id = film_category[b'ID']
        category_name = film_category[b'name'].decode('utf-8')
        output = "%-10s %-20s" % (category_id, category_name)
        print(output)
    output = "(%s rows)" % len(film_categories)
    print(output)


def test_films_by_category(category_id):
    print("\nCategory Data:")
    films = []
    films_by_category = dvddb.film_by_category(category_id)
    print(films_by_category[0])
    for film in films_by_category:
        film_title = film[b'title'].decode('utf-8')
        films.append(film_title)
    films.sort()
    for film in films:
        print(film)
    output = "(%s rows)" % len(films)
    print(output)


def main():
    test_actor(1)
    test_film(2)
    # test_categories()
    # test_films_by_category(1)
    dvddb.add_actor_to_film(1, 2)
    test_actor(1)
    test_film(2)


main()
