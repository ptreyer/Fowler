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

//    It is worth stopping to think a bit about the last refactoring. Most refactorings reduce the amount
//    of code, but this one increases it. That's because Java 1.1 requires a lot of statements to set up a
//    summing loop. Even a simple summing loop with one line of code per element needs six lines of
//    support around it. It's an idiom that is obvious to any programmer but is a lot of lines all the same.
//    The other concern with this refactoring lies in performance. The old code executed the "while"
//    loop once, the new code executes it three times. A while loop that takes a long time might impair
//    performance. Many programmers would not do this refactoring simply for this reason. But note
//    the words if and might. Until I profile I cannot tell how much time is needed for the loop to
//    calculate or whether the loop is called often enough for it to affect the overall performance of the
//    system. Don't worry about this while refactoring. When you optimize you will have to worry about
//    it, but you will then be in a much better position to do something about it, and you will have more
//    options to optimize effectively (see the discussion on page 69).

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
    