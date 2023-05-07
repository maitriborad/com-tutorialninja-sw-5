package demo.com.tutorialninja.testsuite;

import demo.com.tutorialninja.customlisteners.CustomListeners;
import demo.com.tutorialninja.pages.AccountLoginPage;
import demo.com.tutorialninja.pages.AccountRegisterPage;
import demo.com.tutorialninja.pages.HomePage;
import demo.com.tutorialninja.pages.MyAccountPage;
import demo.com.tutorialninja.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class AccountRegisterPageTest extends BaseTest {
    HomePage homePage;
    AccountLoginPage accountLoginPage;
    MyAccountPage myAccountPage;
    AccountRegisterPage accountRegisterPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        accountLoginPage = new AccountLoginPage();
        myAccountPage = new MyAccountPage();
        accountRegisterPage = new AccountRegisterPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Register");
        softAssert(accountRegisterPage.getRegisterAccountText(),
                "Register Account", "Register page not displayed");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Register");
        accountRegisterPage.enterFirstName("prime" + getAlphaNumericString(4));
        accountRegisterPage.enterLastName("test" + getAlphaNumericString(4));
        accountRegisterPage.enterEmail("prime" + getAlphaNumericString(4) + "@gmail.com");
        accountRegisterPage.enterTelephone("07988112233");
        accountRegisterPage.enterPassword("test123");
        accountRegisterPage.enterConfirmPassword("test123");
        accountRegisterPage.selectSubscription("Yes");
        accountRegisterPage.clickOnPrivacyPolicyCheckBox();
        accountRegisterPage.clickOnContinueButton();
        softAssert(myAccountPage.getYourAccountHasBeenCreatedText(), "Your Account Has Been Created!",
                "Account not created");
        myAccountPage.clickOnContinueButton();
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Logout");
        softAssert(myAccountPage.getAccountLogoutText(), "Account Logout", "Not logged out");
        Thread.sleep(1000);
        myAccountPage.clickOnContinueButton();
    }
}
