plugins {
    idea
    `java-library`
    `maven-publish`
}

group = "com.jordigarcial.watabou"
version = "1.02"

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/JordiGarcL/pixel-library")
            credentials {
                username = extra["github_username"] as String?
                password = extra["github_token"] as String?
            }
        }
    }
}
