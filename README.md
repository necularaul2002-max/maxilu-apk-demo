# MAXILU APK V10 — Public Portfolio Demo

**Project:** Personal Android companion application  
**Developer:** Raul Bogdan  
**Private source:** MAXILU APK V10  
**Public demo:** https://github.com/necularaul2002-max/maxilu-apk-demo

## Overview

MAXILU APK is the Android companion application for the MAXILU ecosystem. It is designed as a mobile control and interaction surface for MAXILU Desktop/Core, including AI-related workflows and task monitoring.

This repository is a curated public portfolio space, separate from the private development repository.

## Public demo contents

The branch `demo/android-ui-source` contains:
- Selected native Java presentation components and bottom navigation.
- Selected MAXILU Pocket XML theme resources.
- A separate demo activity using local sample content only.
- An isolated Android Gradle project under `source/android`.
- A GitHub Actions workflow intended to build and upload a debug APK artifact.

The first successful CI build and device installation test have not yet been verified. No installable APK is claimed as available until that validation succeeds.

## Architecture

The private application is designed as a client for MAXILU Gateway and Desktop/Core. This public demo does not connect to those services.

## Privacy boundary

The public repository excludes the private app activity, Gateway implementation, pairing/session/authentication logic, private API contracts, API keys, access tokens, passwords, signing credentials, deployment configuration, private device identifiers and internal datasets.

The original private MAXILU APK repository remains unchanged.

## Personal project disclosure

MAXILU is an independently developed personal project, not professional employment experience or a commercial product delivered for an employer.

## Contact

GitHub: https://github.com/necularaul2002-max
