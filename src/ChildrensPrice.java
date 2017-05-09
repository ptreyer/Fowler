/**
 * Created with IntelliJ IDEA.
 * User: Berkling
 * Date: 14.05.14
 * Time: 12:48
 * To change this template use File | Settings | File Templates.
 */
public class ChildrensPrice implements Price {

    public double getCharge(int daysRented) {
        if (daysRented > 3){
            return (daysRented - 3) * 1.5;
        }
        return 1.5;
    }

    public int getFrequentRenterPoints() {
        return 1;
    }

}

