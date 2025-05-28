# Job Application Platform Backend

This is the backend for a microservices-based Job Application Platform. It provides REST APIs for managing jobs, companies, and reviews, and includes supporting infrastructure for configuration, service discovery, and API gateway.

---

## **Architecture Overview**

- **Microservices**:
  - **Jobs Microservice**: Manages job postings.
  - **Company Microservice**: Manages company profiles.
  - **Reviews Microservice**: Handles company/job reviews.
- **Gateway**: API Gateway for routing and security.
- **Config**: Centralized configuration management.
- **Service Discovery**: Eureka server for service registration and discovery.

---

## **Project Structure**

```
jobApp/
│
├── Application/
│   └── Java/
│       ├── companyMicroservice/
│       ├── jobsMicroservice/
│       └── reviewsMicroservice/
├── Config/
├── gateway/
├── deployment.yaml
├── docker-compose.yaml
└── ...
```

---

## **Getting Started**

### **Prerequisites**

- Java 17+
- Maven
- Docker (optional, for containerized deployment)

### **Running Locally**

1. **Clone the repository**
   ```sh
   git clone <repo-url>
   cd jobApp
   ```

2. **Start Config Server**
   ```sh
   cd Config
   mvn spring-boot:run
   ```

3. **Start Eureka Server**
   ```sh
   # If Eureka is a separate service, start it here
   ```

4. **Start Microservices**
   ```sh
   # In separate terminals:
   cd Application/Java/companyMicroservice
   mvn spring-boot:run

   cd Application/Java/jobsMicroservice
   mvn spring-boot:run

   cd Application/Java/reviewsMicroservice
   mvn spring-boot:run
   ```

5. **Start Gateway**
   ```sh
   cd gateway
   mvn spring-boot:run
   ```

6. **(Optional) Run with Docker Compose**
   ```sh
   docker-compose up --build
   ```

---

## **Configuration**

- Centralized configs are managed in the `Config` service.
- Each microservice reads its configuration from the config server at startup.

---

## **API Endpoints**

- **Gateway**: All requests are routed through the API gateway.
- **Jobs**: `/api/jobs`
- **Companies**: `/api/companies`
- **Reviews**: `/api/reviews`

> See each microservice's `README.md` or Swagger/OpenAPI docs for detailed endpoints.

---

## **Deployment**

- Use `docker-compose.yaml` for local multi-service deployment.
- Use `deployment.yaml` for Kubernetes or cloud deployments.

---

## **Development**

- Each microservice is a standalone Spring Boot project.
- Use your preferred IDE (e.g., VS Code, IntelliJ) for development and debugging.
- Configuration for VS Code is available in `.vscode/`.

---

## **Contributing**

1. Fork the repo
2. Create your feature branch (`git checkout -b feature/YourFeature`)
3. Commit your changes
4. Push to the branch
5. Open a pull request

---

## **License**

This project is licensed under the MIT License.

---

## **Related**

- [Frontend UI/UX Design Concept](frontend-ui-ux-idea.md)

---