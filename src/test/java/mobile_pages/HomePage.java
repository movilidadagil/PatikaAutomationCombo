package mobile_pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;
import testscenarios.ContactManagerAppiumTestNG;

@Data
public class HomePage   {

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(ContactManagerAppiumTestNG.Driver), this);

    }
    @AndroidFindBy(id = "addContactButton")
    private MobileElement addContactBtn;

    @AndroidFindBy(id = "addContactButton")
    public static MobileElement addContactBtnMert;

    @AndroidFindBy(id = "showInvisible")
    private MobileElement invisibleCheck;

}
