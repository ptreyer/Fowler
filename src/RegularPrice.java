/**
 * Created with IntelliJ IDEA.
 * User: Berkling
 * Date: 14.05.14
 * Time: 12:49
 * To change this template use File | Settings | File Templates.
 */
public class RegularPrice implements Price {

    public double getCharge(int daysRented){
        if (daysRented > 2) return (daysRented - 2 ) * 1.5;
        else return 2;
    }
    public int getFrequentRenterPoints() {
        return 1;
    }

}


