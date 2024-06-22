# Java Web Application with CRUD Operations

This repository contains a Java web application that demonstrates full CRUD operations using Servlets, JSP, and MySQL. The application features user registration and login forms, with a Bootstrap-powered frontend.

## Features

- **User Registration**: Allows new users to register with a username, password, and email.
- **User Login**: Authenticates users with their username and password.
- **CRUD Operations**: 
  - **Create**: Add new user information.
  - **Read**: Retrieve user information.
  - **Update**: Modify existing user information.
  - **Delete**: Remove user information.

## Technologies Used

- **Backend**: Java Servlets, JSP
- **Frontend**: HTML, CSS, Bootstrap
- **Database**: MySQL

## Setup and Installation

1. **Clone the repository**:  git clone https://github.com/aadityakasaudhan/curd-java.git
2. **Set up the database**:
    CREATE DATABASE RLogin;
    USE RLogin;
   CREATE TABLE Login (
    id INT AUTO_INCREMENT PRIMARY KEY,
    uname VARCHAR(50),
    password VARCHAR(50),
    email VARCHAR(50)
);
