package guruMobile.email;

import guruMobile.UtilsClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;

public class Email {
    WebDriver driver;
    static MadgentoAdminPanelPage madgentoAdminPanelPage;
    static LoginPage loginPage;
    static String id = "user01";
    static String pass = "guru99com";
    @BeforeTest
    public void setPropery() throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", UtilsClass.locationWebDriver);
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        driver.get("http://live.guru99.com/index.php/backendlogin");

        loginPage = new LoginPage(driver);
        loginPage.getUserNameField().sendKeys(id);
        loginPage.loginField.sendKeys(pass);
        loginPage.getLoginButton().click();
        closePopUp();

    }

    @Test
    public void email() {

       madgentoAdminPanelPage = new MadgentoAdminPanelPage(driver);

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement sales = wait.until(ExpectedConditions.visibilityOf(madgentoAdminPanelPage.getSalesButton()));
        Action action = actions.moveToElement(sales)
                .click(madgentoAdminPanelPage.getOrdersButton()).build();
        action.perform();

        Select select = new Select(madgentoAdminPanelPage.getSelectCSV());
        select.selectByVisibleText("CSV");

        madgentoAdminPanelPage.getExportButton().click();



    }

    public void closePopUp() throws AWTException {
        Robot robot = new Robot();
        robot.mouseMove(701,426);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

    }
}
