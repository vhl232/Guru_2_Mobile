package guruMobile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestMainClass {
        WebDriver driver;

        @BeforeTest
        public void setPropertys(){
                System.setProperty("webdriver.chrome.driver",UtilsClass.locationWebDriver);
                driver = new ChromeDriver();
                driver.get(UtilsClass.urlGuru);
        }


        @Test
        public void checkTitle(){
                PageMain_GuruMobile pageMain_guruMobile = new PageMain_GuruMobile(driver);
                String titleMainPage =  pageMain_guruMobile.mainTitle.getText();
                //System.out.println(titleMainPage);
                Assert.assertEquals(UtilsClass.mainPageTitle,titleMainPage);

        }

        @Test
        public void clickButtonMobile(){
                PageMain_GuruMobile pageMain_guruMobile = new PageMain_GuruMobile(driver);
                pageMain_guruMobile.mobileButton.click();
        }

        @Test
        public void checkMobileTitle(){
                PageMobile_2 pageMobile_2 = new PageMobile_2(driver);
                String titleMobile = pageMobile_2.titleMobilePage.getText();
                Assert.assertEquals(UtilsClass.mobilePageTitle,titleMobile);
    }

        /*@AfterTest
        public void closeTest(){
                driver.quit();
        }*/


}
