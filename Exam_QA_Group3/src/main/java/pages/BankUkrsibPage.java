package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankUkrsibPage extends Page{

    private String url = "https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/";
    private By xpathSell = By.xpath("//table[@class='currency__table']//tbody/tr[1]/td[3]");
    private By xpathBuy = By.xpath("//table[@class='currency__table']//tbody/tr[1]/td[2]");

    public BankUkrsibPage(WebDriver driver){
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
