FROM openjdk:21-jdk-slim

WORKDIR /app

# ⛏ Richtig: Passender Name der JAR-Datei
COPY build/libs/Stradew_Valley_Crop_Api-0.0.1-SNAPSHOT.jar app.jar

# 📢 Port deiner Spring Boot App – anpassen, falls du in der App etwas anderes nutzt
EXPOSE 8080

# 🏁 Startbefehl
ENTRYPOINT ["java", "-jar", "app.jar"]
