// settings.gradle.kts

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
    // Esto impide que los módulos usen sus propios repositorios (es correcto y seguro)
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        // 🔥 Esta línea permite usar MPAndroidChart desde GitHub (vía JitPack)
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "CLINICA_VITALISTECH"
include(":app")


