# Redis Lab

## Assignment Purpose

The purpose of this assignment was to practice with Redis by reimplementing
a portion of a preexisting `dvdrental` PostgreSQL database using Redis, then
implementing methods to retrieve the Redis data.

We were to implement a Python class that implements six methods for retrieving
`dvdrental` data:

1. A standard Python contructor that loads film, actor, and category data (as
   well as any associative data required) from the PostgreSQL database into
   your Redis version. Use the psycopg module for Python to access the
   PostgreSQL database. The constructor should take a connection string as its
   only parameter and use that string for the psycopg `connect` method to
   access the `dvdrental` database. For example:
   `conn = psycopg2.connect("host=faraday.cse.taylor.edu dbname=dvdrental user=readonly password=nerds4christ")`
2. `actor(actor_id)` returns a dictionary containing the actor’s details,
   including a list of the films in which the actor appears.
3. `film(film_id)` returns a dictionary containing the film’s details,
   including a list of the actors who appear in the film.
4. `categories()` returns a list of dictionaries, each of which contains the
   details for all categories in the data store.
5. `films_by_category(category_id)` returns a list of dictionaries containing
   all the film details for a given category.
6. `add_actor_to_film(actor_id, film_id)` adds the actor with ID `actor_id` to
   the film with ID `film_id`.

## Credit

- **Assignment Author**: Dr. Tom Nurkkala, PhD