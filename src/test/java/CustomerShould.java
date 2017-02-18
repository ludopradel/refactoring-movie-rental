import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

import static org.assertj.core.api.Assertions.*;

public class CustomerShould {

    private Customer aCustomer;

    @Before
    public void setUp() {
        aCustomer = new Customer("BILL", new Vector());
    }

    @Test public void
    rent_a_regular_film_for_5_days_for_6_point_5_dollars() {
        aCustomer.addRental(new Rental(new Movie("Back To The Future", Movie.REGULAR), 5));
        assertThat(aCustomer.statement()).isEqualTo("Rental Record for BILL\n" +
                "\tBack To The Future\t6.5\n" +
                "Amount owed is 6.5\n" +
                "You earned 1 frequent renter points");
    }

    @Test public void
    rent_a_children_film_for_5_days_for_15_dollars() {
        aCustomer.addRental(new Rental(new Movie("Toy Story", Movie.CHILDRENS), 5));
        assertThat(aCustomer.statement()).isEqualTo("Rental Record for BILL\n" +
                "\tToy Story\t4.5\n" +
                "Amount owed is 4.5\n" +
                "You earned 1 frequent renter points");
    }

    @Test public void
    rent_a_new_release_film_for_5_days_for_6_point_5_dollars() {
        aCustomer.addRental(new Rental(new Movie("Alien", Movie.NEW_RELEASE), 5));
        assertThat(aCustomer.statement()).isEqualTo("Rental Record for BILL\n" +
                "\tAlien\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 2 frequent renter points");
    }

    @Test public void
    rent_multiple_films() {
        aCustomer.addRental(new Rental(new Movie("Alien", Movie.REGULAR), 5));
        aCustomer.addRental(new Rental(new Movie("Alien 2", Movie.REGULAR), 5));
        aCustomer.addRental(new Rental(new Movie("Alien 3", Movie.NEW_RELEASE), 5));

        assertThat(aCustomer.statement()).isEqualTo("Rental Record for BILL\n" +
                "\tAlien\t6.5\n" +
                "\tAlien 2\t6.5\n" +
                "\tAlien 3\t15.0\n" +
                "Amount owed is 28.0\n" +
                "You earned 4 frequent renter points");
    }

    @Test public void
    change_price_code_of_a_movie() {
        Movie alien = new Movie("Alien", Movie.NEW_RELEASE);
        alien.setPriceCode(Movie.REGULAR);
        aCustomer.addRental(new Rental(alien, 5));
        assertThat(aCustomer.statement()).isEqualTo("Rental Record for BILL\n" +
                "\tAlien\t6.5\n" +
                "Amount owed is 6.5\n" +
                "You earned 1 frequent renter points");
    }





}
