package demo.com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import demo.com.tutorialninja.customlisteners.CustomListeners;
import demo.com.tutorialninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNotebooksText;

    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productsPrices;

    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;

    @FindBy(id = "input-sort")
    WebElement sortBy;

    public String getLaptopsAndNotebooksText() {
        CustomListeners.test.log(Status.PASS,"Get text " + laptopsAndNotebooksText);
        Reporter.log("Get text " + laptopsAndNotebooksText.toString());
        return getTextFromElement(laptopsAndNotebooksText);
    }

    public ArrayList<Double> getProductsPriceList() {
        CustomListeners.test.log(Status.PASS,"Get product prices " + productsPrices);
        Reporter.log("Get product prices " + productsPrices.toString());
        List<WebElement> products = getListOfElements(productsPrices);
        ArrayList<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return originalProductsPrice;
    }

    public void selectSortByOption(String option) {
        selectByVisibleTextFromDropDown(sortBy, option);
        CustomListeners.test.log(Status.PASS,"Select option " + option);
        Reporter.log("Select option from " + sortBy.toString());
    }

    public void selectProductByName(String product) {
        CustomListeners.test.log(Status.PASS,"Select option " + product);
        Reporter.log("Select "+product+" from " + productsList.toString());
        List<WebElement> products = getListOfElements(productsList);
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }
}
