#!/bin/sh
# Maven Wrapper script for Unix/Git Bash
set -e

MAVEN_PROJECTBASEDIR="${MAVEN_BASEDIR:-$(pwd)}"
MAVEN_WRAPPER_JAR="$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.jar"
MAVEN_WRAPPER_PROPERTIES="$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.properties"

JAVA_CMD="java"
if [ -n "${JAVA_HOME:-}" ]; then
    JAVA_CMD="$JAVA_HOME/bin/java"
fi

exec "$JAVA_CMD" \
    -classpath "$MAVEN_WRAPPER_JAR" \
    "-Dmaven.multiModuleProjectDirectory=$MAVEN_PROJECTBASEDIR" \
    org.apache.maven.wrapper.MavenWrapperMain "$@"
