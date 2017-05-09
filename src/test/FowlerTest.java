package test;

import main.Customer;
import main.Movie;
import main.Rental;
import org.junit.Assert;
import org.junit.Test;

public class FowlerTest {

    @Test
    public void test(){
        Movie movieHdR = new Movie("Matrix", 0);
        Movie movieBB = new Movie("Child", 2);

        Customer customer = new Customer("Patrick Treyer");
        customer.addRental(new Rental(movieHdR, 5));
        customer.addRental(new Rental(movieBB, 2));

        String statement = customer.statement();
        System.out.println(statement);

        Assert.assertNotNull(statement);
    }

}
