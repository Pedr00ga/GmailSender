# Gmail SMTP Email Sender (Java)

![Java](https://img.shields.io/badge/Java-17%2B-blue)
![JavaMail](https://img.shields.io/badge/JavaMail-1.6.7-orange)
![Maven](https://img.shields.io/badge/Build-Maven-yellowgreen)

A simple Java application for sending emails through Gmail's SMTP server, created for educational purposes.

## 📌 About

This project was developed as a learning exercise to explore:
- Java libraries integration
- Maven dependency management
- JavaMail API for email functionality
- Dotenv for environment variable configuration
- SMTP protocol and email sending mechanics

## ✨ Features

- Secure SMTP connection with TLS encryption
- Environment variables configuration via `.env` file
- Debug mode for troubleshooting
- Configurable timeout settings
- Basic email sending functionality

## 🛠️ Technologies

- **Java 17+**
- **JavaMail API** - Email functionality
- **Dotenv** - Environment configuration
- **Maven** - Dependency management

## 📋 Prerequisites

- Gmail account with ["Less Secure Apps" enabled](https://myaccount.google.com/lesssecureapps) or [App Password](https://myaccount.google.com/apppasswords) if using 2FA
- Java 17+ JDK
- Maven installed

## 🚀 Getting Started

1. Clone the repository
2. Create a `.env` file with your credentials:
   ```
   GMAIL_USERNAME=your@gmail.com
   GMAIL_PASSWORD=yourpassword
   GMAIL_TO=recipient@email.com
   ```
3. Run with Maven: `mvn compile exec:java`

## 📚 Learning Outcomes

Through this project I learned:
- How to integrate external libraries in Java
- Maven project structure and dependencies
- SMTP protocol fundamentals
- Environment variable best practices
- Email authentication mechanisms

## 📜 License

This project is open-source and available under the MIT License.

---
