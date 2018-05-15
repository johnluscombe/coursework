-- The title and total number of times rented for the ten most-rented
-- movies. Order the results first by descending number of rentals and then by
-- movie title.

SELECT title, COUNT(rental_id)
FROM film INNER JOIN inventory
  ON film.film_id = inventory.film_id
  INNER JOIN rental
    ON inventory.inventory_id = rental.inventory_id
GROUP BY title
ORDER BY COUNT(rental_id) DESC, title
LIMIT 10;