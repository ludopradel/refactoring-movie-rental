public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        this._movie = movie;
        this._daysRented = daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public double getCharge() {
        double result = 0;
        switch (_movie.getPriceCode()) {
            case Movie.REGULAR :
                result += 2;
                if (_daysRented > 2)
                    result += (_daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += _daysRented * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (_daysRented > 3)
                    result += (_daysRented - 3) * 1.5;
                break;
        }
        return result;
    }

    public int getFrequentRenterPoints() {
        if ((_movie.getPriceCode() == Movie.NEW_RELEASE) && _daysRented > 1)
            return 2;
        return 1;
    }
}
