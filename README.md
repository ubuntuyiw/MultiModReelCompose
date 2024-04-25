# Movie Multi-Module Compose Guideline

### Mastering Android Architecture with Multi-Module Compose

This repository is a journey into the ideal multi-module hierarchy, blended with the elegance of Jetpack Compose. This platform showcases the implementation and scalability of Clean Architecture and MVVM+Repository patterns, enriched with realistic examples through the TMDB API.

Accelerate your feature development process with a ready-to-clone and customizable template module. With every pull request, CI ensures your code quality through Detekt and automated build processes.

Dive into this guide to discover the perfect modular structure.


| HOME                                                                                                       | DETAIL                                                                                                       |
|------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------|
| <img src="https://github.com/ubuntuyiw/MultiModReelCompose/blob/develop/docs/images/screenshot/home.png"/> | <img src="https://github.com/ubuntuyiw/MultiModReelCompose/blob/develop/docs/images/screenshot/detail.png"/> |


## Module Structure

### Dependency graph
![Dependency graph](https://github.com/ubuntuyiw/MultiModReelCompose/blob/master/docs/images/graphs/dep_graph_app.svg)

Our project adopts a multi-module architecture to facilitate rapid feature development and easy collaboration in large teams. Each module represents a specific functionality or layer and is designed to be tightly integrated with each other while also being independently developable and testable units.

### Main Modules:

:app: Represents the entry point of the application and combines all other feature modules and libraries.
:navigation: Contains the logic for in-app navigation and manages the navigation graph.
:core: Includes the core components of the application and provides shared functionality used by all feature modules.

### Feature Modules:

![Dependency graph](https://raw.githubusercontent.com/ubuntuyiw/MultiModReelCompose/master/docs/images/graphs/1__ZrkCb8QE0nK4FApKzKgmA.webp)

:features:*: Each feature module (:features:home, :features:detail, etc.), covers the user interface, data sources, and business rules. These modules are separated according to clean architecture and the MVVM+Repository patterns.
Shared Library Modules:

:core:ui, :core:domain, :core:data: Provides fundamental classes and interfaces for UI, business logic, and data access layers.
This modular approach facilitates maintenance and scalability of the application, and also minimizes overlaps while team members are working on it.

# Module Graphs Automatic Update
In the MultiModReelCompose project, the module hierarchy is dynamic. When developers add a new module or the existing hierarchy changes, the Generate Module Graphs Workflow is used to update module dependency graphs and provide team members with a visual understanding.

This CI process is triggered when a pull request is created in the github/module-graph branch. The process automatically generates the module dependency graphs, attaches the updated graphs to the relevant files, and commits the changes to the github/module-graph branch automatically. This allows team members to review the graph changes and merge them with the develop branch if deemed appropriate.

### Workflow Details:

* The Graphviz tool is installed to generate module graphs.
* Graphs are generated using the ./generateModuleGraphs.sh script.
* When new or updated graphs are detected, they are directly committed by GitHub Actions.
* This automated process ensures the modular architecture of the project is continuously represented accurately and up-to-date, saving team members time.


# Android CI
The Android CI process ensures that the code is compiled and tested with every pull request. This guarantees that every contribution to the application's master branch meets specified standards and is free of errors.

### Features:

* Automatically compiles your code and runs tests.
* Ensures a reliable build with every PR.

# Detekt Static Code Analysis
The Detekt Static Code Analysis process performs static code analysis to maintain and improve code quality. This helps enhance the sustainability of the software and keeps the codebase clean.

### Features:

* Performs static code analysis with Detekt in PRs.
* Ensures your code is more readable and easier to maintain.
* Detects potential errors and style issues at an early stage.
* Both CI processes are critical for ensuring the robustness of the application and the smoothness of the development process. These automated procedures continuously monitor the quality of your code and enhance the efficiency of the development team.

# Setup and Startup

The MultiModReelCompose project provides developers with a robust foundation to develop modern and modular applications on the Android platform. Follow these steps to install and run the project in your local development environment:

### Project Cloning:
```bash
git clone https://github.com/ubuntuyiw/MultiModReelCompose.git
```
This command clones the project to your local machine.

### Requirements:
* JDK 17 or newer.
* Android Studio Bumblebee (2021.1.1) or newer.
* Latest version Android SDK and Android SDK Tools.
  
Installing Dependencies:
Run the following command in the project directory to install necessary dependencies:
```bash
./gradlew build
```
### Configuring the API Key:
Specify your API key required to use the TMDB API in your local.properties file as follows:
```bash
API_KEY="YOUR_API_KEY_HERE"
```
Opening the Project in Android Studio:
In Android Studio, open the project using the 'Open an Existing Project' option.
Running the Application:
Start the application by clicking the Run button in Android Studio.
These steps will complete the setup process required to start contributing to the MultiModReelCompose project.

# Libraries and Plugins
The notable libraries and plugins used in the MultiModReelCompose project are as follows:

### Important Plugins:

* hilt: Dagger-Hilt is used for dependency injection and simplifies dependency management in Android projects.
* ksp: Kotlin Symbol Processing provides fast and efficient annotation processing for Kotlin.
* detekt: A static code analysis tool that helps improve code quality and consistency.
* module-graph: Used to generate and analyze module dependency graphs.

### Custom Plugins:
There are also custom-defined plugins specific to the project. These are designed for specific functions and support the project's modular structure:

*ibrahimkurt-android-application
* ibrahimkurt-android-hilt
* ibrahimkurt-android-compose
* ibrahimkurt-jvm-library
* ibrahimkurt-android-library
* ibrahimkurt-android-library-compose
* ibrahimkurt-android-uiSetup
* ibrahimkurt-android-retrofitSerialization
* ibrahimkurt-jvm-detekt

### Main Libraries:

* AndroidX and Compose UI Libraries (core-ktx, activity-compose, navigation-compose, paging-runtime-ktx, etc.)
* Networking (retrofit, ktorClientOkhttp)
* Asynchronous Programming (kotlinx-coroutines-core)
* Serialization (kotlinx-serialization-json)
* Image Loading (coil, coilCompose)

### Build Logic:
The project uses the build-logic module to centralize and make the configuration reusable. This module contains Gradle configuration files and ensures consistent build behaviors across all modules of the project.

# Additional Resources and References
Below are several external resources to help you better understand the MultiModReelCompose project and gain in-depth knowledge about Android development. These resources can assist you in understanding how some parts of the project are structured and best practices related to Android architecture.

### Medium Article:
* [Using Jetpack Compose and Modern Android Architecture](https://medium.com/@rahmicemreunal/817745284354) - Written by Rahmi Cemre Ünal, this article provides in-depth information about Jetpack Compose and modern Android architecture.

### GitHub Projects:

* [Now in Android](https://github.com/android/nowinandroid) - A sample project developed by Google, demonstrating how to develop applications using modern Android technologies and architecture.
* [Note App](https://github.com/rcunal/note-app) - A simple note-taking application developed by Rahmi Cemre Ünal, utilizing modern Android application architectures.

### Official Android Developers Documentation:

* [Android Architecture](https://developer.android.com/topic/architecture?hl=en) - The official guide on various architectural patterns and approaches used when designing Android applications.

These resources will guide you through your Android application development process and help you better align with the architectural patterns of the project.
