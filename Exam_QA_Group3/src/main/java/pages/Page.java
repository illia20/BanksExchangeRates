package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page {
    protected WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
    }

    public void openPage(String url){
        driver.get(url);
    }
    public WebElement getRates(By xpath){
        return driver.findElement(xpath);
    }


}
