import constants.FowlerConstants;

import java.util.ArrayList;
import java.util.List;

class Customer {

    private final String name;
    private final List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        this.rentals = new ArrayList<>();
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        StringBuilder builder = new StringBuilder();
        builder.append("Rental Record for ");
        builder.append(this.name);
        builder.append(FowlerConstants.NEW_LINE);

        builder.append(FowlerConstants.TAB);
        builder.append("Title");
        builder.append(FowlerConstants.TAB);
        builder.append(FowlerConstants.TAB);
        builder.append("Days");
        builder.append(FowlerConstants.TAB);
        builder.append("Amount");

        for (Rental rental : rentals){
            builder.append(FowlerConstants.NEW_LINE);
            builder.append(FowlerConstants.TAB);
            builder.append(rental.getMovie().getTitle());
            builder.append(FowlerConstants.TAB);
            builder.append(FowlerConstants.TAB);
            builder.append(rental.getDaysRented());
            builder.append(FowlerConstants.TAB);
            builder.append(FowlerConstants.TAB);
            builder.append(Double.toString(rental.getCharge()));
        }
        builder.append(FowlerConstants.NEW_LINE);
        builder.append("Amount owed is: ");
        builder.append(Double.toString(getTotalCharge()));
        builder.append(FowlerConstants.NEW_LINE);
        builder.append("You earned ");
        builder.append(Double.toString(getTotalFrequentRenterPoints()));
        builder.append(" frequent renter points");
        builder.append(FowlerConstants.NEW_LINE);

        return builder.toString();
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental rental: rentals) {
            result = result + rental.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints(){
        int result = 0;
        for (Rental rental: rentals) {
            result = result + rental.getFrequentRenterPoints();
        }
        return result;
    }

}
    