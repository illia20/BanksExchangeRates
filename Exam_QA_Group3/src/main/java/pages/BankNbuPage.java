package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankNbuPage extends Page{
                          //"http://www.bank.gov.ua/control/uk/curmetal/detail/currency?period=daily";
                          //"https://bank.gov.ua/markets/exchangerates/"
    private String url = "http://www.bank.gov.ua/control/uk/curmetal/detail/currency?period=daily";
    private By xpath = By.xpath("//*[@id=\"exchangeRates\"]/tbody/tr[contains(., 'USD')]/td[5]");

        public BankNbuPage(WebDriver driver){
             super(driver);
        }
    public By getXpathNbu(){
        return xpath;
    }
    public String getUrl(){
        return url;
    }

}
