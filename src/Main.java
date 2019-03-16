import Domain.BookingValidator;
import Repository.BookingRepository;
import Service.BookingService;
import UI.Console;

public class Main {

    public static void main(String[] args) {

        BookingValidator bookingValidator = new BookingValidator();
        BookingRepository bookingRepository = new BookingRepository(bookingValidator);
        BookingService bookingService = new BookingService(bookingRepository);
        bookingService.checkIn(1, 2, 205, 5);
        bookingService.checkIn(2, 3, 10, 2);
        bookingService.checkIn(3, 1, 154, 1);
        bookingService.checkIn(4, 2, 80, 3);
        bookingService.checkIn(5, 4, 2, 10);
        bookingService.checkOut(205, "Good", 4);
        bookingService.checkOut(10, "Nice services", 5);
        bookingService.checkOut(154, "Great experience", 5);
        Console console = new Console(bookingService);
        console.run();
    }
}