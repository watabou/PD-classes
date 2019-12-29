Pixel Library
==========
###### Forked from [watabou/PD-classes](https://github.com/watabou/PD-classes)

This is a fork of the unnamed game library from the Android rogue-like game [Pixel Dungeon](https://github.com/watabou/pixel-dungeon),
developed by [Watabou](https://github.com/watabou), which discontinued the project on October 2015.

### Intention
When the project was discontinued, the source code was provided as-is, with no documentation and no build system integration.

I have forked the project with the intention of documenting the code, cleaning up the project, integrate it with modern tools 
(IDEA, Gradle 6) and make it easily available for other people.

### Usage
This library is published as an artifact on the [Github Packages repository](https://github.com/JordiGarcL/pixel-library/packages). 
#### Authenticating
In order to consume the artifacts published by this project you will need to configure 
[Gradle](https://help.github.com/en/github/managing-packages-with-github-packages/configuring-gradle-for-use-with-github-packages) or
[Maven](https://help.github.com/en/github/managing-packages-with-github-packages/configuring-apache-maven-for-use-with-github-packages) 
to authenticate with Github Packages
#### Adding dependency
Once your build system tool is configured to authenticate with the Github Packages repository, add the following snippet 
to depend on the library.

##### Gradle
```kotlin
dependencies {
    // Other dependencies ...
    implementation("com.jordigarcial.watabou:pixel-library:1.01")
}
```

##### Maven 
```xml
<dependency>
  <groupId>com.jordigarcial.watabou</groupId>
  <artifactId>pixel-library</artifactId>
  <version>1.01</version>
</dependency>
```

### Publishing
Gradle is configured to build the project and publish an artifact to Github Packages through the `publish` task.
#### Local configuration
This project uses the following gradle properties to define the authentication credentials:
- `github_repo_url`
- `github_username`
- `github_token`

If you clone the project and try to run the `publish` task it will fail, since the properties defining the publication properties
are not defined. This is intentional, as it would otherwise allow you to publish to this project repository.

Instead, if you wish to publish this artifact to a repository of your own, you must provide the above properties in a 
`gradle.properties` file in the root of the project.
 

### License
This project is licensed under the terms of the GNU GPLv3 license. You can find a copy of the license in the root directory of
this project.
 