public abstract class Price {
    abstract int getPriceCode();
    abstract double getCharge(int daysRented);

    public abstract int getFrequentRenterPoints(int daysRented);
}

class ChildrensPrice extends Price {

    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}

class NewReleasePrice extends Price {

    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}

class RegularPrice extends Price {

    int getPriceCode() {
        return Movie.REGULAR;
    }

    double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
