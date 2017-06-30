package pages_test.tests;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages_test.model.Customer;

import static org.junit.Assert.assertTrue;

//this test for lite cart version 2.0

@RunWith(DataProviderRunner.class)
public class CustomerRegistrationTests extends TestBase {

    Integer oldQtty,newQtty;
    @Test
    @UseDataProvider(value = "validCustomers", location = DataProviders.class)
    public void canRegisterCustomer(Customer customer) {

        oldQtty = app.getCustomerQtty();
        app.registerNewCustomer(customer);
        newQtty = app.getCustomerQtty();

        assertTrue(newQtty == oldQtty + 1);
    }

}
