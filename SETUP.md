# Java Development Setup for Mac

This guide will help you set up Java to run and test this project on your Mac.

## Step 1: Install Java JDK

### Option A: Using Homebrew (Recommended)

```bash
# Install Java 17 (LTS version)
brew install openjdk@17

# Link it so it's available system-wide
sudo ln -sfn /opt/homebrew/opt/openjdk@17/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-17.jdk

# Add to your PATH (adds to ~/.zshrc)
echo 'export PATH="/opt/homebrew/opt/openjdk@17/bin:$PATH"' >> ~/.zshrc
echo 'export JAVA_HOME="/opt/homebrew/opt/openjdk@17"' >> ~/.zshrc
source ~/.zshrc
```

### Option B: Download from Adoptium

1. Visit https://adoptium.net/
2. Download "Temurin 17 (LTS)" for macOS
3. Install the downloaded .pkg file
4. Set JAVA_HOME:

```bash
# Add to ~/.zshrc
echo 'export JAVA_HOME=/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home' >> ~/.zshrc
source ~/.zshrc
```

## Step 2: Verify Installation

```bash
java -version
javac -version
```

You should see Java version 17 or higher.

## Step 3: Run Tests

This project uses Gradle with a wrapper script, so you don't need to install Gradle separately.

```bash
# Run all tests
./gradlew test

# Run a specific test
./gradlew test --tests CustomersTest

# Build the project
./gradlew build
```

## Troubleshooting

### Permission denied on gradlew:
```bash
chmod +x gradlew
```

### Java not found:
Make sure JAVA_HOME is set:
```bash
echo $JAVA_HOME
```

If empty, add to `~/.zshrc`:
```bash
export JAVA_HOME=$(/usr/libexec/java_home)
source ~/.zshrc
```

### Homebrew permission issues:
```bash
sudo chown -R $(whoami) /opt/homebrew
```

## Next Steps

- See `RUNNING_TESTS.md` for detailed test commands
- Test results are in `build/reports/tests/test/index.html`
