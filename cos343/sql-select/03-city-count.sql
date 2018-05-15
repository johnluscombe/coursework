-- The name and number of cities in each country. The column that contains the
-- number of cities should be headed =city_count=.

SELECT country, COUNT(city) AS city_count
FROM country_old INNER JOIN city
  ON country_old.country_id = city.country_id
GROUP BY country;