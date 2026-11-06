# MAXILU APK — High-Level Architecture

## Purpose

MAXILU APK is the Android-side companion for the MAXILU ecosystem. The mobile app is intended to act as a control and interaction surface; the desktop/core environment remains the primary execution environment.

## Component boundaries

1. **Android client**
   - Native Java application.
   - Presents Home, Chat, AI, Create and More navigation areas.
   - Displays connection, task and notification state.
   - Provides device and user interaction surfaces.

2. **Gateway**
   - Communication boundary between the mobile client and Desktop/Core.
   - Handles authenticated requests and returns task or service state.
   - The public demo does not include the private Gateway client implementation or credentials.

3. **Desktop/Core**
   - Owns the primary execution environment.
   - Exposes available capabilities to the mobile client through the Gateway.
   - Availability depends on the actual running Desktop/Core instance.

4. **Runtime and tools**
   - AI models and tools are selected/exposed by the active runtime.
   - The Android UI must not imply that a model or worker is available unless the runtime confirms it.

## Request lifecycle

```text
User action in Android app
          |
          v
Client validates and submits request
          |
          v
Gateway receives authenticated request
          |
          v
Desktop/Core dispatches available capability
          |
          v
Task state and result are returned
          |
          v
Android app displays status and result
```

## Security principles

- Keep credentials and session material out of the public repository.
- Treat pairing payloads and device identities as sensitive.
- Use explicit approval for actions that require owner authorization.
- Do not automatically replay a request when its previous network outcome is uncertain.
- Keep the private Gateway contract and deployment details in the private development repository.

This is a high-level portfolio description, not a complete API specification. It deliberately omits endpoint paths, payload schemas, private network topology and operational secrets.
