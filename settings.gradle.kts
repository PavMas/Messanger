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
