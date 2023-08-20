# DDL

Data Definition Language (DDL) commands in SQL are used to define, modify, and manage the structure of database objects such as tables, indexes, views, and constraints. Here are the main DDL commands with explanations and examples:

1. **CREATE TABLE:**
   Creates a new table with specified columns and data types.

   ```sql
   CREATE TABLE employees (
       employee_id INT PRIMARY KEY,
       first_name VARCHAR(50),
       last_name VARCHAR(50),
       department_id INT
   );
   ```

2. **ALTER TABLE:**
   Modifies an existing table by adding, modifying, or deleting columns.

   ```sql
   ALTER TABLE employees
   ADD COLUMN hire_date DATE;
   ```

3. **DROP TABLE:**
   Deletes an existing table and its data.

   ```sql
   DROP TABLE customers;
   ```

4. **CREATE INDEX:**
   Creates an index on one or more columns of a table, which improves query performance.

   ```sql
   CREATE INDEX idx_last_name ON employees (last_name);
   ```

5. **DROP INDEX:**
   Deletes an existing index.

   ```sql
   DROP INDEX idx_last_name;
   ```

6. **CREATE VIEW:**
   Creates a virtual table based on the result of a query.

   ```sql
   CREATE VIEW high_salary_employees AS
   SELECT * FROM employees WHERE salary > 50000;
   ```

7. **DROP VIEW:**
   Deletes an existing view.

   ```sql
   DROP VIEW high_salary_employees;
   ```

8. **CREATE DATABASE:**
   Creates a new database.

   ```sql
   CREATE DATABASE mydb;
   ```

9. **DROP DATABASE:**
   Deletes an existing database and all its objects.

   ```sql
   DROP DATABASE mydb;
   ```

10. **ALTER DATABASE:**
    Modifies properties of an existing database.

    ```sql
    ALTER DATABASE mydb
    SET READ_COMMITTED_SNAPSHOT ON;
    ```

11. **CREATE SCHEMA:**
    Creates a new schema within a database.

    ```sql
    CREATE SCHEMA myschema;
    ```

12. **ALTER SCHEMA:**
    Modifies a schema.

    ```sql
    ALTER SCHEMA myschema
    TRANSFER employees;
    ```

13. **CREATE USER:**
    Creates a new database user.

    ```sql
    CREATE USER newuser IDENTIFIED BY 'password';
    ```

14. **ALTER USER:**
    Modifies properties of a user.

    ```sql
    ALTER USER newuser
    SET DEFAULT_SCHEMA = myschema;
    ```

15. **GRANT:**
    Grants specific privileges to users or roles.

    ```sql
    GRANT SELECT, INSERT ON employees TO newuser;
    ```

16. **REVOKE:**
    Removes previously granted privileges.

    ```sql
    REVOKE INSERT ON employees FROM newuser;
    ```

These are some of the key DDL commands used in SQL to define and manage the structure of your database objects. Keep in mind that the specific syntax and features might vary slightly depending on the database management system you're using (e.g., MySQL, PostgreSQL, SQL Server).


# DML

Data Manipulation Language (DML) commands in SQL are used to interact with the data stored in a database. These commands allow you to insert, retrieve, update, and delete data. Here are the main DML commands with explanations and examples:

1. **SELECT:**
   Retrieves data from one or more tables.

   ```sql
   SELECT first_name, last_name
   FROM employees
   WHERE department_id = 2;
   ```

2. **INSERT:**
   Adds new records into a table.

   ```sql
   INSERT INTO customers (first_name, last_name, email)
   VALUES ('John', 'Doe', 'john@example.com');
   ```

3. **UPDATE:**
   Modifies existing records in a table.

   ```sql
   UPDATE products
   SET price = price * 1.1
   WHERE category = 'Electronics';
   ```

4. **DELETE:**
   Removes records from a table.

   ```sql
   DELETE FROM orders
   WHERE order_date < '2023-01-01';
   ```

5. **MERGE (SQL Server):**
   Combines INSERT, UPDATE, and DELETE operations based on a condition.

   ```sql
   MERGE INTO target_table AS target
   USING source_table AS source
   ON (target.id = source.id)
   WHEN MATCHED THEN
       UPDATE SET target.value = source.new_value
   WHEN NOT MATCHED THEN
       INSERT (id, value) VALUES (source.id, source.new_value);
   ```

6. **TRUNCATE (Some Databases):**
   Removes all records from a table, but retains the table structure.

   ```sql
   TRUNCATE TABLE employees;
   ```

