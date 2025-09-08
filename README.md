# Brainwave Matrix Solutions
```markdown
# 💳 ATM Application (Java)

This is a simple **ATM (Automated Teller Machine) simulation** written in Java.  
It allows a user to authenticate, check balance, deposit money, withdraw money, view transaction history, and even change their PIN.

---

## 🚀 Features
- 🔑 **User Authentication** (User ID & PIN)
- 💰 **Check Balance**
- ➕ **Deposit Money**
- ➖ **Withdraw Money** (with insufficient balance check)
- 📜 **Transaction History**
- 🔒 **Change PIN**
- 📝 **Transaction Notes** (logs every operation)

---

## 🛠️ Technologies Used
- Java (`java.util.Scanner`, `java.util.List`, `java.util.ArrayList`)
- Object-Oriented Programming (OOP) concepts:
  - Classes (`ATM`, `BankAccount`, `ATM_Application`)
  - Encapsulation
  - Exception Handling

---

## 📂 Project Structure
```

ATM\_Application.java
├── ATM\_Application (Main class to start the ATM)
├── BankAccount (Represents user's bank account & transactions)
└── ATM (Handles user interaction & ATM operations)

````

---

## ▶️ How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/ATM-Application.git
   cd ATM-Application
````

2. **Compile the Java file**

   ```bash
   javac ATM_Application.java
   ```

3. **Run the program**

   ```bash
   java ATM_Application
   ```

---

## 👤 Default Credentials

* **User ID:** `user123`
* **PIN:** `1234`
* **Initial Balance:** `$1000.0`

---

## 🖼️ Sample Output

```
Welcome to the ATM!
Enter User ID: user123
Enter PIN: 1234

--- ATM Menu ---
1. Check Balance
2. Deposit
3. Withdraw
4. View Transaction History
5. Change PIN
6. Exit
Choose an option:
```

---

## ✅ Example Transactions

* Deposit `$500` → Balance updated, history logged.
* Withdraw `$200` → Balance updated, history logged.
* Change PIN → Requires old PIN verification.

---

## 📜 License

This project is open-source and available under the [MIT License](LICENSE).

---

👨‍💻 Developed by **Satyam Kumar**


