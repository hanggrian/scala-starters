plugins {
    scala
    alias(libs.plugins.wartremover.gradle)
    jacoco
    alias(libs.plugins.maven.publish)
}

dependencies {
    implementation(libs.scala)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.bundles.junit5)

    testRuntimeOnly(libs.junit.platform.launcher)
}