7. **UPSERT (Some Databases):**
   Inserts a new record or updates an existing record if a unique constraint is violated.

   ```sql
   INSERT INTO products (product_id, product_name)
   VALUES (101, 'New Product')
   ON DUPLICATE KEY UPDATE product_name = 'Updated Product';
   ```

8. **CTE (Common Table Expressions) with DML:**
   Allows complex queries with DML operations.

   ```sql
   WITH updated_customers AS (
       SELECT customer_id, first_name, last_name
       FROM customers
       WHERE country = 'USA'
   )
   UPDATE updated_customers
   SET last_name = 'Updated'
   WHERE customer_id > 100;
   ```

9. **Using Subqueries in DML:**
   Subqueries can be used in DML statements for more specific data manipulation.

   ```sql
   UPDATE products
   SET stock_quantity = stock_quantity - (SELECT quantity FROM order_items WHERE product_id = 123);
   ```

10. **Batch Processing (Some Databases):**
    Processing multiple DML statements together to improve performance.

    ```sql
    BEGIN;
    INSERT INTO table1 (column1, column2) VALUES (value1, value2);
    UPDATE table2 SET column3 = value3 WHERE condition;
    DELETE FROM table3 WHERE condition;
    COMMIT;
    ```

These DML commands provide a comprehensive set of tools for interacting with and manipulating the data stored within a database. As always, be sure to use these commands carefully and consider the implications of your data changes. The syntax and features might vary depending on the specific database management system you're using (e.g., MySQL, PostgreSQL, SQL Server).



# Querying Data

Querying data in SQL involves using the SELECT statement to retrieve specific information from a database. Here's a detailed explanation of querying data using the SELECT statement, along with examples for various scenarios:

1. **Basic SELECT:**
   Retrieve all columns and rows from a table.

   ```sql
   SELECT * FROM employees;
   ```

2. **SELECT Specific Columns:**
   Retrieve specific columns from a table.

   ```sql
   SELECT first_name, last_name FROM employees;
   ```

3. **Filtering Rows with WHERE:**
   Retrieve rows that satisfy a specific condition.

   ```sql
   SELECT product_name, price
   FROM products
   WHERE category = 'Electronics' AND price > 500;
   ```

4. **Sorting Results with ORDER BY:**
   Retrieve and sort rows based on one or more columns.

   ```sql
   SELECT first_name, last_name, hire_date
   FROM employees
   ORDER BY hire_date DESC;
   ```

5. **Limiting Results with LIMIT/OFFSET (Database-dependent):**
   Retrieve a specific number of rows, optionally starting from a certain position.

   ```sql
   SELECT product_name, price
   FROM products
   LIMIT 10 OFFSET 20; -- Skip first 20 rows, retrieve next 10
   ```

6. **Aggregate Functions:**
   Perform calculations on columns (e.g., SUM, AVG, COUNT, MAX, MIN).

   ```sql
   SELECT department_id, AVG(salary) AS avg_salary
   FROM employees
   GROUP BY department_id;
   ```

7. **JOIN Operations:**
   Combine data from multiple tables using different types of joins.

   ```sql
   SELECT orders.order_id, customers.first_name, customers.last_name
   FROM orders
   JOIN customers ON orders.customer_id = customers.customer_id;
   ```

8. **Subqueries:**
   Use a subquery to retrieve data based on the results of another query.

   ```sql
   SELECT first_name, last_name
   FROM employees
   WHERE department_id IN (SELECT department_id FROM departments WHERE location = 'New York');
   ```

9. **Using Aliases:**
   Assign aliases to columns or tables for better readability.

   ```sql
   SELECT first_name AS "First Name", last_name AS "Last Name"
   FROM employees;
   ```

10. **Combining Conditions with Logical Operators:**
    Use logical operators (AND, OR, NOT) to combine conditions.

    ```sql
    SELECT product_name, price
    FROM products
    WHERE category = 'Electronics' AND (price > 500 OR discount > 0.2);
    ```

11. **Working with NULL Values:**
    Handle NULL values using IS NULL or IS NOT NULL.

    ```sql
    SELECT product_name, price
    FROM products
    WHERE description IS NOT NULL;
    ```

12. **Using DISTINCT:**
    Retrieve unique values from a column.

    ```sql
    SELECT DISTINCT category
    FROM products;
    ```

13. **Using Functions:**
    Apply functions to columns in the SELECT statement.

    ```sql
    SELECT first_name, last_name, UPPER(email) AS uppercase_email
    FROM employees;
    ```

