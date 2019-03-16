package Domain;

public class RoomAverageRating {

    private int roomNumber;

    private double averageRating;

    /**
     *
     * @param roomNumber
     * @param averageRating
     */
    public RoomAverageRating(int roomNumber, double averageRating) {
        this.roomNumber = roomNumber;
        this.averageRating = averageRating;
    }

    public double getAverageRating() {
        return averageRating;
    }

    @Override
    public String toString() {
        return "RoomAverageRating: " + "\n" +
                "roomNumber: " + roomNumber + "\n" +
                "averageRating: " + averageRating + "\n";
    }
}