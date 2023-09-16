package pages.Github;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class repositoryPage {
    WebDriver driver;

    public repositoryPage(WebDriver driver){
        this.driver = driver;
    }

    By newRepositoryButton = By.xpath("//*[@id='user-profile-frame']/div/div[1]/div/div/a");
    By repositoryNameField = By.xpath("//*[@id='react-aria9763366942-:r2:']");
    By repositoryDescriptionField = By.xpath("//*[@id='react-aria9763366942-:r3:']");
    By repositoryPrivate = By.xpath("//*[@id='react-aria9763366942-:r6:']");
    By repositoryReadme = By.xpath("//*[@id='react-aria9763366942-:r8:']");
    By createRepositoryButton = By.xpath("/html/body/div[1]/div[6]/main/react-app/div/form/div[5]/button");
    By titleRepository = By.xpath("//*[@id='repository-container-header']/div[1]/div[1]/div[1]/strong/a");

    public void clickNewRepositoryButton(){
        driver.findElement(newRepositoryButton).click();
    }

    public void inputRepositoryName(String repository_name, String description){
        driver.findElement(repositoryNameField).sendKeys(repository_name);
        driver.findElement(repositoryDescriptionField).sendKeys(description);
    }

    public void checkRepositoryPrivate(){
        driver.findElement(repositoryPrivate).click();
    }

    public void checkRepositoryReadme(){
        driver.findElement(repositoryReadme).click();
    }

    public void clickCreateRepository(){
        driver.findElement(createRepositoryButton).click();
    }
}