14. **Using CASE Statements:**
    Perform conditional logic within a query.

    ```sql
    SELECT product_name,
           CASE WHEN price > 1000 THEN 'Expensive'
                ELSE 'Affordable'
           END AS price_category
    FROM products;
    ```

These examples cover a range of querying scenarios in SQL. By mastering the SELECT statement and its various clauses, you can efficiently retrieve and manipulate data to meet your specific needs. The syntax and features might vary depending on the specific database management system you're using (e.g., MySQL, PostgreSQL, SQL Server).


# Sorting Data

Sorting data in SQL is achieved using the `ORDER BY` clause within the `SELECT` statement. The `ORDER BY` clause allows you to arrange the result set in a specified order based on one or more columns. Here's how you can sort data using SQL along with examples:

1. **Ascending Order (Default):**
   Sorts the result set in ascending order (from smallest to largest).

   ```sql
   SELECT product_name, price
   FROM products
   ORDER BY price;
   ```

2. **Descending Order:**
   Sorts the result set in descending order (from largest to smallest).

   ```sql
   SELECT first_name, last_name, hire_date
   FROM employees
   ORDER BY hire_date DESC;
   ```

3. **Sorting by Multiple Columns:**
   Sorts the result set by multiple columns, applying the sorting order sequentially.

   ```sql
   SELECT department_id, salary, last_name
   FROM employees
   ORDER BY department_id, salary DESC;
   ```

4. **Sorting with NULL Values:**
   NULL values are considered lower than non-NULL values in ascending order and higher in descending order.

   ```sql
   SELECT product_name, discount
   FROM products
   ORDER BY discount DESC;
   ```

5. **Sorting with Expressions:**
   You can use expressions in the `ORDER BY` clause for more complex sorting.

   ```sql
   SELECT first_name, last_name, YEAR(hire_date) AS hire_year
   FROM employees
   ORDER BY hire_year;
   ```

6. **Sorting with CASE Statements:**
   Use `CASE` statements within the `ORDER BY` clause for custom sorting conditions.

   ```sql
   SELECT product_name, price
   FROM products
   ORDER BY
       CASE WHEN price > 1000 THEN 1
            ELSE 2
       END,
       price DESC;
   ```

7. **Sorting with Aliases:**
   You can use column aliases in the `ORDER BY` clause.

   ```sql
   SELECT first_name, last_name, salary AS monthly_salary
   FROM employees
   ORDER BY monthly_salary DESC;
   ```

8. **Sorting with Functions:**
   Apply functions to columns in the `ORDER BY` clause.

   ```sql
   SELECT product_name, LENGTH(product_name) AS name_length
   FROM products
   ORDER BY name_length;
   ```

9. **Sorting with Text and Numeric Data:**
   Sorting of text and numeric data follows different rules. Be mindful of the data types when sorting.

   ```sql
   SELECT product_name
   FROM products
   ORDER BY product_name; -- Sorted alphabetically
   ```

These examples illustrate various sorting techniques using the `ORDER BY` clause. Sorting is a fundamental aspect of data retrieval and presentation, allowing you to arrange query results in a meaningful and organized way. As always, the syntax and behavior might vary based on the specific database management system you're using (e.g., MySQL, PostgreSQL, SQL Server).

# Filtering data

Filtering data in SQL involves using the `WHERE` clause within the `SELECT` statement to retrieve specific rows that meet certain conditions. Here's how you can filter data using SQL, along with examples:

1. **Basic Filtering:**
   Retrieve rows that satisfy a specific condition.

   ```sql
   SELECT * FROM employees
   WHERE department_id = 2;
   ```

2. **Using Comparison Operators:**
   Filter rows based on comparison operations (e.g., `=`, `!=`, `<`, `>`, `<=`, `>=`).

   ```sql
   SELECT product_name, price
   FROM products
   WHERE price > 1000;
   ```

3. **Using Logical Operators (AND, OR, NOT):**
   Combine conditions using logical operators.

   ```sql
   SELECT first_name, last_name
   FROM employees
   WHERE department_id = 2 AND salary > 50000;
   ```

4. **Using the IN Operator:**
   Retrieve rows with values that match any value in a list.

   ```sql
   SELECT product_name, category
   FROM products
   WHERE category IN ('Electronics', 'Appliances');
   ```

5. **Using the BETWEEN Operator:**
   Filter rows within a range of values.

   ```sql
   SELECT order_id, order_date
   FROM orders
   WHERE order_date BETWEEN '2023-01-01' AND '2023-03-31';
   ```

6. **Using the LIKE Operator (with Wildcards):**
   Filter rows based on a specific pattern.

   ```sql
   SELECT first_name, last_name
   FROM employees
   WHERE last_name LIKE 'S%';
   ```

