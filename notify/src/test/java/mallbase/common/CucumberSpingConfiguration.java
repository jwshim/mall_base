package mallbase.common;

import io.cucumber.spring.CucumberContextConfiguration;
import mallbase.NotifyApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { NotifyApplication.class })
public class CucumberSpingConfiguration {}
