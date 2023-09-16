package StepDef.Github;

import config.env;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Github.homePage;
import pages.Github.loginPage;

import java.time.Duration;

public class Login extends env{
    @Given("User is on github homepage")
    public void userIsOnGithubHomepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(githubLink);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body"))
        );
    }

    @When("User click Sign in link button")
    public void userClickSignInLinkButton() {
        homePage signInPage = new homePage(driver);
        signInPage.clickSignInButton();
    }

    @Then("User is in Login page")
    public void userIsInLoginPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login']/div[1]"))
        );
    }

    @When("User fill field username and password")
    public void userFillFieldUsernameAndPassword() {
        loginPage inputCredential = new loginPage(driver);
        inputCredential.inputUsernamePassword("ahmadseptian14", "septian140900");
    }

    @And("User click Sign in button")
    public void userClickSignInButton() {
        loginPage loginButton = new loginPage(driver);
        loginButton.clickLoginButton();
    }

    @Then("User is in Dashboard page")
    public void userIsInDashboardPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/header/div/div[1]/div/div[2]/nav/ul/li/a"))
        );
    }

}
