package guruMobile.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import guruMobile.UtilsClass;

public class PageMobile_2 implements Pageable<PageMobile_2> {
    private WebDriver driver;

    public WebElement getTitleMobilePage() {
        return titleMobilePage;
    }

    @FindBy(xpath = "//*[@class='page-title category-title']")
    private WebElement titleMobilePage;

    @FindBy(tagName = "html")
    private WebElement html;

    @FindBy(xpath = "//*[@title='Sort By']")
    private WebElement sortMenu;
    @FindBy(xpath = "//ul[@class='products-grid']")
    private WebElement productGrid;

    public List<WebElement> getProductsList() {
        return productsList;
    }

    @FindBy(className = "product-name")
    private List<WebElement> productsList;

    public WebElement getProductGrid() {
        return productGrid;
    }

    public WebElement getSortMenu() {
        return sortMenu;
    }

    public WebElement getHtml() {
        return html;
    }

    public PageMobile_2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public PageMobile_2 init() {
        driver.get(UtilsClass.urlMobilePage);

        return this;
    }

    public boolean isSuitable() {
        return driver.getCurrentUrl().equals(UtilsClass.urlMobilePage);
    }



}