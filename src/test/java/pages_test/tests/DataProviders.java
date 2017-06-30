package pages_test.tests;

import com.tngtech.java.junit.dataprovider.DataProvider;
import pages_test.model.Customer;


public class DataProviders {

    @DataProvider
    public static Object[][] validCustomers() {
        return new Object[][]{
                {Customer.newEntity()
                        .withFirstname("Jack").withLastname("Sparrow").withPhone("+1922883772211")
                        .withAddress("5th Street 15").withPostcode("11111").withCity("New York")
                        .withCountry("US").withZone("NY")
                        .withEmail("jack" + System.currentTimeMillis() + "@gmail.com")
                        .withPassword("******").build()},
                {Customer.newEntity()
                        .withFirstname("Jack22").withLastname("Sparrow22").withPhone("+1922883772211")
                        .withAddress("5th Street 15").withPostcode("11111").withCity("New York")
                        .withCountry("US").withZone("NY")
                        .withEmail("jack" + (System.currentTimeMillis()+1) + "@gmail.com")
                        .withPassword("******").build()},
                {Customer.newEntity()
                        .withFirstname("Jac232k").withLastname("Spa234rrow").withPhone("+1922883772211")
                        .withAddress("5th Street 15").withPostcode("11111").withCity("New York")
                        .withCountry("US").withZone("NY")
                        .withEmail("jack" + (System.currentTimeMillis()+2) + "@gmail.com")
                        .withPassword("******").build()
                }
                /* ... */
        };
    }

}
