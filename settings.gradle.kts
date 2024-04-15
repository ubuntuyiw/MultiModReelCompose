pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MultiModReelCompose"
include(":app")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":navigation")
include(":core:network")
include(":core:component")
include(":core:common")
include(":core:ui")
include(":core:domain")
include(":core:data")
include(":features:template:ui")
include(":features:template:data")
include(":features:template:domain")
include(":features:home:ui")
include(":features:home:data")
include(":features:home:domain")
