package networksecurityscannerservice.common;

import io.cucumber.spring.CucumberContextConfiguration;
import networksecurityscannerservice.OpenSourceIntegrationToolsApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { OpenSourceIntegrationToolsApplication.class })
public class CucumberSpingConfiguration {}
