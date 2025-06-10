# SecureBank - Account Service

A secure Java microservice for handling account transfers.

---

## 🧱 Project Structure

```
securebank-account-service/
├── controller/              # REST controller
├── model/                   # Entity and request models
├── repository/              # Spring Data JPA interfaces
├── service/                 # Business logic
├── tests/                   # Unit and Integration tests
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

## 🚀 Running the Service (Dev Mode)

```bash
./mvnw spring-boot:run
```

---

## 🧪 Testing Strategy

### ✅ Unit Tests

- Located in: `TransferServiceTest.java`
- Tools: **JUnit 5**, **Mockito**, **AssertJ**

### ✅ Integration Tests with H2

- `AccountIntegrationTest.java`
- Uses `@SpringBootTest`, `MockMvc`, and **H2 in-memory DB**

### ✅ Integration Tests with PostgreSQL (Testcontainers)

- `PostgresTestcontainersTest.java` with:
  - `@DataJpaTest`
  - `@Testcontainers` + `PostgreSQLContainer`
  - Uses dynamic DB configuration

### 🔧 Testcontainers Config Class

- Reusable config in `TestcontainersConfig.java`
- Starts PostgreSQL container automatically for tests

---

## 🐳 Docker Compose (for local PostgreSQL)

```bash
docker-compose up -d
```

Access DB locally via:
- Host: `localhost`
- Port: `5432`
- User: `testuser`
- DB: `securebank`
- Password: `testpass`

---

## 📦 Building & Testing

```bash
./mvnw clean install
```

