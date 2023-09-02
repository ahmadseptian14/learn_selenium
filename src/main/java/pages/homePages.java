package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePages {
    WebDriver driver;

    public homePages(WebDriver driver) {
        this.driver = driver;
    }

//    Locator
    By RegisterButton = By.xpath("//*[@id='loginPanel']/p[2]/a");

//    Method cick register button
    public void clickRegister(){
        driver.findElement(RegisterButton).click();
    }
}
