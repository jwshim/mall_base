package mallbase.common;

import io.cucumber.spring.CucumberContextConfiguration;
import mallbase.InfomationApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { InfomationApplication.class })
public class CucumberSpingConfiguration {}
