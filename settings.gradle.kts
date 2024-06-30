pluginManagement {
    repositories {
        google()
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

rootProject.name = "ModernMonsters"
include(":app")
include(":feature:list")
include(":core:design")
include(":core:network")
include(":core:database")
include(":core:common")
include(":core:domain")
include(":core:data")
include(":core:models")
include(":feature:detail")
include(":core:components")
include(":feature:matchup")
include(":feature:typeInfo")
