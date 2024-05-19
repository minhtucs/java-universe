package juniverse.design.procedural;

import java.util.List;

/**
 *
 * @author tunm2
 */
public class Customer {

    public String name;
    public List<RentalRecord> rentals;

    public Customer(String name, List<RentalRecord> rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RentalRecord> getRentals() {
        return rentals;
    }

    public void setRentals(List<RentalRecord> rentals) {
        this.rentals = rentals;
    }
    
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        
        String result = "Rental Record for " + name + "\n";
        for (RentalRecord rental : rentals) {
            double iAmount = 0;
            
            // calculate amounts for each line
            switch (rental.getMovie().getCode()) {
                case Regular:
                    iAmount += 2;
                    if (rental.getDaysRented() > 2) {
                        iAmount += (rental.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case NewRelease:
                    iAmount += rental.getDaysRented() * 3;
                    break;
                case Children:
                    iAmount += 1.5;
                    if (rental.getDaysRented() > 3) {
                        iAmount += (rental.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }
            
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((rental.getMovie().getCode() == Movie.Code.NewRelease) && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            
            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(iAmount) + "\n";
            totalAmount += iAmount;
        }
        
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        
        return result;
    }

}
