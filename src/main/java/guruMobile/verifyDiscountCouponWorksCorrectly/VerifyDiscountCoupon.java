package guruMobile.verifyDiscountCouponWorksCorrectly;

import guruMobile.UtilsClass;
import guruMobile.pages.PageMain_GuruMobile;
import guruMobile.pages.PageMobile_2;
import guruMobile.pages.ShopingCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyDiscountCoupon {
    WebDriver driver;
    ShopingCart shopingCart;
    @BeforeTest
    public void setProperties(){
        System.setProperty("webdriver.chrome.driver", UtilsClass.locationWebDriver);
        driver = new ChromeDriver();
        driver.get("http://live.guru99.com");
    }

    @Test
    public void verifyDiscountCoupon(){
        PageMain_GuruMobile pageMain_guruMobile = new PageMain_GuruMobile(driver);
        pageMain_guruMobile.getMobileButton().click();


        PageMobile_2 pageMobile_2 = new PageMobile_2(driver);
        pageMobile_2.getAddToCartSoniXperia().click();

        shopingCart = new ShopingCart(driver);
        Actions actions = new Actions(driver);
        Action enterDiscount = actions.click(shopingCart.getDiscountInputFild()).sendKeys("guru50").build();
        enterDiscount.perform();

        shopingCart.getButtonApply().click();
        String successMasegeAboutDisccount =  shopingCart.getMassedgeSuccess().getText();

        Assert.assertEquals("Coupon code \"guru50\" was applied.",successMasegeAboutDisccount);





        System.out.println(returnCoastSubTotal());
        System.out.println(shopingCart.getSubTotal().getText());

    }
    public double returnCoastSubTotal(){
        String subTotal =  shopingCart.getSubTotal().getText();
        double sub_total = Double.parseDouble((subTotal.replace("$","")));
        return sub_total;
    }

    @AfterTest
    public void close(){
        driver.quit();
    }
}
