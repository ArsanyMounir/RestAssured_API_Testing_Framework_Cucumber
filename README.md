
# RestAssured API Testing Framework

A robust, scalable API Test Automation Framework built using Java, RestAssured, Cucumber, and Maven. This framework is designed from scratch to support behavior-driven development (BDD) practices and can be easily integrated into a CI/CD pipeline using Jenkins.

## 🚀 Features

- ✅ Maven Project with Cucumber and RestAssured Dependencies
- ✅ Structured Project Architecture following BDD with Cucumber
- ✅ Reusable Request and Response Specifications (Utils Layer)
- ✅ POJO Classes for JSON Serialization/Deserialization
- ✅ Logging of Requests and Responses for Debugging
- ✅ End-to-End API Test Coverage with Assertions
- ✅ Global Configuration using .properties Files
- ✅ Enum-based Resource Management
- ✅ Data-Driven Testing using Cucumber Examples
- ✅ Selective Execution using Tagging
- ✅ Pre/Post Conditions using Cucumber Hooks
- ✅ Maven Command Execution for Local and CI Runs
- ✅ Jenkins Integration with Parameterized Builds
- ✅ HTML Report Generation

---

## 📁 Project Structure

```
src
├── test
│   ├── java
│   │   ├── stepDefinitions/       # Cucumber Step Definitions
│   │   ├── resources/             # API Resource Endpoints as Enum
│   │   ├── utils/                 # Request/Response Spec & Config Utils
│   │   ├── pojo/                  # POJO Classes for Payload Mapping
│   │   └── hooks/                 # Cucumber Hooks for Setup/Teardown
│   └── resources
│       ├── features/              # Cucumber Feature Files
│       └── global.properties      # Global Test Configuration
```

---

## How to Run

1. Clone the Repository:

```bash
git clone https://github.com/your-username/restassured-api-framework.git
cd restassured-api-framework
```

2. Update global.properties with your base URI and any environment-specific values.

3. Run with Maven:

```bash
mvn clean verify
```

4. Run Specific Tagged Scenarios:

```bash
mvn test -Dcucumber.filter.tags="@AddPlace"
```

---

## 🔧 Jenkins Integration

- Create a Freestyle or Pipeline job.
- Add the following build step:

```bash
mvn clean test -Denv=staging -Dcucumber.filter.tags="@AddPlace"
```

- Pass parameters to Jenkins for environment or tag selection dynamically.

---

## 📊 Reports

- Default Cucumber Reports: target/cucumber-reports
- Optionally integrate Allure or Extent Reports for enhanced test reporting.


