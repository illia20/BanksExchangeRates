package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankAvalPage extends Page{
    private String url = "https://ex.aval.ua/ru/personal/everyday/exchange/exchange/";
    private By xpathSell = By.xpath("//table[@class='body-currency']/tbody/tr[2]/td[3]");
    private By xpathBuy = By.xpath("//table[@class='body-currency']/tbody/tr[2]/td[2]");

    public BankAvalPage(WebDriver driver){
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
