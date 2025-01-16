import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Room {
    private String roomNumber;
    private String roomType;

    public Room(String roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        return roomNumber + " (" + roomType + ")";
    }
}

class Guest {
    private String name;

    public Guest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Booking {
    Room room;
    Guest guest;

    public Booking(Room room, Guest guest) {
        this.room = room;
        this.guest = guest;
    }

    @Override
    public String toString() {
        return room + " -> " + guest;
    }
}

class HotelBookingSystem {
    private List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void createBooking(Room room, Guest guest) {
        bookings.add(new Booking(room, guest));
    }

    public List<Room> filterRoomsByType(String roomType) {
        return rooms.stream()
                .filter(room -> room.getRoomType().equalsIgnoreCase(roomType))
                .toList();
    }

    public Booking searchBookingByGuestName(String guestName) {
        return bookings.stream()
                .filter(booking -> booking.guest.toString().equalsIgnoreCase(guestName))
                .findFirst()
                .orElse(null);
    }

    public void sortRoomsByNumber() {
        rooms.sort(Comparator.comparing(Room::getRoomNumber));
    }

    public void displayAllBookings() {
        bookings.forEach(System.out::println);
    }

    public static void main(String[] args) {
        HotelBookingSystem system = new HotelBookingSystem();

        system.addRoom(new Room("101", "Deluxe"));
        system.addRoom(new Room("102", "Standard"));
        system.addRoom(new Room("103", "Suite"));

        Room room1 = system.filterRoomsByType("Deluxe").get(0);
        Guest guest1 = new Guest("Alice");
        system.createBooking(room1, guest1);

        system.displayAllBookings();

        Booking searchedBooking = system.searchBookingByGuestName("Alice");
        System.out.println("Searched Booking: " + searchedBooking);

        system.sortRoomsByNumber();
        System.out.println("Sorted Rooms: " + system.rooms);
    }
}
