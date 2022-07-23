import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.serialization") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    application
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
    maven("https://jitpack.io")
}

val shadowMe: Configuration by configurations.creating {
    configurations.implementation.get().extendsFrom(this)
}

dependencies {
    shadowMe("ch.qos.logback:logback-classic:1.2.11")
    shadowMe("org.codehaus.groovy:groovy:3.0.12")

    implementation("org.litote.kmongo:kmongo:4.6.1")

    shadowMe("dev.kord:kord-core:0.8.x-SNAPSHOT") {
        capabilities {
            requireCapability("dev.kord:core-voice:0.8.x-SNAPSHOT")
        }
    }
    shadowMe("com.kotlindiscord.kord.extensions:kord-extensions:1.5.4-SNAPSHOT")
    shadowMe("dev.schlaubi.lavakord:kord:3.6.2")

    api("se.michaelthelin.spotify:spotify-web-api-java:7.1.0")
    api("com.google.apis:google-api-services-youtube:v3-rev20220612-1.32.1")

    shadowMe(platform("io.ktor:ktor-bom:2.0.2"))
    shadowMe("io.ktor:ktor-serialization-kotlinx-json-jvm")
    shadowMe("io.ktor:ktor-client-core-jvm")
    shadowMe("io.ktor:ktor-client-cio-jvm")
    shadowMe("io.ktor:ktor-client-content-negotiation-jvm")
}

application {
    mainClassName = "dev.shuuyu.MainKt"
}

tasks {
    "shadowJar"(ShadowJar::class) {
        configurations = listOf(shadowMe)
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
    "compileKotlin"(KotlinCompile::class) {
        kotlinOptions {
            jvmTarget = "17"
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
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