7. **Using IS NULL and IS NOT NULL:**
   Retrieve rows with NULL or non-NULL values.

   ```sql
   SELECT product_name
   FROM products
   WHERE description IS NULL;
   ```

8. **Using Subqueries for Filtering:**
   Use subqueries to filter based on results of another query.

   ```sql
   SELECT product_name, price
   FROM products
   WHERE category_id IN (SELECT category_id FROM categories WHERE category_name = 'Electronics');
   ```

9. **Using Multiple Conditions:**
   Combine multiple conditions for more complex filtering.

   ```sql
   SELECT first_name, last_name
   FROM employees
   WHERE (department_id = 2 AND salary > 50000) OR (department_id = 3 AND salary > 60000);
   ```

10. **Using CASE Statements for Conditional Filtering:**
    Use `CASE` statements for conditional filtering.

    ```sql
    SELECT product_name, price,
           CASE WHEN price > 1000 THEN 'Expensive'
                ELSE 'Affordable'
           END AS price_category
    FROM products;
    ```

11. **Filtering with Functions:**
    Apply functions in the `WHERE` clause for filtering.

    ```sql
    SELECT first_name, last_name
    FROM employees
    WHERE LENGTH(first_name) > 5;
    ```

12. **Combining Filtering and Sorting:**
    Use filtering and sorting together in a query.

    ```sql
    SELECT product_name, price
    FROM products
    WHERE category = 'Electronics'
    ORDER BY price DESC;
    ```

These examples demonstrate various filtering techniques using the `WHERE` clause to retrieve specific subsets of data from your database tables. The choice of filtering technique depends on the specific requirements of your query. As always, be mindful of the syntax and behavior differences based on the database management system you're using (e.g., MySQL, PostgreSQL, SQL Server).


# CASE

Conditional expressions in SQL allow you to perform different actions based on specified conditions. One common way to use conditional expressions is with the `CASE` statement. Here's how you can use conditional expressions in SQL, along with examples:

1. **CASE Statement - Simple Example:**
   The `CASE` statement allows you to perform conditional logic within a query.

   ```sql
   SELECT product_name,
          CASE
              WHEN price > 1000 THEN 'Expensive'
              ELSE 'Affordable'
          END AS price_category
   FROM products;
   ```

2. **CASE Statement with Multiple Conditions:**
   You can have multiple `WHEN` conditions in a `CASE` statement.

   ```sql
   SELECT order_id, order_date,
          CASE
              WHEN total_amount > 1000 THEN 'High Value'
              WHEN total_amount > 500 THEN 'Medium Value'
              ELSE 'Low Value'
          END AS order_value_category
   FROM orders;
   ```

3. **CASE Statement in WHERE Clause:**
   Using `CASE` in the `WHERE` clause can help apply conditional filtering.

   ```sql
   SELECT product_name, price
   FROM products
   WHERE CASE
             WHEN category = 'Electronics' THEN price > 500
             WHEN category = 'Appliances' THEN price > 300
             ELSE price > 100
          END;
   ```

4. **CASE Statement with Aggregate Functions:**
   You can use `CASE` with aggregate functions to perform conditional calculations.

   ```sql
   SELECT department_id,
          AVG(CASE WHEN salary > 50000 THEN salary ELSE NULL END) AS avg_high_salary
   FROM employees
   GROUP BY department_id;
   ```

5. **CASE Statement with ORDER BY:**
   Use `CASE` in the `ORDER BY` clause for custom sorting conditions.

   ```sql
   SELECT product_name, price
   FROM products
   ORDER BY
       CASE WHEN price > 1000 THEN 1
            ELSE 2
       END,
       price DESC;
   ```

6. **Using COALESCE or NULLIF:**
   `COALESCE` returns the first non-NULL value, while `NULLIF` returns NULL if two expressions are equal.

   ```sql
   SELECT product_name,
          COALESCE(discount, 0) AS final_discount,
          NULLIF(stock_quantity, 0) AS available_quantity
   FROM products;
   ```

7. **Using IFNULL or ISNULL (Database-dependent):**
   `IFNULL` returns the first non-NULL value, while `ISNULL` returns a replacement value if the expression is NULL.

   ```sql
   SELECT product_name,
          IFNULL(discount, 0) AS final_discount,
          ISNULL(stock_quantity, 0) AS available_quantity
   FROM products;
   ```

