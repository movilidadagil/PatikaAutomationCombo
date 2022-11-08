package testscenarios;

import framework.ConfigReader;
import framework.DriverSetup;
import org.junit.BeforeClass;
import org.junit.Ignore;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageScenarios {
    LoginPage loginPage = new LoginPage(DriverSetup.getDriver());
    static WebDriver driver;
    static Properties properties;

    @BeforeClass
    public static void setup(){
        properties = ConfigReader.initialize_Properties();
        driver = DriverSetup.initialize_Driver("chrome");
    }

    @Ignore
    public void m6() {
        loginPage.clickLoginButton();
    }

    @Test(timeout = 10)
    public void m7() {
        loginPage.clickLoginButton();
        System.out.println("Using @Test(timeout),it can be used to enforce timeout in JUnit4 test case");
    }

    @Test(expected = ElementNotInteractableException.class)
    public void m8() {
        System.out.println("Using @Test(expected) ,it will check for specified exception during its execution");
        loginPage.loginEnterEmail("sdet@tester.com");
    }

    @Test()
    public void m9() {
        loginPage.loginEnterEmail("sdet@tester.com");
    }

    private static StringBuilder output = new StringBuilder("");

    @Test
    public void myATest() {
        output.append("A");
    }

    @Test
    public void myAATest() {
        output.append("AA");
    }

    @Test
    public void myZTest() {
        output.append("Z");
    }

    @Test
    public void myCTest() {
        output.append("C");
    }

    @Test
    public void myBTest() {
        output.append("B");
    }

    @AfterAll
    public static void assertOutput() {
        assertEquals("AAABCZA", output.toString());
    }


}
