plugins {
    id("org.jetbrains.kotlin.js") version "1.3.70"
    kotlin("plugin.serialization") version "1.3.70"
}

group = "org.example"
version = "1.0-SNAPSHOT"

val kotlinVersion = "1.3.70"
val serializationVersion = "0.20.0"
val ktorVersion = "1.3.2"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-js"))

    //common deps
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:$serializationVersion")
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-json:$ktorVersion")

    implementation(kotlin("stdlib-js"))

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:$serializationVersion")
    //todo: bugfix in kx.serialization?
    implementation(npm("text-encoding"))
    implementation(npm("abort-controller"))

    implementation("io.ktor:ktor-client-js:$ktorVersion") //include http&websockets
    //todo: bugfix in ktor-client?
    implementation(npm("bufferutil"))
    implementation(npm("utf-8-validate"))

    //ktor client js json
    implementation("io.ktor:ktor-client-json-js:$ktorVersion")
    implementation("io.ktor:ktor-client-serialization-js:$ktorVersion")
    implementation(npm("fs"))
}

kotlin.target.browser { }