package demo.com.tutorialninja.testsuite;

import demo.com.tutorialninja.customlisteners.CustomListeners;
import demo.com.tutorialninja.pages.DesktopPage;
import demo.com.tutorialninja.pages.HomePage;
import demo.com.tutorialninja.pages.ProductPage;
import demo.com.tutorialninja.pages.ShoppingCartPage;
import demo.com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;

@Listeners(CustomListeners.class)
public class DesktopsPageTest extends BaseTest {
    HomePage homePage;
    DesktopPage desktopPage;
    ProductPage productPage;
    ShoppingCartPage cartPage;
    SoftAssert softAssert;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        productPage = new ProductPage();
        cartPage = new ShoppingCartPage();
        softAssert=new SoftAssert();
    }
    @Test(groups = {"sanity","regression"})
    public void verifyProductArrangeInAlphabeticalOrder(){
        homePage.mouseHoverOnDesktopsLinkAndClick();
        homePage.selectMenu("Show AllDesktops");
        homePage.selectCurrency("£ Pound Sterling");
        // Get all the products name and stored into array list
        ArrayList<String> originalProductsName = desktopPage.getProductsNameList();
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        // Select sort by Name Z - A
        desktopPage.selectSortByOption("Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        ArrayList<String> afterSortByZToAProductsName = desktopPage.getProductsNameList();
        Assert.assertEquals(originalProductsName, afterSortByZToAProductsName, "Product not sorted into Z to A order");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        homePage.mouseHoverOnDesktopsLinkAndClick();
        homePage.selectMenu("Show AllDesktops");
        homePage.selectCurrency("£ Pound Sterling");
        desktopPage.selectSortByOption("Name (A - Z)");
        desktopPage.selectProductByName("HP LP3065");
        softAssert(productPage.getProductText(), "HP LP3065", "HP LP3065 Product not display");
        productPage.selectDeliveryDate("30", "November", "2023");
        productPage.enterQuantity("1");
        productPage.clickOnAddToCartButton();
        Assert.assertTrue(productPage.getProductAddedSuccessMessage().contains("Success: You have added HP LP3065 to your shopping cart!"),
                "Product not added to cart");
        Thread.sleep(2000);
        productPage.clickOnShoppingCartLinkIntoMessage();
        Assert.assertTrue(cartPage.getShoppingCartText().contains("Shopping Cart"));
        softAssert(cartPage.getProductName(), "HP LP3065", "Product name not matched");
        Assert.assertTrue(cartPage.getDeliveryDate().contains("2023-11-30"), "Delivery date not matched");
        softAssert(cartPage.getModel(), "Product 21", "Model not matched");
        softAssert(cartPage.getTotal(), "£74.73", "Total not matched");
        softAssert.assertAll();
    }
}
