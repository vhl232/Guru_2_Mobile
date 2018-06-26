package guruMobile.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import guruMobile.UtilsClass;

public class PageMain_GuruMobile implements Pageable<PageMain_GuruMobile> {

    WebDriver driver;
    @FindBy(xpath = "//*[@class='page-title']")
    private WebElement mainTitle;

    @FindBy(xpath = "//*[@class='level0 nav-1 first']")
    private WebElement mobileButton;
    @FindBy(tagName = "html")
    private WebElement html;

    public WebElement getHtml() {
        return html;
    }

    public PageMain_GuruMobile(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public WebElement getMainTitle() {
        return mainTitle;
    }

    public WebElement getMobileButton() {
        return mobileButton;
    }

    public PageMain_GuruMobile init() {
        driver.get(UtilsClass.urlGuru);

        return this;
    }

    public boolean isSuitable() {
        return  driver.getCurrentUrl().equals(UtilsClass.urlGuru);
    }


}
