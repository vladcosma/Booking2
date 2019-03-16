package Service;

import Domain.Booking;
import Domain.RoomAverageRating;
import Repository.BookingRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingService {

    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    /**
     *
     * @param id
     * @param numberOfPersons
     * @param roomNumber
     * @param numberOfDays
     */
    public void checkIn(int id, int numberOfPersons, int roomNumber, int numberOfDays) {
        Booking booking = new Booking(id, numberOfPersons, roomNumber, numberOfDays);
        List<Booking> bookings = bookingRepository.getAll();
        for (Booking b : bookings) {
            if (b.getRoomNumber() == roomNumber && !b.isAvailableRoom()) {
                throw new RuntimeException("This room is not available!");
            }
        }
        bookingRepository.add(booking);
    }

    /**
     *
     * @param roomNumber
     * @param feedBack
     * @param rating
     */
    public void checkOut(int roomNumber, String feedBack, int rating) {
        Booking booking = null;
        List<Booking> bookings = bookingRepository.getAll();
        for (Booking b : bookings) {
            if (b.getRoomNumber() == roomNumber && !b.isAvailableRoom()) {
                booking = b;
            }
        }
        if (booking != null) {
            booking.setAvailableRoom(true);
            booking.setFeedBack(feedBack);
            booking.setRating(rating);
            bookingRepository.update(booking);
        } else {
            throw new RuntimeException("Room is not occupied!");
        }
    }

    /**
     *
     * @return list of bookings
     */
    public List<Booking> getAll() {
        return bookingRepository.getAll();
    }

    /**
     *
     * @return list of average ratings for rooms
     */
    public List<RoomAverageRating> getRoomsAverageRating() {
        List<RoomAverageRating> results = new ArrayList<>();
        Map<Integer, List<Integer>> ratingForRooms = new HashMap<>();
        for (Booking b : bookingRepository.getAll()) {
            if (b.isAvailableRoom()) {
                int roomNumber = b.getRoomNumber();
                int rating = b.getRating();
                if (!ratingForRooms.containsKey(roomNumber)) {
                    ratingForRooms.put(roomNumber, new ArrayList<>());
                }
                ratingForRooms.get(roomNumber).add(rating);
            }
        }
        for (int roomNumber : ratingForRooms.keySet()) {
            List<Integer> ratings = ratingForRooms.get(roomNumber);
            double average = 0;
            for (double r : ratings) {
                average += r;
            }
            average /= ratings.size();
            results.add(new RoomAverageRating(roomNumber, average));
        }
        results.sort((r1, r2) -> Double.compare(r2.getAverageRating(), r1.getAverageRating()));
        return results;
    }
}