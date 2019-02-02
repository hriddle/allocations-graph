import Versions.kluent
import Versions.mockito
import Versions.neo4jEmbeddedDriver
import Versions.neo4j
import Versions.swagger
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.api.tasks.testing.logging.TestExceptionFormat

buildscript {
    repositories {
        mavenCentral()
        maven("https://repo.spring.io/snapshot")
        maven("https://repo.spring.io/milestone")
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${Versions.springBoot}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("org.jetbrains.kotlin:kotlin-allopen:${Versions.kotlin}")
    }
}

plugins {
    java
    idea
    kotlin("jvm") version Versions.kotlin
    kotlin("plugin.spring") version Versions.kotlin
    kotlin("plugin.allopen") version Versions.kotlin
    id("org.springframework.boot") version Versions.springBoot
    id("io.spring.dependency-management") version Versions.springDependency
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.freeCompilerArgs = listOf("-Xjsr305=strict")
        kotlinOptions.jvmTarget = Versions.jvm
    }

    withType<Test> {
        testLogging.events = setOf(TestLogEvent.PASSED, TestLogEvent.FAILED, TestLogEvent.SKIPPED)
        testLogging.exceptionFormat = TestExceptionFormat.FULL
    }

    withType<Wrapper> {
        gradleVersion = Versions.gradle
        distributionType = Wrapper.DistributionType.ALL
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    springBootStarters("actuator", "data-neo4j", "hateoas", "web")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("io.springfox:springfox-swagger2:$swagger")
    implementation("io.springfox:springfox-swagger-ui:$swagger")

    testImplementation(springBootStarter("test"))
    testImplementation("org.neo4j:neo4j-ogm-embedded-driver:$neo4jEmbeddedDriver")
    testImplementation("org.neo4j:neo4j:$neo4j")
    testImplementation("com.nhaarman:mockito-kotlin:$mockito")
    testImplementation("org.amshove.kluent:kluent:$kluent")
}

repositories {
    jcenter()
    springRepos("snapshot", "milestone")
}

/***** EXTENSIONS *****/

fun RepositoryHandler.springRepos(vararg repos: String): List<MavenArtifactRepository> =
    repos.map { this.maven("https://repo.spring.io/$it") }

fun DependencyHandler.springBootStarters(vararg modules: String): List<Dependency?> =
    modules.map { this.implementation(springBootStarter(it)) }

fun springBootStarter(module: String, version: String? = null): String =
    "org.springframework.boot:spring-boot-starter-$module${version?.let { ":$version" } ?: ""}"
