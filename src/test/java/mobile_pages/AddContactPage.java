package mobile_pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;
import testscenarios.ContactManagerAppiumTestNG;

@Data
public class AddContactPage {


    public AddContactPage(){
        PageFactory.initElements(new AppiumFieldDecorator(ContactManagerAppiumTestNG.Driver), this);
    }

    @AndroidFindBy(id = "android:id/title")
    private MobileElement title;

    @AndroidFindBys({@AndroidFindBy(id="title"),@AndroidFindBy(tagName = "title")})
    private MobileElement titleBys;

    @AndroidFindBy(id = "accountSpinner")
    private MobileElement targetAccountField;

    @AndroidFindBy(id = "contactNameEditText")
    private MobileElement contactNameField;

    @AndroidFindBy(id = "contactPhoneEditText")
    private MobileElement contactPhoneField;

    @AndroidFindBy(id = "contactPhoneTypeSpinner")
    private MobileElement contactPhoneDrop;

    @AndroidFindBy(id = "contactEmailEditText")
    private MobileElement contactEmailField;

    @AndroidFindBy(id = "contactEmailTypeSpinner")
    private MobileElement contactEmailDrop;

    @AndroidFindBy(id = "contactSaveButton")
    private MobileElement contactSaveBtn;

}
