CREATE TABLE Employee_Ortega
(
	EmployeeId      INT PRIMARY KEY AUTO_INCREMENT, -- Using AUTO_INCREMENT to auto-increment the EmployeeId
    FirstName       VARCHAR(50) NOT NULL,
    LastName        VARCHAR(50) NOT NULL,
    DateOfBirth     DATE NOT NULL,
    Address         VARCHAR(100) NOT NULL,
    Gender          CHAR(1) NOT NULL,
    Salary          INT NOT NULL,
    DepartmentId    INT NOT NULL
);

CREATE TABLE Department_Ortega
(
    DepartmentId    INT PRIMARY KEY AUTO_INCREMENT, -- Using AUTO_INCREMENT to auto-increment the DepartmentId
    DepartmentName  VARCHAR(50) NOT NULL
);

CREATE TABLE Location_Ortega
(
    LocationId      INT PRIMARY KEY AUTO_INCREMENT, -- Using AUTO_INCREMENT to auto-increment the LocationId
    DepartmentId    INT NOT NULL,
    Location        VARCHAR(50) NOT NULL
);

drop table Employee_Ortega;

select * from Employee_Ortega;
select * from Department_Ortega;
select * from Location_Ortega;



SELECT 
    DepartmentName, COUNT(EmployeeId) AS NumberEmployees
FROM 
    Department_Ortega, Employee_Ortega
WHERE 
    Department_Ortega.DepartmentId = Employee_Ortega.DepartmentId
    AND Department_Ortega.DepartmentId IN (
        SELECT 
            DepartmentId
        FROM 
            Employee_Ortega
        GROUP BY 
            DepartmentId
        HAVING 
            AVG(Salary) > 30000
    )
GROUP BY 
    Department_Ortega.DepartmentId, DepartmentName;






INSERT INTO Employee_Ortega (FirstName, LastName, DateOfBirth, Address, Gender, Salary, DepartmentId)
VALUES ('John', 'Smith', '1965-01-09', '731 Fondren, Houston, TX', 'M', 30000, 1);

INSERT INTO Employee_Ortega (FirstName, LastName, DateOfBirth, Address, Gender, Salary, DepartmentId)
VALUES ('Franklin', 'Wong', '1955-12-08', '638 Voss, Houston, TX', 'M', 40000, 1);

INSERT INTO Employee_Ortega (FirstName, LastName, DateOfBirth, Address, Gender, Salary, DepartmentId)
VALUES ('Alicia', 'Zelaya', '1968-01-19', '3321 Casle, Spring, TX', 'F', 25000, 2);

INSERT INTO Employee_Ortega (FirstName, LastName, DateOfBirth, Address, Gender, Salary, DepartmentId)
VALUES ('Jennifer', 'Wallace', '1941-06-20', '291 Berry, Bellaire, TX', 'F', 43000, 2);

INSERT INTO Employee_Ortega (FirstName, LastName, DateOfBirth, Address, Gender, Salary, DepartmentId)
VALUES ('Ramesh', 'Narayan', '1962-09-15', '975 Fire Oak, Humble, TX', 'M', 38000, 1);

INSERT INTO Employee_Ortega (FirstName, LastName, DateOfBirth, Address, Gender, Salary, DepartmentId)
VALUES ('Joyce', 'English', '1972-07-31', '5631 Rice, Houston, TX', 'F', 25000, 1);

INSERT INTO Employee_Ortega (FirstName, LastName, DateOfBirth, Address, Gender, Salary, DepartmentId)
VALUES ('Ahmad', 'Jabbar', '1969-03-29', '980 Dallas, Houston, TX', 'M', 25000, 2);

INSERT INTO Employee_Ortega (FirstName, LastName, DateOfBirth, Address, Gender, Salary, DepartmentId)
VALUES ('James', 'Borg', '1937-11-10', '450 Stone, Houston, TX', 'M', 55000, 3);

INSERT INTO Department_Ortega (DepartmentName)
VALUES ('Research');

INSERT INTO Department_Ortega (DepartmentName)
VALUES ('Administration');

INSERT INTO Department_Ortega (DepartmentName)
VALUES ('Headquarters');

INSERT INTO Location_Ortega (DepartmentId, Location)
VALUES (3, 'Houston');

INSERT INTO Location_Ortega (DepartmentId, Location)
VALUES (2, 'Stafford');

INSERT INTO Location_Ortega (DepartmentId, Location)
VALUES (1, 'Bellaire');

INSERT INTO Location_Ortega (DepartmentId, Location)
VALUES (1, 'Sugarland');

INSERT INTO Location_Ortega (DepartmentId, Location)
VALUES (1, 'Houston');
