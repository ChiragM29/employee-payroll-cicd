# Employee Payroll System - CI/CD Pipeline

An automated, enterprise-ready Java project demonstrating Object-Oriented Programming (Abstract Classes and Inheritance), automated unit testing with **JUnit 5**, containerization with **Docker**, and continuous integration and deployment with **GitHub Actions**.

---

## 📋 Table of Contents
- [Project Overview](#project-overview)
- [Architecture & Design](#architecture--design)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Local Compilation & Execution](#local-compilation--execution)
- [JUnit 5 Test Suite](#junit-5-test-suite)
- [Docker Containerization](#docker-containerization)
- [GitHub Actions CI/CD Pipeline](#github-actions-cicd-pipeline)
- [License](#license)

---

## 🏢 Project Overview

The Employee Payroll System models employee compensation using an abstract base class and polymorphism:
1. **`Employee`** (Abstract Class): Contains `employeeId` and `employeeName`, declares abstract method `calculateSalary()`, and implements `displayDetails()` to print employee information and calculated compensation.
2. **`PermanentEmployee`** (Subclass): Implements `calculateSalary()` by adding a fixed allowance of **₹5,000.0** to `basicSalary` (`basicSalary + 5000.0`).
3. **`ContractEmployee`** (Subclass): Implements `calculateSalary()` by computing total earnings based on hours worked and hourly rate (`workingHours * hourlyRate`).
4. **`Main`**: Demonstrates polymorphic behavior by instantiating objects of both subclasses, calculating their salaries, and displaying output.

---

## 📁 Project Structure

```text
employee-payroll-cicd/
├── pom.xml
├── Dockerfile
├── .dockerignore
├── .gitignore
├── README.md
├── .github/
│   └── workflows/
│       └── ci.yml
└── src/
    ├── main/java/com/example/
    │   ├── Employee.java
    │   ├── PermanentEmployee.java
    │   ├── ContractEmployee.java
    │   └── Main.java
    └── test/java/com/example/
        └── EmployeeTest.java
```

---

## ⚙️ Prerequisites

- **Java JDK**: 17 or higher
- **Maven**: 3.9+ (or build via Docker/javac)
- **Docker**: Optional for container build and execution
- **Git**: For version control

---

## 🚀 Local Compilation & Execution

### Option 1: Using Maven
```bash
# Compile and run unit tests
mvn clean test

# Package the application JAR
mvn clean package

# Run the packaged JAR
java -jar target/employee-payroll-cicd-1.0-SNAPSHOT.jar
```

### Option 2: Using Standard JDK (Javac / Java)
```bash
# Compile Main classes
javac -d target/classes src/main/java/com/example/*.java

# Run Main class
java -cp target/classes com.example.Main
```

---

## 🧪 JUnit 5 Test Suite

The test suite in `src/test/java/com/example/EmployeeTest.java` validates business logic:
- `testPermanentEmployeeSalary()`: Validates that basic salary + fixed allowance of ₹5000.0 evaluates correctly (e.g. 30000.0 -> 35000.0).
- `testPermanentEmployeeZeroBasic()`: Validates that zero basic salary returns exactly the ₹5000.0 allowance.
- `testContractEmployeeSalary()`: Validates that contract salary correctly multiplies `workingHours * hourlyRate` (e.g. 160 * 200.0 -> 32000.0).
- `testContractEmployeeZeroHours()`: Validates that 0 working hours results in 0.0 salary.
- `testEmployeeDetailsNotNull()`: Validates instance initialization and non-null properties.

---

## 🐳 Docker Containerization

The multi-stage `Dockerfile` optimizes build reproducibility and runtime image size:

```bash
# Build the Docker image
docker build -t employee-payroll-cicd .

# Run the Docker container
docker run --rm employee-payroll-cicd
```

---

## 🔄 GitHub Actions CI/CD Pipeline

The workflow defined in `.github/workflows/ci.yml` consists of:
1. **`build-and-test`**:
   - Checks out repository code on `ubuntu-latest`.
   - Configures Eclipse Temurin JDK 17 with Maven dependency caching.
   - Executes `mvn -B clean verify` (compilation and JUnit 5 test execution).
2. **`docker-build-push`**:
   - Depends on `build-and-test`.
   - Logs into Docker Hub using GitHub Repository Secrets (`DOCKERHUB_USERNAME` and `DOCKERHUB_TOKEN`).
   - Builds and pushes multi-tag Docker images (`latest` and `${{ github.sha }}`).
