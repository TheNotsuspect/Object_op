import java.util.Objects;

public class Booking {
    private Room room;
    private Guest guest;
    private int numberOfNights;

    public Booking(Room room, Guest guest, int numberOfNights) {
        this.room = room;
        this.guest = guest;
        this.numberOfNights = numberOfNights;
    }

    public double calculateTotalCost() {
        return room.getPricePerNight() * numberOfNights;
    }

    public void display() {
        System.out.println("--- Booking Details ---");
        guest.display();
        room.display();
        System.out.println("Number of Nights: " + numberOfNights);
        System.out.println("Total Cost: $" + calculateTotalCost());
    }

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "room=" + room +
                ", guest=" + guest +
                ", numberOfNights=" + numberOfNights +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return numberOfNights == booking.numberOfNights &&
                Objects.equals(room, booking.room) &&
                Objects.equals(guest, booking.guest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, guest, numberOfNights);
    }
}