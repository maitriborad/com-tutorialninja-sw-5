package demo.com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import demo.com.tutorialninja.customlisteners.CustomListeners;
import demo.com.tutorialninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement model;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement total;
    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement qtyField;
    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement qtyUpdateBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement successModifiedMessage;

    public String getShoppingCartText() {
        CustomListeners.test.log(Status.PASS,"Get text " + shoppingCartText);
        Reporter.log("Get text " + shoppingCartText.toString());
        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() {
        CustomListeners.test.log(Status.PASS,"Get product name " + productName);
        Reporter.log("Get product name" + productName.toString());
        return getTextFromElement(productName);
    }

    public String getDeliveryDate() {
        CustomListeners.test.log(Status.PASS,"Get delivery date " + deliveryDate);
        Reporter.log("Get delivery date" + deliveryDate.toString());
        return getTextFromElement(deliveryDate);
    }

    public String getModel() {
        CustomListeners.test.log(Status.PASS,"Get Model name " + model);
        Reporter.log("Get Model name" + model.toString());
        return getTextFromElement(model);
    }

    public String getTotal() {
        CustomListeners.test.log(Status.PASS,"Get total " + total);
        Reporter.log("Get total" + total.toString());
        return getTextFromElement(total);
    }

    public void changeQuantity(String qty) {
        sendTextToElement(qtyField, qty);
        CustomListeners.test.log(Status.PASS,"Change quantity " + qty);
        Reporter.log("Change quantity" + qty.toString());
    }

    public void clickOnQtyUpdateButton() {
        clickOnElement(qtyUpdateBtn);
        CustomListeners.test.log(Status.PASS,"Click on update " + qtyUpdateBtn);
        Reporter.log("Click on update" + qtyUpdateBtn.toString());
    }

    public String getSuccessModifiedMessage() {
        CustomListeners.test.log(Status.PASS,"Get success message " + successModifiedMessage);
        Reporter.log("Get success message" + successModifiedMessage.toString());
        return getTextFromElement(successModifiedMessage);
    }
}
