# 🕌 Lillah Welfare Foundation Management System

This is a **Java Swing desktop application** developed in **NetBeans IDE** with a **MySQL database** backend.  
It manages donors, donations, students, teachers, attendance, and other entities for the **Lillah Welfare Foundation**.

---

## 📂 Project Structure
- `src/` → Java source code (NetBeans GUI + logic classes)  
- `dist/` → Compiled `.jar` file + required libraries (run without opening NetBeans)  
- `Dump20250825.sql` → Database dump (import into MySQL)  
- `nbproject/` → NetBeans project configuration  
- `build.xml` → Ant build script  

---

## ⚙️ Requirements
- Java JDK 8+  
- NetBeans IDE (or any IDE that supports Ant projects)  
- MySQL database server  
- MySQL Connector/J (already included in `dist/lib`)  

---

## 🚀 How to Run
1. Import `Dump20250825.sql` into MySQL (creates the database + tables).  
2. Open the project in NetBeans.  
   - Or, simply run `dist/lillahwelfarefoundationms.jar` (make sure MySQL is running).  
3. Ensure MySQL connector is available (`dist/lib/mysql-connector-j-9.3.0.jar`).  
4. Update DB connection settings in `DBHandler.java` if your username/password differ.  

---

## 📌 Features
- Manage donors & donations  
- Track students, teachers, and attendance  
- CRUD operations for courses & categories  
- Database-driven GUI (NetBeans Matisse GUI Builder)  

---

## 🤝 Contributing
This project was created as part of a student project for **Lillah Welfare Foundation**.  
Feel free to fork and improve!

---
