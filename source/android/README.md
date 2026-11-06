# MAXILU Android Demo

This is an isolated, native Java Android demo project built from a curated subset of the private MAXILU APK presentation layer.

## Build

Requirements:
- JDK 17
- Android SDK Platform 36
- Android Build Tools 36.0.0
- Gradle 8.13.2

From this directory:

```bash
gradle --no-daemon :app:assembleDebug
```

The debug APK is written to:

```
app/build/outputs/apk/debug/app-debug.apk
```

A GitHub Actions workflow builds this APK on pushes to the demo branch, pull requests, and manual workflow dispatch. The workflow uploads the APK as a short-lived Actions artifact.

## Demo limitations

- All displayed content is local sample data.
- No Gateway, Desktop/Core connection, pairing, login, session management, remote task submission or approvals are implemented.
- This is not the private MAXILU APK application and does not replace it.
- The application ID is `app.maxilu.demo.debug` for the debug build, separate from the private app's ID.