8. **Using NULLIFZERO (Database-dependent):**
   A custom function to replace 0 with NULL.

   ```sql
   CREATE FUNCTION NULLIFZERO(value INT)
   RETURNS INT
   BEGIN
       IF value = 0 THEN
           RETURN NULL;
       ELSE
           RETURN value;
       END IF;
   END;
   ```

   ```sql
   SELECT product_name,
          NULLIFZERO(stock_quantity) AS available_quantity
   FROM products;
   ```

These examples demonstrate various ways to use conditional expressions in SQL to perform logic based on specific conditions. Depending on the database management system you're using (e.g., MySQL, PostgreSQL, SQL Server), there might be slight variations in syntax and available functions.

# Joins

Certainly! Joining multiple tables is a common operation in SQL, and it's often used to combine data from different tables based on related columns. Let's use an example with an `employees` table and a `departments` table to demonstrate various types of joins:

Assume we have the following two tables:

1. **employees:**
   - employee_id (Primary Key)
   - first_name
   - last_name
   - department_id (Foreign Key)

2. **departments:**
   - department_id (Primary Key)
   - department_name

Now, let's explore different types of joins using these tables:

1. **INNER JOIN:**
   Retrieves only the rows that have matching values in both tables.

   ```sql
   SELECT employees.first_name, employees.last_name, departments.department_name
   FROM employees
   INNER JOIN departments ON employees.department_id = departments.department_id;
   ```

2. **LEFT JOIN (or LEFT OUTER JOIN):**
   Retrieves all rows from the left table (employees), and the matching rows from the right table (departments).

   ```sql
   SELECT employees.first_name, employees.last_name, departments.department_name
   FROM employees
   LEFT JOIN departments ON employees.department_id = departments.department_id;
   ```

3. **RIGHT JOIN (or RIGHT OUTER JOIN):**
   Retrieves all rows from the right table (departments), and the matching rows from the left table (employees).

   ```sql
   SELECT employees.first_name, employees.last_name, departments.department_name
   FROM employees
   RIGHT JOIN departments ON employees.department_id = departments.department_id;
   ```

4. **FULL JOIN (or FULL OUTER JOIN):**
   Retrieves all rows when there is a match in either the left table (employees) or the right table (departments).

   ```sql
   SELECT employees.first_name, employees.last_name, departments.department_name
   FROM employees
   FULL JOIN departments ON employees.department_id = departments.department_id;
   ```

5. **SELF JOIN (joining a table with itself):**
   This can be used to find relationships within the same table, such as finding employees who share the same manager.

   ```sql
   SELECT e1.first_name AS employee_name, e2.first_name AS manager_name
   FROM employees e1
   LEFT JOIN employees e2 ON e1.manager_id = e2.employee_id;
   ```

These examples showcase how to use different types of joins to combine data from the `employees` table and the `departments` table based on the `department_id` column. You can modify these queries based on your specific requirements and database structure. The syntax might vary depending on the specific database management system you're using (e.g., MySQL, PostgreSQL, SQL Server).

# Group By

Grouping data in SQL involves using the `GROUP BY` clause within the `SELECT` statement to group rows that share the same values in specified columns. Grouping is often used in conjunction with aggregate functions to perform calculations on grouped data. Here's how you can group data using SQL, along with examples:

Assume we have a table named `orders` with the following columns:

- order_id (Primary Key)
- order_date
- customer_id
- total_amount

1. **Basic GROUP BY:**
   Group rows by a single column.

   ```sql
   SELECT customer_id, COUNT(*) AS order_count
   FROM orders
   GROUP BY customer_id;
   ```

2. **Grouping by Multiple Columns:**
   Group rows by multiple columns.

   ```sql
   SELECT customer_id, YEAR(order_date) AS order_year, COUNT(*) AS order_count
   FROM orders
   GROUP BY customer_id, YEAR(order_date);
   ```

3. **Using Aggregate Functions with GROUP BY:**
   Perform calculations on grouped data using aggregate functions.

   ```sql
   SELECT customer_id, COUNT(*) AS order_count, SUM(total_amount) AS total_spent
   FROM orders
   GROUP BY customer_id;
   ```

4. **HAVING Clause:**
   Filter the groups using the `HAVING` clause, similar to the `WHERE` clause but applied after grouping.

   ```sql
   SELECT customer_id, COUNT(*) AS order_count
   FROM orders
   GROUP BY customer_id
   HAVING COUNT(*) > 3;
   ```

5. **GROUP BY with JOIN:**
   Group and aggregate data from multiple tables.

   ```sql
   SELECT c.customer_id, c.first_name, COUNT(o.order_id) AS order_count
   FROM customers c
   LEFT JOIN orders o ON c.customer_id = o.customer_id
   GROUP BY c.customer_id, c.first_name;
   ```

