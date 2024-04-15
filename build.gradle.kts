// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.module.graph) apply true
}

tasks.register("createFeatureModule") {
    doLast {
        val moduleName = project.findProperty("moduleName") as? String
            ?: throw IllegalArgumentException("Module name not provided")
        val moduleType = project.findProperty("moduleType") as? String
            ?: throw IllegalArgumentException("Module type not provided")

        val types = if (moduleType == "all") listOf("ui", "data", "domain") else listOf(moduleType)

        types.forEach { type ->
            val modulePath = "features:$moduleName:$type"
            val srcDir = file("features/template/$type")
            val destDir = file("features/$moduleName/$type")

            srcDir.copyRecursively(destDir, overwrite = true)

            val settingsFile = rootProject.file("settings.gradle.kts")
            settingsFile.appendText("\ninclude(\"$modulePath\")")

            fun updatePackagePaths(sourcePath: String) {
                val oldPackageDir = destDir.resolve(sourcePath)
                val newPackageDir = destDir.resolve(sourcePath.replace("template", moduleName))
                if (oldPackageDir.exists()) {
                    oldPackageDir.renameTo(newPackageDir)
                }

                newPackageDir.walkTopDown().forEach { file ->
                    if (file.extension in listOf("kt", "java")) {
                        val content = file.readText().replace(
                            "com.ibrahimkurt.features.template",
                            "com.ibrahimkurt.features.$moduleName")
                        file.writeText(content)
                    }
                }
            }

            updatePackagePaths("src/main/java/com/ibrahimkurt/features/template")
            updatePackagePaths("src/androidTest/java/com/ibrahimkurt/features/template")
            updatePackagePaths("src/test/java/com/ibrahimkurt/features/template")
        }
    }
}

tasks.register("printModulePaths") {
    subprojects {
        if (subprojects.size == 0) {
            println(this.path)
        }
    }
}