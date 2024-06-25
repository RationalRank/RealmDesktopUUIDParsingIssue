plugins {
    kotlin("jvm") version "1.9.23"
}

// Explicitly adding the plugin to the classpath as it makes it easier to control the version
// centrally (don't need version in the 'plugins' block). Further, snapshots are not published with
// marker interface so would need to be added to the classpath manually anyway.
buildscript {
    dependencies {
        classpath("io.realm.kotlin:gradle-plugin:1.16.0")
    }
}

apply(plugin = "io.realm.kotlin")

group = "dev.ranjith"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.realm.kotlin:library-base:1.16.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
