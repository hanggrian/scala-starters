#!/bin/bash

RED="$(tput setaf 1)" && readonly RED
GREEN="$(tput setaf 2)" && readonly GREEN
YELLOW="$(tput setaf 3)" && readonly YELLOW
END="$(tput sgr0)" && readonly END

warn() { echo "$YELLOW$*$END"; } >&2
die() { echo; echo "$RED$*$END"; echo; exit 1; } >&2

SOURCE_ROOT="$(cd "$(dirname "$0")" && pwd)" && readonly SOURCE_ROOT
declare -a PROJECTS=(
  "$(cd "$SOURCE_ROOT/jvm-app" && pwd)"
  "$(cd "$SOURCE_ROOT/jvm-library" && pwd)"
) && readonly PROJECTS

GRADLE_WRAPPER_FILE='gradle/wrapper/gradle-wrapper.properties' && \
  readonly GRADLE_WRAPPER_FILE
LIBS_FILE='gradle/libs.versions.toml' && readonly LIBS_FILE

update_gradle_wrapper() {
  perl -i -pe "s|^$1=.*$|$1=$2|" "$GRADLE_WRAPPER_FILE"
}
update_libs() {
  perl -i -pe "s|^$1 = \".*\"|$1 = \"$2\"|" "$LIBS_FILE"
}

for project in "${PROJECTS[@]}"; do
  warn "Syncing $project..."

  echo '(1/4) Generating Gradle wrapper'
  cd "$project" || exit 1
  update_gradle_wrapper 'distributionUrl' \
    'https\\\://services.gradle.org/distributions/gradle-8.14.2-bin.zip'
  ./gradlew -q wrapper

  echo '(2/4) Updating base'
  update_libs 'jdk' '21'
  update_libs 'jre' '8'
  update_libs 'scala' '3.3.6'
  update_libs 'wartremover' '3.3.3'
  update_libs 'wartremover-gradle' 'cz.augi.gradle.wartremover:0.18.2'
  update_libs 'git-publish' 'org.ajoberstar.git-publish:5.1.1'
  update_libs 'pages' 'com.hanggrian.pages:0.2'
  update_libs 'truth' 'com.google.truth:truth:1.4.4'

  if [[ "$project" == *'jvm-'* ]]; then
    echo '(3/4) Updating JVM'
    update_libs 'junit' '5.12.2'
    update_libs 'scalatest' 'org.scalatest:scalatest_3:3.2.19'
    update_libs 'scalatest-junit5' 'org.scalatestplus:junit-5-12_3:3.2.19.0'
    update_libs 'scalatest-mockito' 'org.scalatestplus:mockito-5-12_3:3.2.19.0'
    update_libs 'junit-platform-launcher' \
      'org.junit.platform:junit-platform-launcher:1.12.2'
  fi

  if [[ "$project" == *'-library' ]]; then
    echo '(4/4) Updating Maven Publish'
    update_libs 'maven-publish' 'com.vanniktech.maven.publish.base:0.32.0'
  else
    echo '(4/4) Skip Maven Publish'
  fi
done

echo "${GREEN}Sync complete.$END"
