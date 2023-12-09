plugins {
    kotlin("jvm") version "1.9.10"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

sourceSets {
    main {
        kotlin {
            srcDirs("src")
        }
        resources {
            srcDirs("resources")
        }
    }
}