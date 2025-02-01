import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class HotelBookingSystem {
    public static void main(String[] args) {
        Room singleRoom = new Room("Single", 101, 100.0);
        Room doubleRoom = new Room("Double", 102, 150.0);
        Room suiteRoom = new Room("Suite", 103, 250.0);
        Guest guest1 = new Guest("Аслан", "aslan@example.com", "+77001234567");
        Guest guest2 = new Guest("Айгерім", "aigerim@example.com", "+77007654321");
        Guest guest3 = new Guest("Нурлан", "nurlan@example.com", "+77008889999");
        Booking booking1 = new Booking(singleRoom, guest1, 3); // 3 nights
        Booking booking2 = new Booking(doubleRoom, guest2, 5); // 5 nights
        Booking booking3 = new Booking(suiteRoom, guest3, 2); // 2 nights
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking1);
        bookings.add(booking2);
        bookings.add(booking3);
        System.out.println("All Bookings:");
        bookings.forEach(Booking::display);
        System.out.println();
        String filterType = "Double";
        List<Booking> filteredBookings = bookings.stream()
                .filter(booking -> booking.getRoom().getType().equals(filterType))
                .collect(Collectors.toList());

        System.out.println("Filtered Bookings (Room Type: " + filterType + "):");
        filteredBookings.forEach(Booking::display);
        System.out.println();

        Collections.sort(bookings, Comparator.comparingDouble(Booking::calculateTotalCost));

        System.out.println("Sorted Bookings (by Total Cost):");
        bookings.forEach(Booking::display);
        System.out.println();

        String searchGuestName = "Айгерім";
        Booking foundBooking = bookings.stream()
                .filter(booking -> booking.getGuest().getName().equals(searchGuestName))
                .findFirst()
                .orElse(null);

        if (foundBooking != null) {
            System.out.println("Found Booking for Guest: " + searchGuestName);
            foundBooking.display();
        } else {
            System.out.println("No booking found for guest: " + searchGuestName);
        }
        System.out.println();

        System.out.println("Comparing Booking 1 and Booking 2:");
        System.out.println("Are they equal? " + booking1.equals(booking2));
        System.out.println("HashCode of Booking 1: " + booking1.hashCode());
        System.out.println("HashCode of Booking 2: " + booking2.hashCode());
    }
}