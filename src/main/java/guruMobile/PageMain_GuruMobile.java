package guruMobile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageMain_GuruMobile {

    WebDriver driver;
    @FindBy(xpath = "//*[@class='page-title']")
    WebElement mainTitle;

    @FindBy(xpath = "//*[@class='level0 nav-1 first']")
    WebElement mobileButton;



    public PageMain_GuruMobile(WebDriver driver) {
        this.driver = driver;
        driver.get(UtilsClass.urlGuru);
        PageFactory.initElements(driver,this);
    }
}
