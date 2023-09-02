package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerPages {
    WebDriver driver;

    public registerPages(WebDriver driver) {
        this.driver = driver;
    }

    //    Locator
    By firstnameField = By.id("customer.firstName");
    By lastnameField = By.name("customer.lastName");
    By streetField = By.id("customer.address.street");
    By cityField = By.id("customer.address.city");
    By stateField = By.id("customer.address.state");
    By zipCodeField = By.id("customer.address.zipCode");
    By phoneNumberField = By.id("customer.phoneNumber");
    By ssnField = By.id("customer.ssn");


    //    Method cick register button
    public void inputNameData(String firstname, String lastname){
        driver.findElement(firstnameField).sendKeys(firstname);
        driver.findElement(lastnameField).sendKeys(lastname);
    }

    public void inputAddressDetail(String street, String city, String state, String zipCode, String phoneNumber, String ssn){
        driver.findElement(streetField).sendKeys(street);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(zipCodeField).sendKeys(zipCode);
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        driver.findElement(ssnField).sendKeys(ssn);
    }
}
