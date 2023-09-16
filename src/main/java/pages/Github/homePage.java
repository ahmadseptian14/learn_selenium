package pages.Github;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
    WebDriver driver;

    public homePage(WebDriver driver){
        this.driver = driver;
    }

//    Locator
    By SignInButton = By.xpath("/html/body/div[1]/div[1]/header/div/div[2]/div/div/div/a");

    public void clickSignInButton(){
        driver.findElement(SignInButton).click();
    }
}
