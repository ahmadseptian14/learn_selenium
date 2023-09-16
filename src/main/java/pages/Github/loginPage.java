package pages.Github;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    WebDriver driver;

    public loginPage(WebDriver driver){
        this.driver = driver;
    }

    By usernameField = By.id("login_field");
    By passwordField = By.id("password");
    By loginButton = By.xpath("//*[@id='login']/div[4]/form/div/input[13]");

    public void inputUsernamePassword(String username, String password){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
}
