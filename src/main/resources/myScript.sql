SELECT ord.*
FROM Orders ord
JOIN Customers cus ON ord.customer_id = cus.id
WHERE
	cus.name ILIKE :name;