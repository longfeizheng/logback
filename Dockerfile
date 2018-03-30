FROM hub.c.163.com/wuxukun/maven-aliyun:3-jdk-8
ADD ["target/spring-security.jar", "app.jar"]
EXPOSE 80
ENTRYPOINT ["java","-jar","/app.jar"]