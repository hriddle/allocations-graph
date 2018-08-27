import groovyjarjarcommonscli.OptionBuilder.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.api.tasks.testing.logging.TestExceptionFormat

val kotlinVersion = "1.2.60"
val springBootVersion = "2.0.2.RELEASE"
val springDependencyVersion = "1.0.6.RELEASE"
val neo4jEmbeddedDriverVersion = "3.1.1-RC1"
val neo4jVersion = "3.4.5"
val mockitoVersion = "1.5.0"
val kluentVersion = "1.35"
val swaggerVersion = "2.9.2"

buildscript {
    repositories {
        mavenCentral()
        maven("https://repo.spring.io/snapshot")
        maven("https://repo.spring.io/milestone")
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.2.RELEASE")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.2.60")
        classpath("org.jetbrains.kotlin:kotlin-allopen:1.2.60")
    }
}

plugins {
    val kotlinVersion = "1.2.60"
    val springBootVersion = "2.0.2.RELEASE"
    val springDependencyVersion = "1.0.6.RELEASE"

    java
    idea
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.allopen") version kotlinVersion
    id("org.springframework.boot") version springBootVersion
    id("io.spring.dependency-management") version springDependencyVersion
}


group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.freeCompilerArgs = listOf("-Xjsr305=strict")
        kotlinOptions.jvmTarget = "1.8"
    }

    withType<Test> {
        testLogging.events = setOf(TestLogEvent.PASSED, TestLogEvent.FAILED, TestLogEvent.SKIPPED)
        testLogging.exceptionFormat = TestExceptionFormat.FULL
    }

    withType<Wrapper> {
        gradleVersion = "4.9"
        distributionType = Wrapper.DistributionType.ALL
    }
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("reflect"))
    compileSpringBootStarters("actuator", "data-neo4j", "hateoas", "web")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin")

    compile("io.springfox:springfox-swagger2:$swaggerVersion")
    compile("io.springfox:springfox-swagger-ui:$swaggerVersion")

    testCompile(springBootStarter("test"))
    testCompile("org.neo4j:neo4j-ogm-embedded-driver:$neo4jEmbeddedDriverVersion")
    testCompile("org.neo4j:neo4j:$neo4jVersion")
    testCompile("com.nhaarman:mockito-kotlin:$mockitoVersion")
    testCompile("org.amshove.kluent:kluent:$kluentVersion")
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
