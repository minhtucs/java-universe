package juniverse.design.procedural;

/**
 * Represent a rental record
 *      which movie is rented?
 *      how long this rental last?
 * 
 * @author tunm2
 */
public class RentalRecord {
    
    public Movie movie;
    public int daysRented;

    public RentalRecord(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }
    
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }
    
    
}
