#!/usr/bin/env bash
#
# Compiles all solutions and JUnit 5 tests, then runs every test suite.
#
# Usage (Git Bash on Windows):
#   ./run_tests.sh
#
# Exits 0 if all tests pass, 1 otherwise.

set -u
cd "$(dirname "$0")" || exit 1

BUILD_DIR="build"
LIB_DIR="lib"

# On Windows javac/java use ; as the classpath separator
SEP=";"

# Build classpath from all jars in lib/
CP=""
for jar in "$LIB_DIR"/*.jar; do
    CP="${CP}${SEP}${jar}"
done
CP="${CP#$SEP}"   # strip leading separator

echo "Cleaning build directory..."
rm -rf "$BUILD_DIR"
mkdir -p "$BUILD_DIR"

echo "Compiling sources and tests..."
SOURCES=$(find DS tests -name '*.java')
if ! javac -cp "$CP" -nowarn -d "$BUILD_DIR" $SOURCES; then
    echo "Compilation failed."
    exit 1
fi

echo "Running test suites..."
echo

# Collect all test class names (fully-qualified)
TEST_CLASSES=""
for test_file in tests/**/*Test.java tests/*Test.java; do
    [ -f "$test_file" ] || continue
    rel="${test_file#tests/}"
    rel="${rel%.java}"
    TEST_CLASSES="$TEST_CLASSES tests.${rel//\//.}"
done

java -cp "${BUILD_DIR}${SEP}${CP}" tests.TestRunner $TEST_CLASSES
exit $?
