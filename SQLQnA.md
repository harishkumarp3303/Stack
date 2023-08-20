Certainly! Here's a list of top 30 SQL interview questions tailored for candidates with around 2 years of experience, along with examples for each question:

1. **Retrieve Data:**
   
   Q1: Retrieve all records from the "Customers" table.
   
   ```sql
   SELECT * FROM Customers;
   ```

   Q2: Retrieve the names of customers from the "Customers" table.
   
   ```sql
   SELECT FirstName, LastName FROM Customers;
   ```

2. **Filtering and Sorting:**
   
   Q3: Retrieve the names of employees whose salary is greater than $50,000.
   
   ```sql
   SELECT FirstName, LastName FROM Employees WHERE Salary > 50000;
   ```

   Q4: Retrieve the names of products sorted in descending order of their prices.
   
   ```sql
   SELECT ProductName FROM Products ORDER BY Price DESC;
   ```

3. **Joins and Relationships:**
   
   Q5: Retrieve the names of customers along with their orders.
   
   ```sql
   SELECT c.FirstName, c.LastName, o.OrderID
   FROM Customers c
   JOIN Orders o ON c.CustomerID = o.CustomerID;
   ```

   Q6: Retrieve the names of employees and their managers (if available).
   
   ```sql
   SELECT e.FirstName AS Employee, m.FirstName AS Manager
   FROM Employees e
   LEFT JOIN Employees m ON e.ManagerID = m.EmployeeID;
   ```

4. **Subqueries:**
   
   Q7: Retrieve the names of customers who placed orders in the last month.
   
   ```sql
   SELECT FirstName, LastName
   FROM Customers
   WHERE CustomerID IN (
       SELECT CustomerID
       FROM Orders
       WHERE OrderDate >= DATEADD(MONTH, -1, GETDATE())
   );
   ```

   Q8: Retrieve the names of employees who earn more than the average salary in their department.
   
   ```sql
   SELECT FirstName, LastName
   FROM Employees e
   WHERE Salary > (
       SELECT AVG(Salary)
       FROM Employees
       WHERE DepartmentID = e.DepartmentID
   );
   ```

5. **Grouping and Aggregation:**
   
   Q9: Calculate the total sales amount for each product.
   
   ```sql
   SELECT ProductID, SUM(Amount) AS TotalSales
   FROM Sales
   GROUP BY ProductID;
   ```

   Q10: Retrieve the department names along with the average salary in each department.
   
   ```sql
   SELECT Department, AVG(Salary) AS AvgSalary
   FROM Employees
   GROUP BY Department;
   ```

6. **Common SQL Functions:**
   
   Q11: Calculate the total number of orders placed by each customer.
   
   ```sql
   SELECT CustomerID, COUNT(*) AS TotalOrders
   FROM Orders
   GROUP BY CustomerID;
   ```

   Q12: Retrieve the top 5 highest earning employees.
   
   ```sql
   SELECT FirstName, LastName, Salary
   FROM Employees
   ORDER BY Salary DESC
   LIMIT 5;
   ```

7. **Working with Dates:**
   
   Q13: Retrieve orders placed on a specific date.
   
   ```sql
   SELECT OrderID, OrderDate
   FROM Orders
   WHERE OrderDate = '2023-08-01';
   ```

   Q14: Calculate the age of employees based on their birthdates.
   
   ```sql
   SELECT FirstName, LastName, DATEDIFF(YEAR, Birthdate, GETDATE()) AS Age
   FROM Employees;
   ```

8. **Updating Records:**
   
   Q15: Update the price of a product with a specific ProductID.
   
   ```sql
   UPDATE Products
   SET Price = 25.99
   WHERE ProductID = 123;
   ```

   Q16: Mark an order as shipped with a specific OrderID.
   
   ```sql
   UPDATE Orders
   SET Shipped = 1
   WHERE OrderID = 456;
   ```

