package Repository;

import Domain.Booking;
import Domain.BookingValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingRepository {

    private Map<Integer, Booking> repo = new HashMap<>();

    private BookingValidator bookingValidator;

    public BookingRepository(BookingValidator bookingValidator) {
        this.bookingValidator = bookingValidator;
    }

    /**
     *
     * @param booking to add
     */
    public void add(Booking booking) {
        if (repo.containsKey(booking.getId())) {
            throw new RuntimeException("This Booking ID already exists!");
        }
        bookingValidator.validate(booking);
        repo.put(booking.getId(), booking);
    }

    /**
     *
     * @param booking to update
     */
    public void update(Booking booking) {
        if (!repo.containsKey(booking.getId())) {
            throw new RuntimeException("There is no Booking with this ID!");
        }
        bookingValidator.validate(booking);
        repo.put(booking.getId(), booking);
    }

    /**
     *
     * @param booking to delete
     */
    public void delete(Booking booking) {
        if (!repo.containsKey(booking.getId())) {
            throw new RuntimeException("There is no Booking with this ID!");
        }
        repo.remove(booking.getId());
    }

    /**
     *
     * @return list of bookings
     */
    public List<Booking> getAll() {
        return new ArrayList<>(repo.values());
    }
}