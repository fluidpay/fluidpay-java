# How to Run Tests

## Prerequisites
Make sure Java is installed (see SETUP.md for installation instructions).

## Basic Commands

### Run all tests:
```bash
./gradlew test
```

### Run a specific test class:
```bash
./gradlew test --tests CustomersTest
./gradlew test --tests AuthenticationTest
./gradlew test --tests TransactionsTest
```

### Run tests with verbose output:
```bash
./gradlew test --info
```

### Run tests and see output in real-time:
```bash
./gradlew test --info --console=plain
```

## View Test Results

After running tests, view the HTML report:
```bash
open build/reports/tests/test/index.html
```

Or navigate to: `build/reports/tests/test/index.html` in your browser.

## Other Useful Commands

### Build the project (compiles code and runs tests):
```bash
./gradlew build
```

### Clean and rebuild:
```bash
./gradlew clean build
```

### Just compile (without running tests):
```bash
./gradlew compileJava
```

### Check what tasks are available:
```bash
./gradlew tasks
```

## Troubleshooting

### If you get "Permission denied" on gradlew:
```bash
chmod +x gradlew
```

### If Java version is wrong:
Check your JAVA_HOME:
```bash
echo $JAVA_HOME
java -version
```

### If tests fail due to API connection:
- Make sure you're using the correct API key in test files
- Check if you need to update the test API endpoint (sandbox vs production)
- Some tests may require network access to the Fluidpay API
