package demo.com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import demo.com.tutorialninja.customlisteners.CustomListeners;
import demo.com.tutorialninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;
public class AccountRegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement passwordConfirmField;
    @CacheLookup
    @FindBy(xpath = "//fieldset[3]//input")
    List<WebElement> subscribeRadios;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicyCheckBox;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueBtn;

    public String getRegisterAccountText() {
        CustomListeners.test.log(Status.PASS,"Get register text " + registerAccountText);
        Reporter.log("Get register text" + registerAccountText.toString());
        return getTextFromElement(registerAccountText);
    }

    public void enterFirstName(String fName) {
        sendTextToElement(firstNameField, fName);
        CustomListeners.test.log(Status.PASS,"Enter First name " + fName);
        Reporter.log("Enter First name " + fName + " to first name field " + firstNameField.toString());
    }

    public void enterLastName(String lName) {
        sendTextToElement(lastNameField, lName);
        CustomListeners.test.log(Status.PASS,"Enter Last name " + lName);
        Reporter.log("Enter Last name " + lName + " to last name field " + lastNameField.toString());
    }

    public void enterEmail(String email) {
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS,"Enter EmailId " + email);
        Reporter.log("Enter email " + email + " to email field " + emailField.toString());
    }

    public void enterTelephone(String telephone) {
        sendTextToElement(telephoneField, telephone);
        CustomListeners.test.log(Status.PASS,"Enter Telephone " + telephone);
        Reporter.log("Enter telephone " + telephone + " to telephone field " + telephoneField.toString());
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"Enter Password " + password);
        Reporter.log("Enter Password " + password + " to Password field " + passwordField.toString());
    }

    public void enterConfirmPassword(String cPassword) {
        sendTextToElement(passwordConfirmField, cPassword);
        CustomListeners.test.log(Status.PASS,"Enter Confirm Password " + cPassword);
        Reporter.log("Enter confirm Password " + cPassword + " to Confirm Password field " + passwordConfirmField.toString());
    }

    public void selectSubscription(String option) {
        CustomListeners.test.log(Status.PASS,"Select option " + option);
        Reporter.log("Select option from " + subscribeRadios.toString());
        List<WebElement> radioButtons = getListOfElements(subscribeRadios);
        for (WebElement e : radioButtons) {
            if (e.getText().equals(option)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnPrivacyPolicyCheckBox() {
        clickOnElement(privacyPolicyCheckBox);
        CustomListeners.test.log(Status.PASS,"Click privacy policy " + privacyPolicyCheckBox);
        Reporter.log("Click on Privacy policy " + privacyPolicyCheckBox.toString());
    }

    public void clickOnContinueButton() {
        clickOnElement(continueBtn);
        CustomListeners.test.log(Status.PASS,"Click continue " + continueBtn);
        Reporter.log("Click on continue " + continueBtn.toString());
    }

}
