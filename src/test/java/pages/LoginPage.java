package pages;

import framework.ConfigReader;
import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class LoginPage {

    //WebDriver setups
    WebDriver driver;
    WebDriverWait wait;
    Helper elementHelper;

    //elements in login page
    By login_LoginButton= By.id("ctx-LoginBtn");
    By login_EmailInput=By.cssSelector("[name=email]");
    By login_PasswordInput=By.cssSelector("[name=password]");

    //login page constructor
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,10);
        this.elementHelper=new Helper(driver);
    }

    //login page functions
    public void login_getUrl()
    {
        String homePageUrl= ConfigReader.initialize_Properties().getProperty("url");
        String currentUrl= driver.getCurrentUrl();
        assertEquals(currentUrl,homePageUrl);
    }


    public void loginEnterEmail(String userEmail)
    {
        elementHelper.sendKey(login_EmailInput,userEmail);
    }

    public void loginEnterPassword(String userPassword)
    {
        elementHelper.sendKey(login_PasswordInput,userPassword);
    }

    public void clickLoginButton()
    {
        elementHelper.click(login_LoginButton);
    }

}