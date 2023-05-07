package demo.com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import demo.com.tutorialninja.customlisteners.CustomListeners;
import demo.com.tutorialninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class DesktopPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopsText;

    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;

    @FindBy(id = "input-sort")
    WebElement sortBy;


    public String getDesktopsText() {
        CustomListeners.test.log(Status.PASS, "Get desktop text " + desktopsText);
        Reporter.log("Get desktop text" + desktopsText.toString());
        return getTextFromElement(desktopsText);
    }

    public ArrayList<String> getProductsNameList() {
        CustomListeners.test.log(Status.PASS, "Get product " + productsList);
        Reporter.log("Select option from " + productsList.toString());
        List<WebElement> products = getListOfElements(productsList);
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        return originalProductsName;
    }

    public void selectProductByName(String product) {
        CustomListeners.test.log(Status.PASS, "Select product " + productsList);
        Reporter.log("Select option from " + productsList.toString());
        List<WebElement> products = getListOfElements(productsList);
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }

    public void selectSortByOption(String option) {
        selectByVisibleTextFromDropDown(sortBy, option);
        CustomListeners.test.log(Status.PASS, "Select " + option);
        Reporter.log("Select " + option + " to sort by " + sortBy.toString());
    }
}
