plugins {
    scala
    alias(libs.plugins.wartremover)
    jacoco
    alias(libs.plugins.maven.publish)
}

dependencies {
    implementation(libs.scala)

    testImplementation(libs.bundles.scala.test)
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.truth)

    testRuntimeOnly(libs.scala.xml)
    testRuntimeOnly(libs.junit.platform.launcher)
}
