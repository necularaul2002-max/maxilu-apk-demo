# MAXILU APK V10 — Public Portfolio Demo

**Project:** Personal Android companion application  
**Developer:** Raul Bogdan  
**Private source:** MAXILU APK V10  
**Public demo:** https://github.com/necularaul2002-max/maxilu-apk-demo

## Overview

MAXILU APK is the Android companion application for the MAXILU ecosystem. It is designed as a mobile control and interaction surface for MAXILU Desktop/Core, including AI-related workflows and task monitoring.

This repository is a curated public portfolio extract. It is separate from the private development repository and is intended to show selected non-confidential implementation work.

## Technology and engineering areas

- Native Android development with Java
- Android XML resources, themes and layouts
- Reusable UI components and bottom navigation
- Mobile-to-desktop architecture through a Gateway boundary
- AI model-selection and task-oriented interaction concepts
- Task, approval, pairing and notification workflows in the private V10 application

These describe the project's documented implementation areas. They do not mean that every backend service or end-to-end workflow is included in this public repository or currently online.

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

## Public demo scope

The public repository is intended to contain:
- selected genuine Android UI source files from V10;
- non-confidential visual resources;
- high-level architecture and feature documentation.

It does not contain the complete private application source, Gateway client implementation, private API contracts, pairing/session code, credentials, signing configuration, internal datasets or deployment secrets.

## Current limitations

- This repository is a curated portfolio extract, not a full clone of the private V10 project.
- No installable APK is currently published here.
- The private Gateway/Desktop/Core services are not exposed by this repository.
- The public extract is not represented as a separately built or end-to-end validated release.

## Personal project disclosure

MAXILU is an independently developed personal project, not professional employment experience or a commercial product delivered for an employer. It demonstrates self-directed project work and provides material for technical discussion.

## Contact

GitHub: https://github.com/necularaul2002-max
