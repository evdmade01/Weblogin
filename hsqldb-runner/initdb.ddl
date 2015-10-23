DROP TABLE IF EXISTS order_lines;
DROP TABLE IF EXISTS products;

CREATE TABLE products (
   id INTEGER IDENTITY,
   name VARCHAR(255) UNIQUE NOT NULL,
   price NUMERIC(10,2) NOT NULL
);

CREATE TABLE order_lines (
   id INTEGER IDENTITY,
   product_id INTEGER NOT NULL REFERENCES products(id),
   quantity INTEGER NOT NULL
);

