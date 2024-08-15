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
        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "Messanger"
include(":app")
include(":di")
include(":navigationapi")
include(":navigationimpl")
include(":Authorization")
include(":Registration")
include(":Chats")
include(":core")
include(":core:network")
include(":core:common")
include(":core:data")
include(":domain")
include(":core:storage")
