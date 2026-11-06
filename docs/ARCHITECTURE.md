# MAXILU APK — High-Level Architecture

## Private application architecture

The Android app is intended to act as a control and interaction surface. Desktop/Core remains the primary execution environment, with Gateway serving as the communication boundary.

## Public demo architecture

The public demo is deliberately local-only:

```text
Android Demo Activity
        |
        v
Selected presentation components
        |
        v
Local sample content
```

There is no Gateway connection, account, pairing flow, session management, remote task dispatch or Desktop/Core dependency in the public demo.

## Security principles

- Keep credentials and session material out of the public repository.
- Treat pairing payloads and device identities as sensitive.
- Keep private Gateway contracts and deployment details in the private development repository.
- Do not imply a model, runtime or remote service is available unless it is actually connected and verified.

This document is a high-level portfolio description, not a complete API specification.
