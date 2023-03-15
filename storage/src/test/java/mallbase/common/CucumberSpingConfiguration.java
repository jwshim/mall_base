package mallbase.common;

import io.cucumber.spring.CucumberContextConfiguration;
import mallbase.StorageApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { StorageApplication.class })
public class CucumberSpingConfiguration {}
