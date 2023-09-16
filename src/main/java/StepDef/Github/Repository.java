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
import pages.Github.loginPage;
import pages.Github.dashboardPage;
import pages.Github.repositoryPage;


import java.time.Duration;

public class Repository extends env{
    @Given("User is on the Github login page")
    public void userIsOnTheGithubLoginPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(githubLoginLink);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login']/div[1]"))
        );
    }

    @When("^User add (.*) and (.*)$")
    public void userFillUsernameAndPassword(String username, String password) {
        loginPage inputCredential = new loginPage(driver);
        inputCredential.inputUsernamePassword(username, password);
    }

    @And("User click login button")
    public void userClickLoginButton() {
        loginPage loginButton = new loginPage(driver);
        loginButton.clickLoginButton();
    }

    @Then("User should be on the Github dashboard")
    public void userShouldBeOnTheGithubDashboard() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/header/div/div[1]/div/div[2]/nav/ul/li/a"))
        );
    }

    @When("User click profile menu")
    public void userClickProfileMenu() {
        dashboardPage profileButton = new dashboardPage(driver);
        profileButton.clickProfile();
    }

    @And("User click Repository menu")
    public void userClickRepositoryMenu() {
        dashboardPage repositoryMenu = new dashboardPage(driver);
        repositoryMenu.clickRepository();
    }

    @Then("User is in list Repository page")
    public void userIsInListRepositoryPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='repositories-tab']"))
        );
    }

    @When("User click new Repository button")
    public void userClickNewRepositoryButton() {
        repositoryPage newRepositoryButton = new repositoryPage(driver);
        newRepositoryButton.clickNewRepositoryButton();
    }

    @Then("User is in create a new Repository page")
    public void userIsInCreateANewRepositoryPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[6]/main/react-app/div/form/div[1]/h1"))
        );
    }

    @When("^User fill (.*) and (.*)$")
    public void userFillRepository_name(String repository_name, String description) {
        repositoryPage repositoryName = new repositoryPage(driver);
        repositoryName.inputRepositoryName(repository_name,description);
    }

    @And("User choose private")
    public void userChoosePrivate() {
        repositoryPage repositoryPrivate = new repositoryPage(driver);
        repositoryPrivate.checkRepositoryPrivate();
    }

    @And("User check add Readme file")
    public void userCheckAddReadmeFile() {
        repositoryPage repositoryReadme = new repositoryPage(driver);
        repositoryReadme.checkRepositoryReadme();
    }

    @And("User click create Repository button")
    public void userClickCreateRepositoryButton() {
        repositoryPage createRepositoryButton = new repositoryPage(driver);
        createRepositoryButton.clickCreateRepository();
    }

    @Then("User is in Repository detail page")
    public void userIsInRepositoryDetailPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='repository-container-header']/div[1]/div[1]/div[1]/strong/a"))
        );
    }
}
