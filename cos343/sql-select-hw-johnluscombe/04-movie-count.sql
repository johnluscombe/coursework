-- For all actors, their first name, last name, and total number of movies
-- in which they acted. Order results alphabetically by actor last name,
-- then first name.

SELECT first_name, last_name, COUNT(title)
FROM actor INNER JOIN film_actor
  ON actor.actor_id = film_actor.actor_id
  INNER JOIN film
    ON film_actor.film_id = film.film_id
GROUP BY first_name, last_name
ORDER BY last_name, first_name;