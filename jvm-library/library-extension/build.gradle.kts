val releaseArtifact: String by project

plugins {
    scala
    alias(libs.plugins.wartremover.gradle)
    jacoco
    alias(libs.plugins.maven.publish)
}

dependencies {
    implementation(project(":$releaseArtifact"))
    implementation(libs.scala)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.bundles.junit5)

    testRuntimeOnly(libs.junit.platform.launcher)
}
