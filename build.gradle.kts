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
    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("reflect"))
    compileSpringBootStarters("actuator", "data-neo4j", "hateoas", "web")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin")

    compile("io.springfox:springfox-swagger2:$swagger")
    compile("io.springfox:springfox-swagger-ui:$swagger")

    testCompile(springBootStarter("test"))
    testCompile("org.neo4j:neo4j-ogm-embedded-driver:$neo4jEmbeddedDriver")
    testCompile("org.neo4j:neo4j:$neo4j")
    testCompile("com.nhaarman:mockito-kotlin:$mockito")
    testCompile("org.amshove.kluent:kluent:$kluent")
}

repositories {
    jcenter()
    spring("snapshot")
    spring("milestone")
}

/***** EXTENSIONS *****/

fun RepositoryHandler.spring(repo: String): MavenArtifactRepository =
    this.maven("https://repo.spring.io/$repo")

fun DependencyHandler.compileSpringBootStarters(vararg modules: String): List<Dependency?> =
    modules.map { this.compile(springBootStarter(it)) }

fun springBootStarter(module: String, version: String? = null): String =
    "org.springframework.boot:spring-boot-starter-$module${version?.let { ":$version" } ?: ""}"
