package framework;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

//Hooks for project
public class Hooks {

    WebDriver driver;
    Properties properties;

    @Before
    public void before() {
        properties = ConfigReader.initialize_Properties();
        driver = DriverSetup.initialize_Driver(properties.getProperty("browser"));
    }

    @After
    public void after() {
        driver.quit();
    }
}