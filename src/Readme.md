

🎓 Student Management System (Java + Oracle JDBC)

A menu-driven console application built using Java and JDBC that connects to an Oracle Database to manage student records.
This project demonstrates basic database operations like inserting and viewing data using JDBC.

✨ Features

➕ Insert student details into the database

📄 View all student records

🔗 JDBC connectivity with Oracle Database

🧑‍💻 Simple and interactive console interface

🛠️ Tech Stack

Java (JDK 8 or higher)

Oracle Database XE

JDBC (Oracle JDBC Driver)

SQL

📁 Project Structure
student-management-system/
│
├── studentapp.java
└── README.md

🗄️ Database Setup
Create Table

Execute the following SQL command in Oracle SQL Developer or SQL*Plus:

CREATE TABLE student (
NAME VARCHAR2(50),
AGE NUMBER,
SUBJECT VARCHAR2(50),
MARKS NUMBER
);

🔑 Database Configuration

The application uses the following database configuration (can be modified in code):

URL      : jdbc:oracle:thin:@localhost:1521:XE
Username : NK
Password : Khan@1204

