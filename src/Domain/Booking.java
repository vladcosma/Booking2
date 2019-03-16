package Domain;

public class Booking {

    private int id;

    private int numberOfPersons;

    private int roomNumber;

    private int numberOfDays;

    private String feedBack;

    private int rating;

    private boolean availableRoom;

    public Booking(int id, int numberOfPersons, int roomNumber, int numberOfDays) {
        this.id = id;
        this.numberOfPersons = numberOfPersons;
        this.roomNumber = roomNumber;
        this.numberOfDays = numberOfDays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isAvailableRoom() {
        return availableRoom;
    }

    public void setAvailableRoom(boolean availableRoom) {
        this.availableRoom = availableRoom;
    }

    @Override
    public String toString() {
        return "Booking: \n" +
                "id: " + id +
                ", numberOfPersons: " + numberOfPersons +
                ", roomNumber: " + roomNumber +
                ", numberOfDays: " + numberOfDays +
                ", feedBack: " + feedBack +
                ", rating: " + rating + " stars \n";
    }
}