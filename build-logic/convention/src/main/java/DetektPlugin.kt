
import com.ibrahimkurt.convention.libs
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class DetektPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            pluginManager.apply("io.gitlab.arturbosch.detekt")
            allprojects {
                configure<DetektExtension> {
                    toolVersion = "1.23.6"
                    autoCorrect = true
                    buildUponDefaultConfig = true
                    config.setFrom("${rootProject.projectDir}/app/config/detekt/detekt.yml")
                    source.setFrom("src/main/java", "src/main/kotlin")
                    parallel = false
                    allRules = true
                }
            }

            dependencies {
                add("detektPlugins", libs.findLibrary("detekt").get())
            }
        }
    }
}