public class Movie {

    private static final int CHILDRENS = 2;
    private static final int REGULAR = 0;
    private static final int NEW_RELEASE = 1;

    private final String title;
    private Price price;

    public Movie(String newtitle, int priceCode) {
        title = newtitle;
        setPriceCode(priceCode);
    }

    private void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints() {
        return price.getFrequentRenterPoints();

    }


}