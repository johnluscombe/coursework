-- The title and rental duration (which the database gives in days) for all films
-- having a title starting with =S= and rented for between four and six days
-- (inclusive). Order your results by decreasing rental duration and them by film
-- title.

SELECT title, rental_duration FROM film
WHERE title LIKE 'S%'
  AND rental_duration >= 4
  AND rental_duration <= 6
ORDER BY rental_duration DESC, title;