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

The Graphviz tool is installed to generate module graphs.
Graphs are generated using the ./generateModuleGraphs.sh script.
When new or updated graphs are detected, they are directly committed by GitHub Actions.
This automated process ensures the modular architecture of the project is continuously represented accurately and up-to-date, saving team members time.
