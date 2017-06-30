package pages_test.app;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages_test.model.Customer;
import pages_test.pages.AdminPanelLoginPage;
import pages_test.pages.CustomerListPage;
import pages_test.pages.RegistrationPage;


public class Application {

    private WebDriver driver;

    private RegistrationPage registrationPage;
    private AdminPanelLoginPage adminPanelLoginPage;
    private CustomerListPage customerListPage;

    private String baseUrl = "http://localhost/litecart2";

    public Application() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        registrationPage = new RegistrationPage(driver);
        adminPanelLoginPage = new AdminPanelLoginPage(driver);
        customerListPage = new CustomerListPage(driver);
    }


    public void quit() {
        driver.quit();
    }

    public void registerNewCustomer(Customer customer) {
        registrationPage.open(baseUrl);
        registrationPage.firstnameInput.sendKeys(customer.getFirstname());
        registrationPage.lastnameInput.sendKeys(customer.getLastname());
        registrationPage.address1Input.sendKeys(customer.getAddress());
        registrationPage.postcodeInput.sendKeys(customer.getPostcode());
        registrationPage.cityInput.sendKeys(customer.getCity());
        registrationPage.selectCountry(customer.getCountry());
        registrationPage.selectZone(customer.getZone());
        registrationPage.emailInput.sendKeys(customer.getEmail());
        registrationPage.phoneInput.sendKeys(customer.getPhone());
        registrationPage.passwordInput.sendKeys(customer.getPassword());
        registrationPage.confirmedPasswordInput.sendKeys(customer.getPassword());
        registrationPage.createAccountButton.click();
        registrationPage.doLogout();

    }

    public Integer getCustomerQtty() {
        if (adminPanelLoginPage.open(baseUrl).isOnThisPage()) {
            adminPanelLoginPage.enterUsername("admin").enterPassword("admin").submitLogin();
        }

        return customerListPage.open(baseUrl).getCustomerQtty();
    }

}
