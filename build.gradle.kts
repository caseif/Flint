plugins {
    `java-library`
    `maven-publish`
    eclipse
    idea
    checkstyle
    id("org.cadixdev.licenser") version "0.6.1"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

defaultTasks("clean", "updateLicenses", "build")

// Project information
group = "net.caseif.flint"
version = "1.3.2"
description = "A framework for Minecraft minigame mods."

//val inceptionYear by extra { "2015" }
val inceptionYear by extra { "2015" }
val packaging by extra { "jar" }
val author by extra { "Max Roncace" }
val scmUrl by extra { "http://github.com/caseif/Flint" }

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

// Project repositories
repositories {
    mavenCentral()
    maven("https://repo.caseif.net/content/groups/public/")
}

// Project dependencies
dependencies {
    api("com.google.guava:guava:17.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.1.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.1.1")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-Xlint:all")
}

tasks.named<Copy>("processResources") {
    from("LICENSE")
}

// License header formatting
license {
    include("**/*.java")
    ignoreFailures(false)
}

// check code style
checkstyle {
    configFile = file("etc/checkstyle.xml")
}

tasks.withType<Checkstyle> {
    exclude("**/*.properties")
    exclude("**/*.yml")
}

tasks.withType<Jar> {
    manifest {
        attributes["Specification-Title"] = name
        attributes["Specification-Version"] = version
        attributes["Specitication-Vendor"] = author
    }
}

tasks.create<Jar>("sourceJar") {
    from(sourceSets["main"].java)
    from(sourceSets["main"].resources)
    classifier = "sources"
}

tasks.create<Jar>("javadocJar") {
    dependsOn(":javadoc")
    from(tasks["javadoc"])
    classifier = "javadoc"
}

tasks.withType<Javadoc> {
    options {
        this as StandardJavadocDocletOptions

        encoding = "UTF-8"
        charSet = "UTF-8"
        links(
                "https://guava.dev/releases/17.0/api/docs/",
                "https://docs.oracle.com/javase/7/docs/api/"
        )
    }
}

artifacts {
    archives(tasks["jar"])
    archives(tasks["sourceJar"])
    archives(tasks["javadocJar"])
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set(project.name)
                description.set(project.description)
                url.set(scmUrl)
                packaging = packaging

                scm {
                    url.set(scmUrl)
                    connection.set("scm:git:git://github.com/caseif/Flint.git")
                    developerConnection.set("scm:git:git@github.com:caseif/Flint.git")
                }

                licenses {
                    license {
                        name.set("MIT")
                        url.set("http://opensource.org/licenses/MIT")
                        distribution.set("repo")
                    }
                }
            }
        }
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "7.4"
}
