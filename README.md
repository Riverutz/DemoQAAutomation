# demoqa-ui-automation

Automated UI testing framework for [DemoQA](https://demoqa.com/), a practice website for QA automation engineers.

## 🛠️ Tech Stack

- **Java 17**
- **Selenium WebDriver**
- **TestNG**
- **Jackson** - JSON test data management
- **Log4j2** - Logging
- **Lombok** - Boilerplate code reduction
- **Maven** - Build and dependency management
- **Maven Surefire Plugin** - Test execution configuration

## 📁 Project Structure

    src/test/
    ├── java/
    │   ├── sharedData/        # BaseTest and BasePage classes
    │   ├── helperMethods/     # Reusable Selenium helper methods
    │   ├── objectdata/        # Jackson POJO classes for test data
    │   ├── loggerutility/     # LoggerUtility
    │   ├── pages/             # Page Object Model classes
    │   └── tests/             # Test classes
    └── resources/
        └── testdata/          # JSON test data files

## ✅ Test Scenarios

### Elements
- Web Tables (add, edit, delete record)

### Forms
- Practice Form (fill and verify full form submission)

### Alerts, Frames & Windows
- Browser Windows
- Alerts
- Frames
- Nested Frames

## ▶️ How to Run

1. Clone the repository `git clone https://github.com/Riverutz/demoqa-ui-automation.git`
2. Open in IntelliJ IDEA
3. Run all tests via `testng.xml`

## 🔄 CI/CD

Tests can be triggered manually via GitHub Actions in headless Chrome.

## 📋 Design Patterns

- **Page Object Model (POM)** - separates test logic from page structure
- **Data Driven Testing** - test data managed via JSON files
- **Base classes** - reusable setup and teardown logic