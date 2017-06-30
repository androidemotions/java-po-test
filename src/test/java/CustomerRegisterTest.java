import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

//this test for lite cart version 1.7

public class CustomerRegisterTest {

    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void setup() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 4);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }


    @Test
    public void testAddNewCustomer() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.get("http://localhost/litecart/admin/?app=customers&doc=customers");
        //driver.findElement(By.cssSelector("a.button>i.fa.fa-plus-circle")).click();


        wait.until(presenceOfElementLocated(By.cssSelector("tr.footer td")));

        String initial_number =  driver.findElement(By.cssSelector("tr.footer td")).getText().split(": ")[1];

        System.out.println(initial_number);

        driver.get("http://localhost/litecart/en/create_account");

        driver.findElement(By.name("firstname")).sendKeys("Jack");
        driver.findElement(By.name("lastname")).sendKeys("Sparrow");
        driver.findElement(By.name("address1")).sendKeys("5th Street 15");
        driver.findElement(By.name("postcode")).sendKeys("11111");
        driver.findElement(By.name("city")).sendKeys("New York");
        driver.findElement(By.name("email")).sendKeys("jack"+System.currentTimeMillis()+"@gmail.com");
        driver.findElement(By.name("phone")).sendKeys("+1922883772211");

        driver.findElement(By.cssSelector("[id ^= select2-country_code]")).click();
        driver.findElement(By.cssSelector(".select2-results__option[id $= US]")).click();

        wait.until(driver -> driver.findElement(By.cssSelector("select[name=zone_code] option[value=NY]")));
        new Select(driver.findElement(By.cssSelector("select[name=zone_code]"))).selectByValue("NY");

        driver.findElement(By.name("password")).sendKeys("******");
        driver.findElement(By.name("confirmed_password")).sendKeys("******");
        driver.findElement(By.name("create_account")).click();

        driver.get("http://localhost/litecart/admin/?app=customers&doc=customers");

        wait.until(presenceOfElementLocated(By.cssSelector("tr.footer td")));
        String final_number = driver.findElement(By.cssSelector("tr.footer td")).getText().split(": ")[1];

        System.out.println(final_number);

        Assert.assertTrue( Integer.parseInt(final_number) - Integer.parseInt(initial_number) == 1);

    }


    @After
    public void finish() {
        driver.quit();
    }
}
