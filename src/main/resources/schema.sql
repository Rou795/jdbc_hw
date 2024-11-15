-- СОЗДАНИЕ ТАБЛИЦ
CREATE TABLE IF NOT EXISTS Customers(
	id bigserial PRIMARY KEY,
	name TEXT NOT NULL,
	surname TEXT NOT NULL,
	age int NOT NULL,
	phone_number TEXT
);

CREATE TABLE IF NOT EXISTS Orders(
	id bigserial PRIMARY KEY,
	date date NOT NULL,
	customer_id int NOT NULL,
	product_name TEXT NOT NULL,
	amount int NOT NULL,

	FOREIGN KEY (customer_id) REFERENCES Customers (id)
);

--ЗАПОЛНЕНИЕ ТАБЛИЦ ТЕСТОВЫМИ ДАННЫМИ
INSERT INTO customers (name, surname, age, phone_number)
VALUES
	('Вячеслав', 'Лутошкин', 35, 89256541256),
	('Генрих', 'Прошин', 31, 89256541251),
	('Вячеслав', 'Зарин', 24, 89256541356),
	('Николай', 'Щеткин', 37, 89256541456);

INSERT INTO orders (date, customer_id, product_name, amount)
VALUES
	('2024-10-26', 1, 'notebook', 100000),
	('2024-10-27', 2, 'personal computer', 50000),
	('2024-10-27', 2, 'phone', 25000),
	('2024-10-27', 2, 'laptop', 65000),
	('2024-10-27', 4, 'playstation', 53000),
	('2024-10-28', 3, 'xbox', 43000);