# Chat App Backend

This is the Spring Boot (Java) backend for the Chat App.

---

## Prerequisites
- Java 17+
- PostgreSQL (or update DB config in `src/main/resources/application.properties`)

---

## Development

```
cd chat-app-backend
./gradlew bootRun
```
Backend runs on [http://localhost:8080](http://localhost:8080)

---

## Serving Frontend in Production

1. Build the frontend (`chat-app-frontend`):
   ```
   npm run build
   ```
2. Copy the build output to `src/main/resources/static` in this backend project.
3. Start the backend:
   ```
   ./gradlew bootRun
   ```
4. Access the app at [http://localhost:8080](http://localhost:8080)

---

## Configuration
- Database and JWT settings: see `src/main/resources/application.properties`

---

See the main project README for full-stack setup and features. 