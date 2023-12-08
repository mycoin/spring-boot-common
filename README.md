# Velocity Spring Boot Project

A Spring Boot Starter for velocity including Spring's official e.g, Layout, supports.

## Released version

```xml
    <dependencies>
        ...
        <!-- Spring Boot Starter -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <dependency>
            <groupId>plus.hzm.maven</groupId>
	        <artifactId>spring-boot-common</artifactId>
            <version>latest</version>
        </dependency>
        ...
    </dependencies>
```

If your project failed to resolve the dependency, try to add the following repository:
```xml
    <repositories>
        <repository>
            <id>sonatype-nexus</id>
            <url>https://oss.sonatype.org/content/repositories/releases</url>
            <releases>
                <enabled>true</enabled>
            </releases>
        </repository>
    </repositories>
```

## Dependencies & Compatibility

| Dependencies   | Compatibility |
| -------------- | ------------- |
| Java           | 17 +         |
| Servlet        | 3.0 +         |
| Spring Boot    | 3.2 +         |
 