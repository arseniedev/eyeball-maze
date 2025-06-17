# 🧩 Android Dynamic View Demo App

This Android application demonstrates the difference between creating views **programmatically (dynamic)** and **manually (XML-based)** using the MVC design pattern. It includes responsive layouts, user interaction, and clean separation of concerns.

---

## 🚀 Tech Stack

| Tool/Library         | Version       | Description                             |
|----------------------|---------------|-----------------------------------------|
| Android Studio       | Hedgehog (2023.3.1) or later | Recommended IDE for development         |
| Gradle               | 8.4           | Build automation                         |
| Android Gradle Plugin| 8.4.1         | Android-specific Gradle plugin           |
| Java (JDK)           | 17            | Language used for development            |
| Android SDK          | API 34 (Android 14) | Compile and target SDK                   |
| Min SDK              | API 24        | Minimum supported Android version        |
| ConstraintLayout     | 2.1.4         | For building responsive UI               |

---

## ⚙️ Configuration Summary

### `build.gradle (Project)`

```groovy
buildscript {
    dependencies {
        classpath 'com.android.tools.build:gradle:8.4.1'
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
```


----
Packages to install: - Sources for Android 36 (sources;android-36)
- Android SDK Platform 36 (platforms;android-36)
- Android SDK Platform-Tools (platform-tools)
- Android Auto API Simulators (extras;google;simulators)
- Android Emulator (emulator)
- Android SDK Build-Tools 36 (build-tools;36.0.0)


Preparing "Install Sources for Android 36 (revision 1)".
Downloading https://dl.google.com/android/repository/source-36_r01.zip


Link: 
- https://youtu.be/myjSxtAk9XM?list=PLS1QulWo1RIbb1cYyzZpLFCKvdYV_yJ-E
- https://www.youtube.com/watch?v=8sJvzZ-y9bw&list=PLXiaMWHbNgp3JCTw0qrPLISkfXWdQUW1Q&index=19