6. **GROUP BY with Date Functions:**
   Group data by date parts, such as year, month, day.

   ```sql
   SELECT YEAR(order_date) AS order_year, COUNT(*) AS order_count
   FROM orders
   GROUP BY YEAR(order_date)
   ORDER BY order_year;
   ```

7. **Using GROUP_CONCAT (Database-dependent):**
   Combine values from multiple rows into a single comma-separated value.

   ```sql
   SELECT department_id, GROUP_CONCAT(last_name ORDER BY last_name ASC) AS employees_list
   FROM employees
   GROUP BY department_id;
   ```

8. **Using STRING_AGG (PostgreSQL):**
   Similar to GROUP_CONCAT, but used in PostgreSQL.

   ```sql
   SELECT department_id, STRING_AGG(last_name, ', ') AS employees_list
   FROM employees
   GROUP BY department_id;
   ```

These examples demonstrate various ways to group and aggregate data using the `GROUP BY` clause. Grouping is essential for summarizing and analyzing data based on specific criteria. Be mindful of the syntax and behavior differences based on the database management system you're using (e.g., MySQL, PostgreSQL, SQL Server).

# Subquery

A subquery, also known as an inner query or nested query, is a query that is embedded within another query. Subqueries are used to retrieve data that will be used in the main query for various purposes, such as filtering, comparison, or aggregation. Here's how you can use subqueries in SQL, along with examples:

Assume we have two tables: `orders` and `customers`.

1. **Using a Subquery for Filtering:**
   Retrieve orders from customers who are located in 'New York'.

   ```sql
   SELECT order_id, order_date, customer_id
   FROM orders
   WHERE customer_id IN (SELECT customer_id FROM customers WHERE city = 'New York');
   ```

2. **Using a Subquery for Comparison:**
   Retrieve customers who have placed more orders than the average number of orders.

   ```sql
   SELECT first_name, last_name
   FROM customers
   WHERE (SELECT COUNT(*) FROM orders WHERE customer_id = customers.customer_id) >
         (SELECT AVG(order_count) FROM (SELECT customer_id, COUNT(*) AS order_count FROM orders GROUP BY customer_id) AS avg_orders);
   ```

3. **Using a Subquery in the SELECT Clause:**
   Retrieve customers along with the total amount of orders they've placed.

   ```sql
   SELECT first_name, last_name,
          (SELECT SUM(total_amount) FROM orders WHERE customer_id = customers.customer_id) AS total_spent
   FROM customers;
   ```

4. **Using a Subquery with Aggregate Functions:**
   Retrieve customers along with their highest order amount.

   ```sql
   SELECT first_name, last_name,
          (SELECT MAX(total_amount) FROM orders WHERE customer_id = customers.customer_id) AS highest_order_amount
   FROM customers;
   ```

5. **Using a Subquery with EXISTS:**
   Retrieve customers who have placed at least one order.

   ```sql
   SELECT first_name, last_name
   FROM customers
   WHERE EXISTS (SELECT * FROM orders WHERE customer_id = customers.customer_id);
   ```

6. **Using a Subquery in a JOIN:**
   Retrieve orders along with customer names for a specific city.

   ```sql
   SELECT o.order_id, o.order_date, c.first_name, c.last_name
   FROM orders o
   JOIN customers c ON o.customer_id = c.customer_id
   WHERE c.city = 'Los Angeles';
   ```

Subqueries are a powerful tool that allow you to create more complex queries by using the results of one query within another. They can be used in various parts of a query, including the `SELECT`, `FROM`, `WHERE`, `JOIN`, and other clauses. Keep in mind that the specific syntax and features might vary depending on the database management system you're using (e.g., MySQL, PostgreSQL, SQL Server).

# Modifying data

Modifying data in SQL involves using Data Manipulation Language (DML) statements to add, update, or delete records in a database. Here's how you can modify data using SQL, along with examples:

Assume we have a table named `employees` with the following columns:

- employee_id (Primary Key)
- first_name
- last_name
- department_id

1. **INSERT INTO:**
   Adds new records into a table.

   ```sql
   INSERT INTO employees (first_name, last_name, department_id)
   VALUES ('John', 'Doe', 2);
   ```

2. **UPDATE:**
   Modifies existing records in a table.

   ```sql
   UPDATE employees
   SET department_id = 3
   WHERE last_name = 'Doe';
   ```

