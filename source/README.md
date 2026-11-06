# Selected Android source excerpts

This folder contains the first curated source transfer from the private MAXILU APK project, published on branch `demo/android-ui-source`.

## Included

- `android/app/src/main/java/app/maxilu/mobile/ui/components/MaxiluComponents.java` — reusable native presentation components.
- `android/app/src/main/java/app/maxilu/mobile/ui/navigation/MaxiluNavigation.java` — bottom-navigation presentation.
- `android/app/src/main/java/app/maxilu/mobile/ui/theme/MaxiluTheme.java` — theme/system-bar helper.
- `android/app/src/main/res/values/` — selected colors, dimensions, text styles, app theme and strings.

These files were selected because they are presentation-layer code. The private `MainActivity`, Gateway clients, pairing/session code, authentication logic, API contracts, deployment configuration and signing material were not copied.

## Build status

This is a source extract, not yet a standalone Android Studio project. A separate demo activity and isolated build configuration still need to be added before the public branch can produce an installable APK. The private repository remains the source of truth and has not been modified by this transfer.
