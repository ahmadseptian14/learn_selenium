package StepDef;

import config.env;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.homePages;
import pages.registerPages;

import java.time.Duration;

public class Regis extends env {
    @Given("User is on parabank homepage")
    public void user_is_on_parabank_homepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(parabankLink);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftPanel']"))
        );
    }

    @When("User click register link button")
    public void userClickRegisterLinkButton() {
        homePages registerpages = new homePages(driver);
        registerpages.clickRegister();
    }

    @Then("User is in register page")
    public void userIsInRegisterPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rightPanel']/h1"))
        );
    }

    @When("User input name")
    public void userInputName() {
        registerPages inputName = new registerPages(driver);
        inputName.inputNameData("Ahmad", "Ganteng");
    }

    @And("User input address detail")
    public void userInputAddressDetail() {
        registerPages inputAddress = new registerPages(driver);
        inputAddress.inputAddressDetail("Kp.Kebon Kopi Sukamaju", "Rangkasbitung", "test", "42114", "0895349203286", "test");
    }

    @And("User fill valid username and password")
    public void userFillValidUsernameAndPassword() {
        registerPages inputCredential = new registerPages(driver);
        inputCredential.inputUsernamePassword("septian1960", "12345");
    }

    @And("User input password confirmation")
    public void userInputPasswordConfirmation() {
        registerPages passwordConfirmation = new registerPages(driver);
        passwordConfirmation.inputPasswordConfirmation("12345");
    }

    @When("User click register button")
    public void userClickRegisterButton() {
        registerPages registerButton = new registerPages(driver);
        registerButton.clickRegisterButton();
    }

    @Then("User registration successfully")
    public void userRegistrationSuccessfully() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rightPanel']/p"))
        );
    }

    @And("User input invalid password confirmation")
    public void userInputInvalidPasswordConfirmation() {
        registerPages passwordConfirmation = new registerPages(driver);
        passwordConfirmation.inputInvalidPassowrdConfirmation("111111");
    }

    @Then("User get error password did not match")
    public void userGetErrorPasswordDidNotMatch() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='repeatedPassword.errors']"))
        );
    }
}
