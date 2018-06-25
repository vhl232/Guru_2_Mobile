package guruMobile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageMobile_2 {
    WebDriver driver;

    @FindBy(xpath = "//*[@class='page-title category-title']")
    WebElement titleMobilePage;


    public PageMobile_2(WebDriver driver) {
        this.driver = driver;
        driver.get(UtilsClass.urlMobilePage);
        PageFactory.initElements(driver,this);
    }
}
