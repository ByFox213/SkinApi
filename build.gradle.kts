val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "2.0.0"
    id("io.ktor.plugin") version "2.3.12"
}

group = "ru.royal_tee"
version = "0.0.2"

application {
    mainClass.set("ru.royal_tee.ApplicationKt")

    // val isDevelopment: Boolean = project.ext.has("development")
    // applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

ktor {
    fatJar{
        archiveFileName.set("SkinApi.jar")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.0")

    implementation("io.ktor:ktor-server-call-logging-jvm")
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-cors-jvm")
    implementation("com.ucasoft.ktor:ktor-simple-cache-jvm:0.4.3")
    implementation("com.ucasoft.ktor:ktor-simple-memory-cache-jvm:0.4.3")
    implementation("io.ktor:ktor-server-caching-headers-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
}
