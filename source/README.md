# Selected Android source and demo project

The `demo/android-ui-source` branch contains a curated presentation-layer transfer and an isolated Android demo project.

## Included

- `android/app/src/main/java/app/maxilu/mobile/ui/components/MaxiluComponents.java` — reusable native presentation components.
- `android/app/src/main/java/app/maxilu/mobile/ui/navigation/MaxiluNavigation.java` — bottom-navigation presentation.
- `android/app/src/main/java/app/maxilu/mobile/ui/theme/MaxiluTheme.java` — theme/system-bar helper.
- `android/app/src/main/res/values/` — selected colors, dimensions, text styles, app theme and strings.
- `android/app/src/main/java/app/maxilu/mobile/MainActivity.java` — separate public demo shell with local sample content only.
- `android/` — isolated Android Gradle project and build instructions.

## Explicit exclusions

The private app activity, Gateway/client networking, pairing/session/authentication code, private API contracts, signing material, production configuration and private datasets were not copied. No real desktop connection or remote action is available in the demo.

## Build status

A GitHub Actions workflow has been added to build a debug APK and upload it as an Actions artifact. The first successful workflow run and APK installation test are still pending. The private repository remains the source of truth and has not been modified by this transfer.
