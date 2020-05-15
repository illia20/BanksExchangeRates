package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankOschadPage extends Page{

    private String url = "https://www.oschadbank.ua/ua";
    private By xpathSell = By.xpath("//strong[@class='sell-USD']");
    private By xpathBuy = By.xpath("//strong[@class='buy-USD']");

    public BankOschadPage(WebDriver driver){
        super(driver);
    }

    public By getXpathSell(){
        return xpathSell;
    }
    public By getXpathBuy(){
        return xpathBuy;
    }
    public String getUrl(){
        return url;
    }
}

