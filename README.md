# E-Commerce-Platform-with-admin-panel

A Java-based e-commerce platform built with Swing GUI components. This application allows users to register, log in, browse products, add items to a cart, view order history, and for administrators to manage inventory through an admin panel.

---

## 💡 Features

### 👤 Customer
- Customer Registration and Login
- Product browsing
- Add products to cart
- Checkout process
- Order history tracking

### 🛠️ Admin
- Admin Login
- Add and update products
- View all products and orders
- User management (view registered users)

---

## 🛠️ Tech Stack

- **Programming Language:** Java
- **GUI:** Swing
- **Data Storage:** Flat file-based storage (no database integration yet)
- **IDE:** VS code / Eclipse / IntelliJ IDEA

---

## 🗂️ Project Structure
Ecommerce_platform_with_admin_panel/
├── Main.java                  # Launch point of the application
├── LoginForm.java            # Login screen for admin & users 
├── RegisterForm.java         # Registration screen for users 
├── MainMenu.java             # Welcome menu screen
├── AdminMenu.java            # Admin dashboard 
├── UserMenu.java             # User dashboard 
├── AddProductWindow.java     # Admin's interface to add new products
├── Product.java              # Product entity class 
├── ProductDB.java            # File-based product data handling
├── OrderDB.java              # File-based order handling
├── UserDB.java               # File-based user data handling

---
🔐 Default Credentials

Admin

Username: admin

Password: Admin@123


User

Username: user1

Password: User@123


> You can modify or add more credentials by editing the UserDB.java file.




---
🚀 Future Enhancements

Database integration (e.g., MySQL or MongoDB)

User authentication with password hashing

Real-time product updates

Payment gateway simulation

Responsive GUI redesign



---
