SELECT p.amount AS fifth_largest_amount FROM (SELECT DISTINCT(amount) FROM payment) AS p
ORDER BY p.amount DESC 
LIMIT 4,1;

