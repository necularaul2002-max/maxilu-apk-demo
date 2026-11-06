# MAXILU APK V10 — Public Portfolio Demo

**Project:** Personal Android companion application  
**Developer:** Raul Bogdan  
**Private source:** MAXILU APK V10  
**Public demo:** https://github.com/necularaul2002-max/maxilu-apk-demo

## Overview

MAXILU APK is the Android companion application for the MAXILU ecosystem. It is designed as a mobile control and interaction surface for MAXILU Desktop/Core, including AI-related workflows and task monitoring.

This repository is a curated public portfolio space, separate from the private development repository.

## Technology and engineering areas

- Native Android development with Java
- Android XML resources, themes and layouts
- Reusable UI components and bottom navigation
- Mobile-to-desktop architecture through a Gateway boundary
- AI model-selection and task-oriented interaction concepts
- Task, approval, pairing and notification workflows documented in the private V10 project

These describe the project's documented implementation areas. They do not mean every backend service or end-to-end workflow is included here or currently online.

## Architecture

```text
MAXILU Android app
       |
       v
MAXILU Gateway
       |
       v
MAXILU Desktop / Core
       |
       v
Available runtime, models and tools
       |
       v
Task result returned to the mobile app
```

The Android app is a client. A screen or API contract does not prove that a corresponding Desktop/Core service is available.

## Files currently included

- `docs/ARCHITECTURE.md` — high-level system architecture
- `docs/FEATURE-MAP.md` — feature areas and public/private boundaries
- `docs/V10-IMPLEMENTATION-SUMMARY.md` — summary of documented V10 work
- `source/README.md` — intended scope for selected Android source excerpts

**Current repository status:** a curated Android UI source extract is now present on the `demo/android-ui-source` branch. It includes reusable presentation components, bottom navigation presentation, theme access and selected XML theme resources. The demo activity, standalone build configuration, screenshots and installable APK are still pending.

## Current limitations

- This repository is not a full clone of the private V10 project.
- No installable APK is currently published here.
- The private Gateway/Desktop/Core services are not exposed by this repository.
- The public demo is not represented as a separately built or end-to-end validated release.

## Privacy boundary

The public repository is intended to exclude API keys, access tokens, passwords, signing credentials, pairing/session material, private device identifiers, internal Gateway implementation, private API contracts, deployment configuration and internal datasets.

The original private MAXILU APK repository remains unchanged.

## Personal project disclosure

MAXILU is an independently developed personal project, not professional employment experience or a commercial product delivered for an employer. It demonstrates self-directed project work and provides material for technical discussion.

## Contact

GitHub: https://github.com/necularaul2002-max
