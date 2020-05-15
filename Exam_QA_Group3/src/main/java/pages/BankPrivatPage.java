package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankPrivatPage extends Page{

    private String url = "https://www.privat24.ua/";
    private By xpath = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[2]");

    public BankPrivatPage(WebDriver driver){
        super(driver);
    }

    public By getXpathPrivat(){
        return xpath;
    }
    public String getUrl(){
        return url;
    }

}
