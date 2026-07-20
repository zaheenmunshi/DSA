#!/usr/bin/env bash
#
# Compiles all solutions, helpers, and tests, then runs every test suite.
#
# Usage:
#   ./run_tests.sh
#
# On Windows, run it from Git Bash (the same shell that ships with Git).
# Exits 0 if all suites pass, 1 if any suite (or compilation) fails.

set -u

# Work from the repo root (the directory containing this script).
cd "$(dirname "$0")" || exit 1

BUILD_DIR="build"

echo "Cleaning build directory..."
rm -rf "$BUILD_DIR"
mkdir -p "$BUILD_DIR"

echo "Compiling sources and tests..."
SOURCES=$(find DS tests -name '*.java')
if ! javac -d "$BUILD_DIR" $SOURCES; then
    echo "Compilation failed."
    exit 1
fi

echo "Running test suites..."
echo

overall=0
for test_file in tests/**/*Test.java tests/*Test.java; do
    [ -f "$test_file" ] || continue
    # Derive fully-qualified class name from path: tests/BinarySearch/LC704BinarySearchTest.java
    # -> tests.BinarySearch.LC704BinarySearchTest
    rel="${test_file#tests/}"          # BinarySearch/LC704BinarySearchTest.java
    rel="${rel%.java}"                 # BinarySearch/LC704BinarySearchTest
    class_name="tests.${rel//\//.}"   # tests.BinarySearch.LC704BinarySearchTest
    if ! java -cp "$BUILD_DIR" "$class_name"; then
        overall=1
    fi
done

echo "============================================"
if [ "$overall" -eq 0 ]; then
    echo "ALL SUITES PASSED"
else
    echo "SOME SUITES FAILED"
fi

exit "$overall"
