package pages.Github;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class dashboardPage {
    WebDriver driver;

    public dashboardPage(WebDriver driver){
        this.driver = driver;
    }

    //    Locator
    By ProfileButton = By.xpath("/html/body/div[1]/div[1]/header/div/div[2]/div[3]");
    By RepositoryMenu = By.xpath("//*[@id='item-9e458d96-776b-42e4-9e69-bd091bc5b7c2']");

    public void clickProfile(){
        driver.findElement(ProfileButton).click();
    }

    public void clickRepository(){
        driver.findElement(RepositoryMenu).click();
    }
}
