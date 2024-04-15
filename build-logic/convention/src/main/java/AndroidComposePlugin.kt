import com.android.build.api.dsl.LibraryExtension
import com.ibrahimkurt.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidComposePlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
            }
            val extension = extensions.getByType<LibraryExtension>()

            with(extension) {
                buildFeatures {
                    compose = true
                }

                composeOptions {
                    kotlinCompilerExtensionVersion = libs.findVersion("androidxComposeCompiler").get().toString()
                }

                dependencies {
                    val bom = libs.findLibrary("androidx-compose-bom").get()
                    add("implementation", platform(bom))
                    add("implementation", libs.findLibrary("androidx-ui-tooling-preview").get())
                    add("debugImplementation", libs.findLibrary("androidx-ui-tooling").get())
                }
            }
        }
    }
}