package pages_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CustomerListPage extends Page {

    @FindBy(css = "tfoot>tr>td")
    private WebElement footer;


    public CustomerListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CustomerListPage open(String baseUrl) {
        driver.get(baseUrl+"/admin/?app=customers&doc=customers");
        return this;
    }



    public Integer getCustomerQtty() {
         return Integer.parseInt(this.footer.getText().split(": ")[1]);
    }
}
