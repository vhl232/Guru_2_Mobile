package guruMobile.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopingCart {

    WebDriver driver;

    @FindBy(xpath = "//*[@class='page-title']")
    private WebElement message;

    public WebElement getMessage() {
        return message;
    }

    public ShopingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
