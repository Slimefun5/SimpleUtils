plugins {
    java
    id("com.gradleup.shadow") version "9.3.2"
    id("io.github.intisy.github-gradle") version "1.8.3"
}

group = "io.github.mooy1"
description = "SimpleUtils is a Slimefun addon that adds simple utility items and blocks."

apply(from = "https://raw.githubusercontent.com/Slimefun5/gradle/stable/slimefun-addon.gradle")

dependencies {
    githubImplementation("Slimefun5:InfinityLib:v1.3.14.7")
    compileOnly("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.36")
}

tasks {
    shadowJar {
        relocate("io.github.mooy1.infinitylib", "io.github.mooy1.simpleutils.infinitylib")
        minimize()
        exclude("io/github/thebusybiscuit/slimefun5/**")
    }
}