3. **DELETE FROM:**
   Removes records from a table.

   ```sql
   DELETE FROM employees
   WHERE employee_id = 101;
   ```

4. **INSERT INTO with Subquery:**
   Adds records using data from another table.

   ```sql
   INSERT INTO employees (first_name, last_name, department_id)
   SELECT first_name, last_name, department_id
   FROM temporary_employees;
   ```

5. **UPDATE with Subquery:**
   Modifies records based on data from another table.

   ```sql
   UPDATE employees
   SET department_id = 4
   WHERE department_id = 2;
   ```

6. **DELETE with Subquery:**
   Removes records based on data from another table.

   ```sql
   DELETE FROM employees
   WHERE department_id = (SELECT department_id FROM departments WHERE department_name = 'HR');
   ```

7. **Using Transactions (BEGIN, COMMIT, ROLLBACK):**
   Ensures that a series of DML operations are treated as a single unit of work.

   ```sql
   BEGIN;
   INSERT INTO employees (first_name, last_name) VALUES ('Alice', 'Smith');
   UPDATE employees SET department_id = 5 WHERE last_name = 'Smith';
   COMMIT; -- Save changes

   -- ROLLBACK; -- Discard changes and undo the transaction
   ```

8. **Using AUTO_INCREMENT (Database-dependent):**
   Automatically generates unique values for an identity column.

   ```sql
   INSERT INTO orders (order_date, total_amount)
   VALUES ('2023-08-18', 500.00);
   ```

9. **Using RETURNING Clause (Database-dependent):**
   Retrieves values of generated columns after an insert or update.

   ```sql
   INSERT INTO employees (first_name, last_name)
   VALUES ('Jane', 'Williams')
   RETURNING employee_id;
   ```

10. **Using MERGE (Database-dependent):**
    Combines INSERT, UPDATE, and DELETE operations based on a condition.

    ```sql
    MERGE INTO target_table AS target
    USING source_table AS source
    ON (target.id = source.id)
    WHEN MATCHED THEN
        UPDATE SET target.value = source.new_value
    WHEN NOT MATCHED THEN
        INSERT (id, value) VALUES (source.id, source.new_value);
    ```

These examples demonstrate various ways to modify data using DML statements in SQL. Be cautious when performing data modifications, especially with `DELETE` and `UPDATE`, as they can have significant effects on your database. Always backup your data and test your queries in a safe environment before applying them to your production database. The syntax and behavior might vary depending on the specific database management system you're using (e.g., MySQL, PostgreSQL, SQL Server).


# Working with table structures

Working with table structures in SQL involves using Data Definition Language (DDL) statements to create, modify, and manage the structure of database tables. Here's how you can work with table structures using SQL, along with examples:

Assume we want to create or modify a table named `employees` with the following columns:

- employee_id (Primary Key)
- first_name
- last_name
- department_id (Foreign Key)

1. **Creating a Table:**
   Creates a new table with specified columns and data types.

   ```sql
   CREATE TABLE employees (
       employee_id INT PRIMARY KEY,
       first_name VARCHAR(50),
       last_name VARCHAR(50),
       department_id INT
   );
   ```

2. **Altering a Table (Adding Columns):**
   Modifies an existing table by adding new columns.

   ```sql
   ALTER TABLE employees
   ADD COLUMN hire_date DATE;
   ```

3. **Altering a Table (Modifying Columns):**
   Modifies the data type or constraints of an existing column.

   ```sql
   ALTER TABLE employees
   ALTER COLUMN first_name VARCHAR(60);
   ```

4. **Altering a Table (Dropping Columns):**
   Removes a column from an existing table.

   ```sql
   ALTER TABLE employees
   DROP COLUMN hire_date;
   ```

5. **Adding Primary Key Constraint:**
   Adds a primary key constraint to an existing column.

   ```sql
   ALTER TABLE employees
   ADD PRIMARY KEY (employee_id);
   ```

6. **Adding Foreign Key Constraint:**
   Adds a foreign key constraint to reference another table.

   ```sql
   ALTER TABLE employees
   ADD CONSTRAINT fk_department
   FOREIGN KEY (department_id) REFERENCES departments(department_id);
   ```

7. **Dropping a Constraint:**
   Removes a constraint from a table.

   ```sql
   ALTER TABLE employees
   DROP CONSTRAINT fk_department;
   ```

8. **Renaming a Table:**
   Renames an existing table.

   ```sql
   ALTER TABLE employees
   RENAME TO staff;
   ```

9. **Dropping a Table:**
   Deletes an existing table and its data.

   ```sql
   DROP TABLE employees;
   ```

