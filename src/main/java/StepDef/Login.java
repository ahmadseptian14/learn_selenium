package StepDef;

import config.env;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;

public class Login extends env {
    @Given("User is on login page")
    public void user_is_on_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(sauceDemo);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit'][@data-test='login-button']"))
        );
    }

    @When("User fill username and password")
    public void user_fill_username_and_password() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click  login button")
    public void userClickLoginButton() {
        driver.findElement(By.xpath("//input[@type='submit'][@data-test='login-button']")).click();
    }

    @Then("User verify login result")
    public void user_verify_login_result() {
        Duration duration  = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header_container']/div[2]/span"))
        );
    }

    @When("User click menu sidebar")
    public void userClickMenuSidebar() {
        driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']")).click();
    }

    @And("User click logout button")
    public void userClickLogoutButton() {
        driver.findElement(By.id("logout_sidebar_link")).click();
        driver.quit();
    }

    @When("User fill invalid username and password")
    public void userFillInvalidUsernameAndPassword() {
        driver.findElement(By.name("user-name")).sendKeys("test");
        driver.findElement(By.id("password")).sendKeys("123");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        driver.findElement(By.className("error-button"));
    }

    @When("^User input (.*) and (.*)$")
    public void userInputUsernameAndPassword(String username, String password) {
        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("^User get verify login (.*)$")
    public void userGetVerifyLoginResult(String result) {
        Duration duration  = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        if (result == "passed"){
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header_container']/div[2]/span"))
            ));
        }else if (result == "failed") {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3"))
            ));
        }
        driver.quit();
    }
}

