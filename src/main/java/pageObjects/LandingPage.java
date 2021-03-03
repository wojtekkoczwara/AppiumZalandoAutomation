package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    private static AndroidDriver<AndroidElement> driver;

    public LandingPage(AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "de.zalando.mobile:id/welcome_bottom_sheet_close_button")
    WebElement welcomePopUpClose;

    @AndroidFindBy(id = "de.zalando.mobile:id/home_tab_search")
    WebElement searchProductButton;

    @AndroidFindBy(id = "de.zalando.mobile:id/badge_item_counter")
    WebElement badgePersonalItem;

    @AndroidFindBy(id = "de.zalando.mobile:id/navigation_drawer_men_textview")
    WebElement menChoiceButton;

    @AndroidFindBy(id = "de.zalando.mobile:id/navigation_drawer_user_name_textview")
    public WebElement userNameTextView;

    public void welcomePopUpCloseMethod(){
        welcomePopUpClose.click();
    }

    public void personalLeftPanelActivation(){
        badgePersonalItem.click();
    }

    public void chooseMen (){
        menChoiceButton.click();
    }

    public void searchProductButtonClick(){
        searchProductButton.click();
    }



}
