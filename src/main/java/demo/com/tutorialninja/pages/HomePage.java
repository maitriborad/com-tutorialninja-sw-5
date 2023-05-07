package demo.com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import demo.com.tutorialninja.customlisteners.CustomListeners;
import demo.com.tutorialninja.utility.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> topMenu;

    @FindBy(linkText = "Desktops")
    WebElement desktopLink;

    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooksLink;

    @FindBy(linkText = "Components")
    WebElement componentsLinks;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyTab;
    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li")
    List<WebElement> currencyList;

    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountTab;

    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    List<WebElement> myAccountOptions;

    public void selectMenu(String menu) {
        CustomListeners.test.log(Status.PASS,"Select option " + menu);
        Reporter.log("Select " +menu +" from " + topMenu.toString());
        List<WebElement> topMenuList = topMenu;
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = topMenu;
        }
    }

    public void mouseHoverOnDesktopsLinkAndClick() {
        mouseHoverToElementAndClick(desktopLink);
       CustomListeners.test.log(Status.PASS,"Click on desktop " + desktopLink);
        Reporter.log("Click on desktop " + desktopLink.toString());
    }

    public void mouseHoverOnLaptopsAndNotebooksLinkAndClick() {
        mouseHoverToElementAndClick(laptopsAndNotebooksLink);
        CustomListeners.test.log(Status.PASS,"Click laptops and notebooks " + laptopsAndNotebooksLink);
        Reporter.log("Click on laptops and notebooks " + laptopsAndNotebooksLink.toString());
    }

    public void mouseHoverOnComponentLinkAndClick() {
        mouseHoverToElementAndClick(componentsLinks);
        CustomListeners.test.log(Status.PASS,"Click on components " + componentsLinks);
        Reporter.log("Click on components " + componentsLinks.toString());
    }

    public void selectCurrency(String currency) {
        CustomListeners.test.log(Status.PASS,"Select option " + currency);
        Reporter.log("Select " + currency +" from " + currencyList.toString());
        clickOnElement(currencyTab);
        List<WebElement> listOfElements = getListOfElements(currencyList);
        for (WebElement e : listOfElements) {
            if (e.getText().equalsIgnoreCase(currency)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnMyAccountTab() {
        clickOnElement(myAccountTab);
        CustomListeners.test.log(Status.PASS,"Click on my account " + myAccountTab);
        Reporter.log("Click on my account " + myAccountTab.toString());
    }

    public void selectMyAccountOptions(String option) {
        CustomListeners.test.log(Status.PASS,"Select option " + option);
        Reporter.log("Select " + option +" from " + myAccountOptions.toString());
        List<WebElement> myAccountList = getListOfElements(myAccountOptions);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = getListOfElements(myAccountOptions);
        }
    }
}
