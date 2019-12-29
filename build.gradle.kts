plugins {
    `java-library`
    `maven-publish`
}

group = "com.jordigarcial.watabou"
version = "1.02"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            url = uri(extra["github_repo_url"].toString())
            credentials {
                username = extra["github_username"].toString()
                password = extra["github_token"].toString()
            }
        }
    }
}
