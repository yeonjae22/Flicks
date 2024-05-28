pluginManagement {
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

rootProject.name = "Flicks"
include(":app")
include(":core:data")
include(":feature:search")
include(":core:domain")
include(":core:network")
include(":core:model")
include(":core:common")
include(":core:designsystem")
include(":feature:home")
include(":feature:favorites")
include(":core:datastore")
