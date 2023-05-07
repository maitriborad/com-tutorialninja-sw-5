package demo.com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import demo.com.tutorialninja.customlisteners.CustomListeners;
import demo.com.tutorialninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AccountLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[2]//h2")
    WebElement returningCustomerText;
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[1]//h2")
    WebElement newCustomerText;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddressField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;

    public String getReturningCustomerText() {
        CustomListeners.test.log(Status.PASS,"Get customer text");
        Reporter.log("Get heading text " + returningCustomerText.toString());
        return getTextFromElement(returningCustomerText);
    }

    public String getNewCustomerText() {
        CustomListeners.test.log(Status.PASS,"Getting new customer text");
        Reporter.log("Get heading text " + newCustomerText.toString());
        return getTextFromElement(newCustomerText);
    }

    public void enterEmailAddress(String email) {
        sendTextToElement(emailAddressField, email);
        CustomListeners.test.log(Status.PASS,"Enter EmailId " + email);
        Reporter.log("Enter email " + email + " to email field " + emailAddressField.toString());
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"Enter Password " + password);
        Reporter.log("Enter password " + password + " to password field " + passwordField.toString());
    }

    public void clickOnLoginButton() {
        clickOnElement(loginBtn);
        CustomListeners.test.log(Status.PASS,"Click on loginButton");
        Reporter.log("Click on log in Button "+ loginBtn.toString());
    }
}
