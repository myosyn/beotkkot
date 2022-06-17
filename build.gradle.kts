import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.serialization") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    `maven-publish`
    application
    signing
    java
}

group = "dev.shuuyu"
version = "1.0"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://maven.kotlindiscord.com/repository/maven-snapshots/")
    maven("https://maven.kotlindiscord.com/repository/maven-releases/")
    maven("https://maven.kotlindiscord.com/repository/maven-public/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://schlaubi.jfrog.io/artifactory/lavakord")
}

val shadowMe: Configuration by configurations.creating {
    configurations.implementation.get().extendsFrom(this)
}

dependencies {
    shadowMe("ch.qos.logback:logback-classic:1.2.11")
    shadowMe("org.codehaus.groovy:groovy:3.0.11")

    shadowMe("dev.kord:kord-core:0.8.x-SNAPSHOT")
    shadowMe("com.kotlindiscord.kord.extensions:kord-extensions:1.5.3-SNAPSHOT")
    shadowMe("dev.schlaubi.lavakord:kord:3.6.2")

    api("se.michaelthelin.spotify:spotify-web-api-java:7.1.0")
    shadowMe("com.google.apis:google-api-services-youtube:v3-rev20220612-1.32.1")

    shadowMe(platform("io.ktor:ktor-bom:2.0.1"))
    shadowMe("io.ktor:ktor-serialization-kotlinx-json-jvm")
    shadowMe("io.ktor:ktor-client-core-jvm")
    shadowMe("io.ktor:ktor-client-cio-jvm")
    shadowMe("io.ktor:ktor-client-content-negotiation-jvm")
}

tasks {
    "shadowJar"(ShadowJar::class) {
        configurations = listOf(shadowMe)
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
    "compileKotlin"(KotlinCompile::class) {
        kotlinOptions {
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
            kotlinOptions.freeCompilerArgs += "-jvm-default=all-compatibility"
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.contracts.ExperimentalContracts"
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlinx.serialization.ExperimentalSerializationApi"
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlinx.serialization.InternalSerializationApi"
        }
    }
    "compileJava"(JavaCompile::class) {
        options.encoding = "UTF-8"
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
    }
}