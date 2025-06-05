val releaseGroup: String by project
val releaseVersion: String by project
val releaseArtifact: String by project

val jdkVersion = JavaLanguageVersion.of(libs.versions.jdk.get())
val jreVersion = JavaLanguageVersion.of(libs.versions.jre.get())

allprojects {
    group = releaseGroup
    version = releaseVersion
}

plugins {
    scala
    application
    alias(libs.plugins.wartremover.gradle)
    jacoco
}

java.toolchain.languageVersion.set(jdkVersion)

application.mainClass.set("$releaseGroup.$releaseArtifact.App")

wartremover {
    scalaVersion.set(libs.versions.scala.get())
    wartremoverVersion.set(libs.versions.wartremover.get())
}

dependencies {
    implementation(libs.scala)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.bundles.junit5)

    testRuntimeOnly(libs.junit.platform.launcher)
}

tasks {
    compileJava {
        options.release = jreVersion.asInt()
    }
    compileScala {
        options.release = jreVersion.asInt()
    }
    test {
        useJUnitPlatform()
    }
    jacocoTestReport {
        reports.xml.required = true
    }
}
