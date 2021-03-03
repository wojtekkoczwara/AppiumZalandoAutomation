//package pageObjects;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import java.util.List;
//
//public class OrderPage {
//
//    private static WebDriver driver;
//
//    public OrderPage(WebDriver driver){
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//
//    @FindBy(name = "OF_ed_ffDfImie_tb")
//    WebElement firstNameInput;
//
//    @FindBy(name = "OF_ed_ffDfNazwisko_tb")
//    WebElement lastNameInput;
//
//    @FindBy(name = "OF_ed_ffDfAdres_tb")
//    WebElement addressInput;
//
//    @FindBy(name = "OF_ed_ffDfKodPocztowy_ctInp")
//    WebElement postalCodeInput;
//
//    @FindBy(name = "OF_ed_ffDfMiejscowosc_tb")
//    WebElement cityInput;
//
//    @FindBy(name = "OF_ed_ffDwTelefon_ctInp")
//    WebElement phoneInput;
//
//    @FindBy(name = "OF_ed_ffDwEmail_ctInp")
//    WebElement emailInput;
//
//    @FindBy(css = "div[class = 'bgForm paymentOption']")
//    WebElement bgFormPaymentOption;
//
//    @FindBy(xpath = "//div[@class = 'transferBox']")
//    List<WebElement> paymentMethod;
//
//    @FindBy(css = "div[class = 'bgForm regulations ']")
//    WebElement bgFormRegulationsContainer;
//
//    @FindBy(xpath = "//label[@class = 'regimen required firstTime correct']/span[@class = 'checkbox ']")
//    WebElement bgFormRegulationsCheckbox;
//
//    public void setPersonalData(String firstName, String lastName, String address,
//                                String postalCode, String city, String phone, String email){
//        firstNameInput.sendKeys(firstName);
//        lastNameInput.sendKeys(lastName);
//        addressInput.sendKeys(address);
//        postalCodeInput.sendKeys(postalCode);
//        cityInput.sendKeys(city);
//        phoneInput.sendKeys(phone);
//        emailInput.sendKeys(email);
//    }
//
//    public void choosePayment(String paymentMethodChosenText){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", bgFormPaymentOption);
//        for (int i = 0, paymentMethodSize = paymentMethod.size(); i < paymentMethodSize; i++) {
//            WebElement webElement = paymentMethod.get(i);
//            String paymentMethodText = webElement.getText();
//            if (paymentMethodText.contains(paymentMethodChosenText)) {
//                webElement.click();
//                break;
//            }
//        }
//    }
//
//    public void bgFormRegulationsCheck(){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", bgFormRegulationsContainer);
//        bgFormRegulationsCheckbox.click();
//    }
//}
