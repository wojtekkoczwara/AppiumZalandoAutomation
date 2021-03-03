import DriverSetUp.AndroidDriverSetUp;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.SplashScreenPage;
import utilities.Constant;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

public class ProductFindAndBuyFlowTest extends AndroidDriverSetUp {

    private static AndroidDriver<AndroidElement> driver;
    private static String keepAppDataSaved = "false";

    @BeforeTest
    public void setUp() throws MalformedURLException {

        driver = AndroidDriverSetUpMethod(driver, keepAppDataSaved);

    }

    @Test (priority = 0)
    public void findAndBuyTest() throws InterruptedException, IOException {

        //Start with logging in.

        SplashScreenPage splashScreenPage = new SplashScreenPage(driver);

        splashScreenPage.loginButtonClick();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginCredentialsInsert(Constant.email, Constant.password);

        loginPage.loginSubmit();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.welcomePopUpCloseMethod();

        WebDriverWait wait = new WebDriverWait(driver, 5);

        LandingPage landingPage = new LandingPage(driver);

        landingPage.personalLeftPanelActivation();
        landingPage.chooseMen();
        landingPage.searchProductButtonClick();

        Assert.assertTrue(driver.findElementsByClassName("androidx.appcompat.app.ActionBar$b").
                get(1).isSelected(), "Element not selected");



        driver.findElementsById("de.zalando.mobile:id/top_category_item").get(1).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text = 'Sneakersy']")));

        driver.findElementByXPath("//*[@text = 'Sneakersy']").click();

       wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text = 'Wszystko: Sneakersy']")));

        driver.findElement(By.xpath("//*[@text = 'Wszystko: Sneakersy']")).click();

        driver.findElement(By.id("de.zalando.mobile:id/zds_link_text")).click();


        driver.findElementByXPath
                ("//android.widget.LinearLayout[@index = 2]/android.widget.RelativeLayout/" +
                        "android.widget.ImageView[@resource-id = 'de.zalando.mobile:id/" +
                        "filter_expand_collapse_imageview']").click();

        driver.findElementByXPath
                ("//*[@text = '43' and @resource-id = 'de.zalando.mobile:id/zds_selector_text']").click();

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()." +
                "resourceId(\"de.zalando.mobile:id/filter_overview_recycler_view\"))." +
                "scrollIntoView(new UiSelector()." +
                "resourceId(\"de.zalando.mobile:id/filter_overview_searchable_list_brand_button\").instance(0));").
                click();


        try{
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()." +
                    "resourceId(\"de.zalando.mobile:id/sticky_list\"))." +
                    "scrollIntoView(new UiSelector().textMatches(\"Lacoste\").instance(0));").click();
        }
        catch (NoSuchElementException e){
            System.out.println("Probably scrolled too far. Trying scroll again");

            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()." +
                    "resourceId(\"de.zalando.mobile:id/sticky_list\"))." +
                    "scrollIntoView(new UiSelector().textMatches(\"Lacoste\").instance(0));").click();
        }

        driver.findElementById("de.zalando.mobile:id/apply").click();


        driver.findElementById("de.zalando.mobile:id/filter_show_result_btn_container").click();

        String productPriceAtList = driver.findElementsById("de.zalando.mobile:id/zds_vertical_product_card_price").
                get(0).getText();

        driver.findElementsById("de.zalando.mobile:id/catalog_item_card").get(0).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.ImageView")));

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"android:id/content\")).scrollIntoView(new UiSelector().resourceId(\"de.zalando.mobile:id/zds_dropdown_text\").instance(0));");

        String productPriceAtCard = driver.findElementById("de.zalando.mobile:id/pdp_weave_product_info_price").
                getText();
        Assert.assertEquals(productPriceAtCard, productPriceAtCard,
                "Product price not equal, do the correct validation");

        driver.findElementByXPath("//*[@resource-id = 'de.zalando.mobile:id/zds_dropdown_text']").click();
        driver.findElementByAndroidUIAutomator("text(\"41\")").click();
        Assert.assertEquals(driver.findElementById("de.zalando.mobile:id/zds_dropdown_text").getText(),
                "41", "Size not added");
        driver.findElementById("de.zalando.mobile:id/pdp_inline_cta_primary_button").click();
        driver.findElementById("de.zalando.mobile:id/pdp_inline_cta_primary_button").click();

        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.id("de.zalando.mobile:id/zds_single_notification_link"))).click();

        driver.findElementById("de.zalando.mobile:id/cart_checkout_button").click();

        driver.findElementById("delivery-destination-tab-1").click();

        driver.findElementByXPath("//*[@class = 'android.widget.ToggleButton' and @checked = 'false']").click();

        driver.findElementById("street-address").clear();
        driver.findElementById("street-address").sendKeys(Constant.address);

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(class(\"android.widget.Button\"));");

        driver.findElementById("postal-code").clear();
        driver.findElementById("postal-code").sendKeys(Constant.postalCode);

        driver.findElementById("address-level2").clear();
        driver.findElementById("address-level2").sendKeys(Constant.city);

//        DateFormat df = new SimpleDateFormat("dd-MM-yy HH.mm.ss");
//        Date dateobj = new Date();
//
//        TakesScreenshot scrShot = ((TakesScreenshot)driver);
//        File ScrFile = scrShot.getScreenshotAs(OutputType.FILE);
//
//        File DestFile = new File("./ScreenShots/ScreenShot + " + df.format(dateobj) + ".jpg");
//
//        FileUtils.copyFile(ScrFile, DestFile);



    }

//    @AfterTest
//
//    public void tearDown(){
//
//        driver.quit();
//    }

}
