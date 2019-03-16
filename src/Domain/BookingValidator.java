package Domain;

public class BookingValidator {

    /**
     *
     * @param booking to validate
     * @throws RuntimeException if there are validation errors
     */
    public void validate(Booking booking) {
        if (booking.getNumberOfDays() <= 0) {
            throw new RuntimeException("The number of days must be positive!");
        }
        if (booking.getRating() < 1 && booking.getRating() > 5) {
            throw new RuntimeException("We accept rating only between 1 and 5 stars!");
        }
    }
}