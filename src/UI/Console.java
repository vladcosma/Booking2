package UI;

import Domain.Booking;
import Domain.RoomAverageRating;
import Service.BookingService;

import java.util.Scanner;

public class Console {

    private BookingService bookingService;

    private Scanner scanner;

    public Console(BookingService bookingService) {
        this.bookingService = bookingService;
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean flag = true;
        while (flag) {
            showMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleCheckIn();
                    break;
                case "2":
                    handleCheckOut();
                    break;
                case "3":
                    handleRoomRating();
                    break;
                case "4":
                    handleShowAll();
                    break;
                case "0":
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void showMenu() {
        System.out.println("1. Check-In");
        System.out.println("2. Check-Out");
        System.out.println("3. Room Average Rating");
        System.out.println("4. All bookings");
        System.out.println("0. Exit");
    }

    private void handleCheckIn() {
        try {
            System.out.println("Enter the id: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the number of persons: ");
            int numberOfPersons = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the room: ");
            int roomNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the number of days: ");
            int numberOfDays = Integer.parseInt(scanner.nextLine());
            bookingService.checkIn(id, numberOfPersons, roomNumber, numberOfDays);
        } catch (RuntimeException runtimeException) {
            System.out.println("ERRORS: " + runtimeException.getMessage());
        }
    }

    private void handleCheckOut() {
        try {
            System.out.println("Enter room: ");
            int roomNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Please, give us a feedback: ");
            String feedBack = scanner.nextLine();
            System.out.println("Please, enter the rating: ");
            int rating = Integer.parseInt(scanner.nextLine());
            bookingService.checkOut(roomNumber, feedBack, rating);
        } catch (RuntimeException runtimeException) {
            System.out.println("ERRORS: " + runtimeException.getMessage());
        }
    }

    private void handleShowAll() {
        for (Booking b : bookingService.getAll())
            System.out.println(b);
    }

    private void handleRoomRating() {
        for (RoomAverageRating roomAverageRating : bookingService.getRoomsAverageRating())
            System.out.println(roomAverageRating);
    }
}