10. **Copying a Table Structure (Database-dependent):**
    Creates a new table with the same structure as an existing table.

    ```sql
    CREATE TABLE new_employees AS
    SELECT * FROM employees WHERE 1 = 0;
    ```

11. **Truncating a Table:**
    Removes all records from a table while keeping its structure.

    ```sql
    TRUNCATE TABLE employees;
    ```

12. **Using Temporary Tables:**
    Creates a temporary table that is automatically dropped when the session ends.

    ```sql
    CREATE TEMPORARY TABLE temp_employees AS
    SELECT * FROM employees WHERE department_id = 2;
    ```

13. **Using Table Comments (Database-dependent):**
    Adds comments to describe the purpose of a table.

    ```sql
    COMMENT ON TABLE employees
    IS 'This table stores employee information.';
    ```

These examples demonstrate how to work with table structures using DDL statements in SQL. Properly designing and managing table structures is crucial for maintaining a well-organized and efficient database. The specific syntax and behavior might vary depending on the specific database management system you're using (e.g., MySQL, PostgreSQL, SQL Server).

# Constraints

Constraints in SQL are rules or conditions that you can apply to database tables to ensure data integrity and enforce business rules. Constraints help maintain the accuracy, consistency, and reliability of the data stored in the database. Here are some common types of constraints and how to use them in SQL, along with examples:

Assume we have a table named `employees` with the following columns:

- employee_id (Primary Key)
- first_name
- last_name
- department_id (Foreign Key)

1. **Primary Key Constraint:**
   Enforces the uniqueness and non-nullness of a column, typically used to identify each row uniquely.

   ```sql
   CREATE TABLE employees (
       employee_id INT PRIMARY KEY,
       first_name VARCHAR(50),
       last_name VARCHAR(50),
       department_id INT
   );
   ```

2. **Foreign Key Constraint:**
   Establishes a relationship between two tables by referencing the primary key of one table in another table.

   ```sql
   CREATE TABLE departments (
       department_id INT PRIMARY KEY,
       department_name VARCHAR(100)
   );

   CREATE TABLE employees (
       employee_id INT PRIMARY KEY,
       first_name VARCHAR(50),
       last_name VARCHAR(50),
       department_id INT,
       FOREIGN KEY (department_id) REFERENCES departments(department_id)
   );
   ```

3. **Unique Constraint:**
   Ensures that the values in a column or a group of columns are unique across the table.

   ```sql
   CREATE TABLE departments (
       department_id INT PRIMARY KEY,
       department_name VARCHAR(100) UNIQUE
   );
   ```

4. **Check Constraint:**
   Enforces a condition on the values that can be inserted or updated in a column.

   ```sql
   CREATE TABLE employees (
       employee_id INT PRIMARY KEY,
       first_name VARCHAR(50),
       last_name VARCHAR(50),
       department_id INT,
       salary DECIMAL(10, 2) CHECK (salary >= 0)
   );
   ```

5. **Default Constraint:**
   Sets a default value for a column when no value is specified during an insert.

   ```sql
   CREATE TABLE employees (
       employee_id INT PRIMARY KEY,
       first_name VARCHAR(50),
       last_name VARCHAR(50),
       hire_date DATE DEFAULT CURRENT_DATE
   );
   ```

6. **Not Null Constraint:**
   Ensures that a column cannot have null values.

   ```sql
   CREATE TABLE employees (
       employee_id INT PRIMARY KEY,
       first_name VARCHAR(50) NOT NULL,
       last_name VARCHAR(50) NOT NULL
   );
   ```

7. **Combining Constraints:**
   You can combine multiple constraints on a single column.

   ```sql
   CREATE TABLE employees (
       employee_id INT PRIMARY KEY,
       first_name VARCHAR(50) NOT NULL,
       last_name VARCHAR(50) NOT NULL,
       email VARCHAR(100) UNIQUE,
       salary DECIMAL(10, 2) CHECK (salary >= 0)
   );
   ```

8. **Dropping Constraints:**
   You can drop constraints from a table.

   ```sql
   ALTER TABLE employees
   DROP CONSTRAINT email_unique_constraint;
   ```

9. **Disabling Constraints (Database-dependent):**
   Temporarily disables constraints for data modifications.

   ```sql
   ALTER TABLE employees
   DISABLE CONSTRAINT email_unique_constraint;
   ```

These examples illustrate various types of constraints and how they can be applied to ensure data integrity and enforce rules in your database. The specific syntax and behavior might vary depending on the specific database management system you're using (e.g., MySQL, PostgreSQL, SQL Server).
