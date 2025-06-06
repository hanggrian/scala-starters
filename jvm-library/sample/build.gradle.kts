val releaseArtifact: String by project

plugins {
    scala
    alias(libs.plugins.wartremover.gradle)
    application
}

application.mainClass.set("com.example.App")

dependencies {
    implementation(project(":$releaseArtifact"))
    implementation(project(":$releaseArtifact-extension"))
    implementation(libs.scala)
}
