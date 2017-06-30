package pages_test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends Page {

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open(String baseUrl) {
        driver.get(baseUrl + "/en/create_account");
    }

    @FindBy(name = "firstname")
    public WebElement firstnameInput;

    @FindBy(name = "lastname")
    public WebElement lastnameInput;

    @FindBy(name = "address1")
    public WebElement address1Input;

    @FindBy(name = "postcode")
    public WebElement postcodeInput;

    @FindBy(name = "city")
    public WebElement cityInput;

    @FindBy(css = "div#box-create-account [name=email]")
    public WebElement emailInput;

    @FindBy(name = "phone")
    public WebElement phoneInput;

    @FindBy(css = "div#box-create-account [name=password]")
    public WebElement passwordInput;

    @FindBy(name = "confirmed_password")
    public WebElement confirmedPasswordInput;

    @FindBy(name = "create_account")
    public WebElement createAccountButton;

    @FindBy(partialLinkText = "Logout")
    public WebElement logoutButton;

    public void selectCountry(String country) {
        wait.until((WebDriver d) -> d.findElement(
                By.cssSelector(String.format("select[name=country_code] option[value=%s]", country))));
        new Select(driver.findElement(By.cssSelector("select[name=country_code]"))).selectByValue(country);
    }

    public void selectZone(String zone) {
        wait.until((WebDriver d) -> d.findElement(
                By.cssSelector(String.format("select[name=zone_code] option[value=%s]", zone))));
        new Select(driver.findElement(By.cssSelector("select[name=zone_code]"))).selectByValue(zone);
    }

    public void doLogout() {
        logoutButton.click();
    }
}
