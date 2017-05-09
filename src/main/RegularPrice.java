package main;

public class RegularPrice implements Price {

    public double getCharge(int daysRented){
        if (daysRented > 2) return (daysRented - 2 ) * 1.5;
        else return 2;
    }

    public int getFrequentRenterPoints() {
        return 1;
    }

}


