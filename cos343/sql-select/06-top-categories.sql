-- For each actor whose last name starts with =S=, the number of movies in
-- which they appeared in each category.  Show the actor's first and last name,
-- along with the category name and number of movies in that category in which
-- the actor appeared. For a given actor, only show the categories in which
-- they appeared in at least three movies. Order results alphabetically by last
-- name and first name, then by decreasing number of movies.

SELECT first_name, last_name, name, count(name)
FROM actor INNER JOIN film_actor
  ON actor.actor_id = film_actor.actor_id
  INNER JOIN film
    ON film_actor.film_id = film.film_id
    INNER JOIN film_category
      ON film.film_id = film_category.film_id
      INNER JOIN category
      ON film_category.category_id = category.category_id
WHERE last_name LIKE 'S%'
GROUP BY first_name, last_name, name
HAVING count(name) >= 3
ORDER BY last_name, first_name, count(name) DESC;