# Hello Tomcat project

## Check JKD version and maven version
````
> mvn -version
````
###
JDK must be 9 or later, Maven 3.6 o later

## Generate project tomcat-maven-archetype
````
> mvn archetype:generate
````
## Change spring version property value, maven-compiler-plugin version and set release param in configuration inside pom.xml
````xml 
    ...
    <spring.version>4.0.3.RELEASE</spring.version>
    ...
    <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
          <configuration>
			<release>9</release>
          </configuration>
    </plugin>
````
## Copy /target/*.war into %CATALINA_HOME%/webapps/