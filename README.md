# E-commerce API

A backend API of a e-commerce system developed with Spring Boot

---

## 🚀 Technologies Used:

- Java 21;
- Spring Boot;
- Spring Data JPA;
- MariaDB / MySQL;
- Maven.

---

## ⚙️ Requiriments

- Java 21;
- Maven;
- Database MariaDB ou MySQL.

## 🗄️ Database Configuration (Important)

This project was developed using MariaDB. If you prefer to use MySQL instead, follow these steps:

1. Open `application.properties`.
2. Comment out the MariaDB connection URL and uncomment the MySQL connection URL.
3. Open `pom.xml`.
4. Comment out the MariaDB JDBC dependency and uncomment the MySQL JDBC dependency.

To initialize the database, navigate to the `database` folder and execute the `script.sql` file using your preferred DBMS.

---

## ▶️ Running the Application

```bash
mvn spring-boot:run
```

or

```bash
./mvnw spring-boot:run
```

---

## 📦 Example Request

Example JSON body for the `POST /orders` endpoint:

```json
{
  "customer": "Guilherme",
  "shippingAddress": {
    "country": "Japan",
    "state": "Tokyo",
    "city": "Tokyo",
    "street": "Takeshita Street",
    "residenceNumber": 259,
    "apartment": 0
  },
  "paymentInfo": {
    "cardNumber": "1234 5678 1234 5678",
    "amount": 80.0,
    "description": "I got moneyy"
  },
  "productsList": [
    {
      "productId": 1,
      "quantity": 2
    },
    {
      "productId": 2,
      "quantity": 1
    },
    {
      "productId": 3,
      "quantity": 1
    }
  ]
}
```