9. **Deleting Records:**
   
   Q17: Delete a customer record based on their CustomerID.
   
   ```sql
   DELETE FROM Customers
   WHERE CustomerID = 'C123';
   ```

   Q18: Delete all orders placed before a specific date.
   
   ```sql
   DELETE FROM Orders
   WHERE OrderDate < '2023-01-01';
   ```

10. **Views:**
    
    Q19: Create a view to display the names and salaries of employees in the "Finance" department.
   
    ```sql
    CREATE VIEW FinanceEmployees AS
    SELECT FirstName, LastName, Salary
    FROM Employees
    WHERE Department = 'Finance';
    ```

    Q20: Retrieve data from the created view.
   
    ```sql
    SELECT * FROM FinanceEmployees;
    ```

11. **Subquery vs. JOIN:**

    Q21: Retrieve the names of customers who placed orders in the same month as the "Smith" customer.
   
    ```sql
    SELECT FirstName, LastName
    FROM Customers
    WHERE CustomerID IN (
        SELECT CustomerID
        FROM Orders
        WHERE OrderDate >= (
            SELECT MIN(OrderDate)
            FROM Orders
            WHERE CustomerID = 'Smith'
        )
    );
    ```

    Q22: Achieve the same result using JOINs.
   
    ```sql
    SELECT DISTINCT c.FirstName, c.LastName
    FROM Customers c
    JOIN Orders o ON c.CustomerID = o.CustomerID
    JOIN Orders o2 ON c.CustomerID = o2.CustomerID
    WHERE MONTH(o.OrderDate) = MONTH(o2.OrderDate) AND YEAR(o.OrderDate) = YEAR(o2.OrderDate)
    AND o2.CustomerID = 'Smith';
    ```

12. **Self-Joins:**

    Q23: Retrieve the names of employees and their managers (if available).
   
    ```sql
    SELECT e.FirstName AS Employee, m.FirstName AS Manager
    FROM Employees e
    LEFT JOIN Employees m ON e.ManagerID = m.EmployeeID;
    ```

    Q24: Retrieve the names of employees along with their direct subordinates (if available).
   
    ```sql
    SELECT m.FirstName AS Manager, s.FirstName AS Subordinate
    FROM Employees m
    LEFT JOIN Employees s ON m.EmployeeID = s.ManagerID;
    ```

13. **Handling NULL Values:**
    
    Q25: Retrieve the names of employees who do not have a manager.
   
    ```sql
    SELECT FirstName, LastName
    FROM Employees
    WHERE ManagerID IS NULL;
    ```

    Q26: Retrieve the names of products and their prices, replacing NULL prices with 0.
   
    ```sql
    SELECT ProductName, COALESCE(Price, 0) AS Price
    FROM Products;
    ```

14. **Indexes and Performance:**
    
    Q27: Create an index on the "LastName" column of the "Customers" table.
   
    ```sql
    CREATE INDEX idx_LastName ON Customers(LastName);
    ```

    Q28: Optimize a query to retrieve the total sales amount for a specific product.
   
    ```sql
    SELECT SUM(Amount) AS TotalSales
    FROM Sales
    WHERE ProductID = 123;
    ```

15. **Normalization and Database Design:**

   

 Q29: Define a schema for an "Orders" table.
   
    ```sql
    CREATE TABLE Orders (
        OrderID INT PRIMARY KEY,
        CustomerID VARCHAR(10),
        OrderDate DATE,
        TotalAmount DECIMAL(10, 2)
    );
    ```

    Q30: Define a schema for a "Products" table with a foreign key reference.
   
    ```sql
    CREATE TABLE Products (
        ProductID INT PRIMARY KEY,
        ProductName VARCHAR(50),
        CategoryID INT,
        Price DECIMAL(10, 2),
        FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID)
    );
    ```

These SQL interview questions and examples cover a range of topics commonly tested during interviews for candidates with around 2 years of experience. It's important to understand the underlying concepts and practice writing and executing SQL queries to effectively showcase your skills during an interview.