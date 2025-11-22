## 📌 **Overview**

This project is a simple **Student Management System** built using:

* **Java Servlets (Jakarta Servlet API)**
* **HTML + CSS (Frontend UI)**
* **MySQL Database**
* **JDBC**
* **Tomcat Server**

The system allows users to:

* ✔️ Register a Student
* ✔️ Update Student Details
* ✔️ Delete Student by ID
* ✔️ Search Student by ID
* ✔️ View All Students

This project is perfect for learning **Servlets, JDBC, CRUD Operations, Form Handling, and Web Development Basics.**

---
##📸 **Application Screenshots**

**🏠 Home Page**
<img width="1642" height="720" alt="image" src="https://github.com/user-attachments/assets/6215b75e-74ae-4350-9737-de197048b208" />

**📝 Register Student Page**
<img width="1915" height="916" alt="image" src="https://github.com/user-attachments/assets/faae80bb-b4f2-4e71-b5d8-6b385d6ceae3" />

**🗑 Delete Student Page**
<img width="1905" height="901" alt="image" src="https://github.com/user-attachments/assets/b8af58ad-4766-40f0-90ef-88a8a5c9ee93" />

**🔍 Search Student Page**
<img width="1899" height="910" alt="image" src="https://github.com/user-attachments/assets/f6b0fa9d-11a8-49c2-a956-59e84c2436ff" />

**📋 View All Students Page**
<img width="1891" height="999" alt="image" src="https://github.com/user-attachments/assets/de503e1b-b126-482d-9a24-303247c55943" />


## 📁 **Project Structure**


```
src/
└── com/java/
    ├── RegisterServlet.java
    ├── UpdateServlet.java
    ├── DeleteByID.java
    ├── SearchServlet.java
webapp/
├── index.html
├── register.html
├── update.html
├── delete.html
├── search.html
├── view.html
└── style.css
```

---

## 🗄️ **Database Configuration (MySQL)**

Create a database:

```sql
CREATE DATABASE 43r;
```

Create the `students` table:

```sql
CREATE TABLE students (
    studentId VARCHAR(10) PRIMARY KEY,
    studentName VARCHAR(50),
    email VARCHAR(50),
    course VARCHAR(50),
    age INT
);
```

---

## 🔌 **Database Connection Used in Servlets**

All servlets connect using JDBC:

```java
con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/43r",
    "root",
    "root18"
);
```

Make sure:

✔ MySQL is running
✔ Database name, username, password match your system

---

## 🚀 **Features (CRUD Operations)**

### ✔️ 1. **Register Student**

Handled by: `RegisterServlet.java`

* Inserts new student data into MySQL
* Called from `register.html`

---

### ✔️ 2. **Search Student by ID**

Handled by: `SearchServlet.java`

* Fetches record by studentId
* Displays results in HTML table

---

### ✔️ 3. **Delete Student by ID**

Handled by: `DeleteByID.java`

* Uses `DELETE FROM students WHERE studentId=?`
* Shows success/error messages
* Connected to `delete.html`

---

### ✔️ 4. **Update Student**

Handled by: `UpdateServlet.java` (You will add this in future)

---

### ✔️ 5. **View All Students**

Handled by: `view.html` (Backend servlet can be added)

---

## 🌐 **Web Pages Included**

### ✔️ `index.html`

Main dashboard with buttons:

* Register
* Update
* Delete
* Search
* View All Students

### ✔️ `register.html`

Form for registering a new student.

### ✔️ `search.html`

Form to search student by ID.

### ✔️ `delete.html`

Form to delete student by ID.

### ✔️ `update.html`

Form to update student details.

### ✔️ `view.html`

Displays all students (requires backend servlet).

### ✔️ `style.css`

Designs the UI using modern form layout.

---

## ⚙️ **How to Run the Project**

### **1. Prerequisites**

* JDK 8 or above
* Apache Tomcat (v9 or v10)
* MySQL
* Eclipse / IntelliJ / VS Code

---

### **2. Steps to Run**

#### **Step 1 — Import the Project**

Open your IDE and import as a **Dynamic Web Project**
(or Maven Project, if using Maven).

#### **Step 2 — Add Libraries**

Add:

✔ `jakarta.servlet-api.jar`
✔ `mysql-connector-j.jar`

#### **Step 3 — Configure Database**

Create database and table (see above).

#### **Step 4 — Start Tomcat Server**

Right-click → Run on Server.

#### **Step 5 — Visit the Application**

Open browser:

```
http://localhost:8080/your-project-name/index.html
```

---

## 🧪 **Testing Each Feature**

### ✔ Register Student

Fill form → Submit → Data goes to MySQL.

### ✔ Search Student

Enter ID → Result displayed in table.

### ✔ Delete Student

Enter ID → Record removed from MySQL.

### ✔ Update Student

(After adding UpdateServlet)

---

## 🛠️ **Technologies Used**

| Technology      | Purpose               |
| --------------- | --------------------- |
| Java (Servlets) | Backend logic         |
| HTML5           | UI forms/pages        |
| CSS3            | Page styling          |
| JDBC            | Database connectivity |
| MySQL           | Data storage          |
| Tomcat Server   | Run web app           |

---

## 📌 **Future Enhancements**

* Add JSP pages to reduce HTML code
* Add full Update functionality
* Add “View All Students” backend servlet
* Add form validations
* Use MVC architecture
* Use DAO + Service Layer
* Convert to Spring Boot project

---

## 📜 **License**

Free to use for study and academic projects.
