import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // путь в features-файлам
        features = {"src/test/java/resources/"},
        // путь к классам StepsDefinition
        glue = {"Steps"},
        // Формат отчета, помещается в target-ветке
        plugin = {
                "pretty", "json:target/runner.json", "junit:target/junit.xml"
        }
)
public class Runner {}