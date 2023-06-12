package networksecurityscannerservice.common;

import io.cucumber.spring.CucumberContextConfiguration;
import networksecurityscannerservice.ScanRequestManagementApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ScanRequestManagementApplication.class })
public class CucumberSpingConfiguration {}
