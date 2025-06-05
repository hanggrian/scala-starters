import com.vanniktech.maven.publish.JavaLibrary
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.MavenPublishBasePlugin
import com.vanniktech.maven.publish.SonatypeHost
import cz.augi.gradle.wartremover.WartremoverExtension
import cz.augi.gradle.wartremover.WartremoverPlugin

val developerId: String by project
val developerName: String by project
val developerUrl: String by project
val releaseGroup: String by project
val releaseArtifact: String by project
val releaseVersion: String by project
val releaseDescription: String by project
val releaseUrl: String by project

val jdkVersion = JavaLanguageVersion.of(libs.versions.jdk.get())
val jreVersion = JavaLanguageVersion.of(libs.versions.jre.get())

plugins {
    alias(libs.plugins.wartremover.gradle) apply false
    alias(libs.plugins.maven.publish) apply false
}

allprojects {
    group = releaseGroup
    version = releaseVersion
}

subprojects {
    plugins.withType<JavaPlugin>().configureEach {
        the<JavaPluginExtension>().toolchain.languageVersion.set(jdkVersion)
    }
    plugins.withType<WartremoverPlugin>().configureEach {
        configure<WartremoverExtension> {
            scalaVersion.set(libs.versions.scala.get())
            wartremoverVersion.set(libs.versions.wartremover.get())
        }
    }
    plugins.withType<MavenPublishBasePlugin> {
        configure<MavenPublishBaseExtension> {
            configure(JavaLibrary(JavadocJar.Javadoc()))
            publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
            signAllPublications()
            pom {
                name.set(project.name)
                description.set(releaseDescription)
                url.set(releaseUrl)
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set(developerId)
                        name.set(developerName)
                        url.set(developerUrl)
                    }
                }
                scm {
                    url.set(releaseUrl)
                    connection.set("scm:git:https://github.com/$developerId/$releaseArtifact.git")
                    developerConnection
                        .set("scm:git:ssh://git@github.com/$developerId/$releaseArtifact.git")
                }
            }
        }
    }

    tasks {
        withType<JavaCompile>().configureEach {
            options.release = jreVersion.asInt()
        }
        withType<ScalaCompile>().configureEach {
            options.release = jreVersion.asInt()
        }
        withType<ScalaDoc>().configureEach {
            destinationDir = layout.buildDirectory.dir("docs/${project.name}").get().asFile
        }
        withType<Test>().configureEach {
            useJUnitPlatform()
        }
        withType<JacocoReport>().configureEach {
            reports.xml.required = true
        }
    }
}

tasks.register(LifecycleBasePlugin.CLEAN_TASK_NAME) {
    delete(layout.buildDirectory)
}
