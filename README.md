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
<!--
Packages to install: - Sources for Android 36 (sources;android-36)
- Android SDK Platform 36 (platforms;android-36)
- Android SDK Platform-Tools (platform-tools)
- Android Auto API Simulators (extras;google;simulators)
- Android Emulator (emulator)
- Android SDK Build-Tools 36 (build-tools;36.0.0)


Preparing "Install Sources for Android 36 (revision 1)".
Downloading https://dl.google.com/android/repository/source-36_r01.zip

he following components will be installed:

- Android SDK Build-Tools 20 v.20.0.0
- Android SDK Build-Tools 25.0.3 v.25.0.3
- Android SDK Build-Tools 23.0.2 v.23.0.2
- Google APIs ARM 64 v8a System Image API 36.0 (revision 6)
- Android SDK Build-Tools 24.0.2 v.24.0.2
- Android SDK Build-Tools 22.0.1 v.22.0.1
- Android SDK Build-Tools 19.1 v.19.1.0
- Android SDK Build-Tools 24.0.3 v.24.0.3
- Android SDK Build-Tools 26.0.3 v.26.0.3
- Android SDK Build-Tools 32.1-rc1 v.32.1.0 rc1
- Android SDK Build-Tools 35-rc1 v.35.0.0 rc1
- Android SDK Build-Tools 27 v.27.0.0
- Android SDK Build-Tools 29 v.29.0.0
- Android SDK Build-Tools 30.0.3 v.30.0.3
- Android SDK Build-Tools 32 v.32.0.0
- Android SDK Build-Tools 33 v.33.0.0
- Android SDK Build-Tools 34 v.34.0.0
- Android SDK Build-Tools 28 v.28.0.0
- Android SDK Build-Tools 35-rc4 v.35.0.0 rc4
- Android SDK Build-Tools 30.0.2 v.30.0.2
- Pre-Release 16 KB Page Size Google APIs Intel x86_64 Atom System Image API 36.0 (revision 6)
- Android SDK Build-Tools 31 v.31.0.0
- Android SDK Build-Tools 34-rc3 v.34.0.0 rc3
- Android SDK Build-Tools 25.0.2 v.25.0.2
- Android SDK Build-Tools 28.0.3 v.28.0.3
- Android SDK Build-Tools 35-rc2 v.35.0.0 rc2
- Android SDK Build-Tools 23.0.1 v.23.0.1
- Pre-Release 16 KB Page Size Google APIs ARM 64 v8a System Image API 36.0 (revision 6)
- Sources for Android 36 (revision 1)
- Android SDK Build-Tools 34-rc1 v.34.0.0 rc1
- Android SDK Build-Tools 25.0.1 v.25.0.1
- Android SDK Build-Tools 36-rc4 v.36.0.0 rc4
- Pre-Release 16 KB Page Size Google Play Intel x86_64 Atom System Image API 36.0 (revision 6)
- Google Play ARM 64 v8a System Image API 36.0 (revision 6)
- Android SDK Build-Tools 27.0.1 v.27.0.1
- Android SDK Build-Tools 29.0.1 v.29.0.1
- Google APIs Intel x86_64 Atom System Image API 36.0 (revision 6)
- Android SDK Build-Tools 26.0.1 v.26.0.1
- Android SDK Build-Tools 28.0.2 v.28.0.2
- Android SDK Build-Tools 24 v.24.0.0
- Android SDK Build-Tools 29.0.3 v.29.0.3
- Android SDK Build-Tools 33.0.3 v.33.0.3
- Android SDK Platform 36 (revision 2)
- Android SDK Build-Tools 27.0.2 v.27.0.2
- Android SDK Build-Tools 30.0.1 v.30.0.1
- Android SDK Build-Tools 33.0.2 v.33.0.2
- Android SDK Build-Tools 36 v.36.0.0
- Android SDK Build-Tools 25 v.25.0.0
- Android SDK Build-Tools 29.0.2 v.29.0.2
- Google Play Intel x86_64 Atom System Image API 36.0 (revision 6)
- Android SDK Build-Tools 26 v.26.0.0
- Android SDK Build-Tools 21.1.2 v.21.1.2
- Android SDK Build-Tools 35 v.35.0.0
- Android SDK Build-Tools 23.0.3 v.23.0.3
- Pre-Release 16 KB Page Size Google Play ARM 64 v8a System Image API 36.0 (revision 6)
- Google TV Intel x86 Atom System Image API 36.0 (revision 1)
- Android SDK Build-Tools 34-rc2 v.34.0.0 rc2
- Android SDK Build-Tools 28.0.1 v.28.0.1
- Android SDK Build-Tools 30 v.30.0.0
- Google TV ARM 64 v8a System Image API 36.0 (revision 1)
- Android SDK Build-Tools 27.0.3 v.27.0.3
- Android SDK Build-Tools 26.0.2 v.26.0.2
- Android SDK Build-Tools 35-rc3 v.35.0.0 rc3
- Android SDK Build-Tools 36-rc5 v.36.0.0 rc5
- Android SDK Build-Tools 24.0.1 v.24.0.1
- Android SDK Build-Tools 36-rc3 v.36.0.0 rc3
- Android SDK Build-Tools 33.0.1 v.33.0.1
- Android SDK Build-Tools 35.0.1 v.35.0.1
- Android SDK Build-Tools 36-rc1 v.36.0.0 rc1
- Android Emulator (Required by Pre-Release 16 KB Page Size Google Play ARM 64 v8a System Image, Google TV Intel x86 Atom System Image, Pre-Release 16 KB Page Size Google Play Intel x86_64 Atom System Image, Google Play ARM 64 v8a System Image, Pre-Release 16 KB Page Size Google APIs Intel x86_64 Atom System Image, Google APIs ARM 64 v8a System Image, Google Play Intel x86_64 Atom System Image, Google TV ARM 64 v8a System Image, Google APIs Intel x86_64 Atom System Image, Pre-Release 16 KB Page Size Google APIs ARM 64 v8a System Image)
Disk usage:

- Estimated download size: 19.1 GB
- Estimated disk space to be additionally occupied on SDK partition after installation: 76.5 GB
- Currently available disk space in SDK root (C:\Users\ads0417\AppData\Local\platform-tools): 305.2 GB

-->

Link: 
- https://youtu.be/myjSxtAk9XM?list=PLS1QulWo1RIbb1cYyzZpLFCKvdYV_yJ-E
- https://www.youtube.com/watch?v=8sJvzZ-y9bw&list=PLXiaMWHbNgp3JCTw0qrPLISkfXWdQUW1Q&index=19

