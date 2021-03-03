//package pageObjects;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;
//import java.util.List;
//
//public class ProductListPage {
//
//    private static WebDriver driver;
//
//    public ProductListPage(WebDriver driver){
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//
//    @FindBy(name = "_ctTL_r0_ddlQuantity")
//    List<WebElement> tireAmountSelectorList;
//
//    @FindBy(name = "_ctTL_r0_ddlQuantity")
//    WebElement dropDownAmount;
//
//    @FindBy(id = "_ctTL_r0_bttnATC")
//    WebElement goToCartFromProductListButton;
//
//    @FindBy (xpath = "//div[@class = 'column sum']/div[@class = 'summary']/span[@class = 'price']")
//    WebElement totalPositionAmountElement;
//
//    @FindBy (xpath = "//div[@class = 'cartSummary container']/div[@class = 'summary']/p/strong")
//    WebElement totalAmountElement;
//
//    @FindBy(id = "cm_c_lbGTO")
//    WebElement confirmOrder;
//
//    public void chooseProduct(){
//        tireAmountSelectorList.get(0).click();
//    }
//
//
//
//    public void setDropDownAmount(String amount){
//        Select dropDOwnAmountSelect = new Select(dropDownAmount);
//        dropDOwnAmountSelect.selectByValue(amount);
//    }
//
//    public void goToCartFromProductList(){
//        goToCartFromProductListButton.click();
//    }
//
//    public int getPositionAmountValue (){
//        String totalPositionAmountText = totalPositionAmountElement.getText();
//        int totalPositionAmount = priceStringToIntConverter(totalPositionAmountText);
//        return totalPositionAmount;
//    }
//
//    public int getTotalAmountValue(){
//        String totalAmountText = totalAmountElement.getText();
//        int totalAmount = priceStringToIntConverter(totalAmountText);
//        return totalAmount;
//    }
//
//    public void confirmOrder(){
//        confirmOrder.click();
//    }
//
//
//
//
//
//    public int priceStringToIntConverter (String amountText){
//        int totalPositionAmountTextLength = amountText.length();
//        if (totalPositionAmountTextLength == 6){
//            amountText = amountText.substring(0,3);
//        }
//        else if (totalPositionAmountTextLength == 7) {
//            amountText = amountText.substring(0,4);
//        }
//        else {
//            System.out.println("Amount of tires chosen is too big");
//        }
//        int totalAmount = Integer.parseInt(amountText);
//        return totalAmount;
//    }
//}
