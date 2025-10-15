plugins {
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.serialization") version "1.9.24"
    application
    id("com.github.johnrengelman.shadow") version "9.0.0"
}

repositories { mavenCentral() }

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
}

kotlin {
    // GitHub Actions とローカルの差を消すため、JDKを固定（21 推奨）
    jvmToolchain(21)
}

application {
    mainClass.set("showcase.updaterchoice.MainKt")
}

tasks.shadowJar {
    archiveBaseName.set("updater-choice-ui-mock")
    archiveClassifier.set("all")
    archiveVersion.set("0.1.0")
}