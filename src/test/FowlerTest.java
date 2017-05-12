package test;

import main.Customer;
import main.Movie;
import main.Rental;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FowlerTest {

    Movie movie1;
    Movie movie2;
    Customer customer;

    @Before
    public void setup() {
        movie1 = new Movie("Matrix", 0);
        movie2 = new Movie("Lab", 2);

        customer = new Customer("Patrick Treyer");
        customer.addRental(new Rental(movie1, 5));
        customer.addRental(new Rental(movie2, 2));
    }

    @Test
    public void testCharge(){
       Assert.assertEquals(1.5, movie2.getCharge(2),0);
    }

    @Test
    public void testFrequentRenterPoints(){
        Assert.assertEquals(1, movie1.getFrequentRenterPoints());
    }

    @Test
    public void testTitle(){
        Assert.assertEquals( "Lab", movie2.getTitle());
    }

    @Test
    public void testMovieEquals(){
        Assert.assertFalse(movie1.equals(movie2));
    }

    @Test
    public void testCstomerEquals(){
        Assert.assertFalse(customer.equals(new Customer("Patrick Treyer")));
    }

    @Test
    public void testStatement() {
        String statement = customer.statement();
        Assert.assertNotNull(statement);
    }

}
