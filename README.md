# SkillSwap Barter System

SkillSwap is a desktop application developed in Java using Swing that allows users to register their skills and find other users with complementary skills for bartering. It provides an intuitive graphical interface and manages user data through a MySQL database.

## 📁 Project Structure

skillswap/
├── .idea/ # IntelliJ project files
├── src/
│ ├── com/skillswap/
│ │ ├── dao/ # Data Access Object classes
│ │ ├── model/ # Java models (User.java)
│ │ ├── ui/ # Swing UI components (Login, Register, Dashboard)
│ │ └── util/ # Database connection utility
│ ├── resources/
│ │ └── images/ # Background images
├── .gitignore
├── skillswap.iml
└── README.md

---

## ✅ Features

- **User Registration** with fields: name, email, password, skills, availability, and preferred exchange method.
- **Login System** with authentication check from MySQL database.
- **Dashboard** UI loaded post login with user info.
- **Form validation** for empty fields and formatting.
- **Database Integration** using JDBC with `skillswapdb`.
  
---


## 🛡️ Validation & Error Handling

- Validates empty fields before submitting.
- Displays user-friendly error messages on incorrect login or DB failures.
- Ensures database constraints (e.g. no duplicate emails) using SQL logic.

---

## 🛠️ Technologies Used

- **Java** - Core language
- **Swing** - GUI development
- **MySQL** - Database
- **JDBC** - Java Database Connectivity
- **IntelliJ IDEA** - Development environment
- **Git & GitHub** - Version control and collaboration

---
**Set up MySQL Database

Create a database named skillswapdb

Create a users table using the schema from your DAO class or sample SQL script.

Configure DB Credentials**

**Edit DBConnection.java with your MySQL username and password:**
private static final String URL = "jdbc:mysql://localhost:3306/skillswapdb";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";


## 💾 Database Schema

```sql
CREATE TABLE users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  email VARCHAR(100) UNIQUE,
  skill_offered VARCHAR(100),
  skill_needed VARCHAR(100),
  password VARCHAR(100),
  availability VARCHAR(100),
  exchange_method VARCHAR(100)
);



UI Design:-

SkillSwap’s interface uses Java Swing components with responsive layouts. Background images and clear alignment enhance the aesthetics. Components reposition based on window resizing for better usability.


How to Run:-
1. Clone the repository:- git clone https://github.com/KOTOxSHISUI/SkillSwap-Barter-System.git


2. Open the project in IntelliJ IDEA.

3. Set up MySQL and create the users table using the schema above.

4. Update your DB credentials in DBConnection.java.

5. Run the project from LoginForm.java or UserRegistrationForm.java.


LICENSE:-
This project is for academic use and is not licensed for commercial distribution.
