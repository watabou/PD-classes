plugins {
    idea
    `java-library`
    `maven-publish`
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.jordigarcial.watabou"
            artifactId = "pixel-library"
            version = "1.0"
            components["java"]
        }
    }
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/JordiGarcL/PD-classes")
            credentials {
                username = extra["github_username"] as String?
                password = extra["github_token"] as String?
            }
        }
    }
}
