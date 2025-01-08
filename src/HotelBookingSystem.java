import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

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

    public void setRoomNumber(String roomNumber) {
        if (roomNumber != null && !roomNumber.isEmpty()) {
            this.roomNumber = roomNumber;
        } else {
            System.out.println("Invalid room number!");
        }
    }

    public void setRoomType(String roomType) {
        if (roomType != null && !roomType.isEmpty()) {
            this.roomType = roomType;
        } else {
            System.out.println("Invalid room type!");
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomType='" + roomType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Room room = (Room) obj;
        return Objects.equals(roomNumber, room.roomNumber) &&
                Objects.equals(roomType, room.roomType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, roomType);
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

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid guest name!");
        }
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Guest guest = (Guest) obj;
        return Objects.equals(name, guest.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Booking {
    private Room room;
    private Guest guest;

    public Booking(Room room, Guest guest) {
        this.room = room;
        this.guest = guest;
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
                '}';
    }
}

class HotelBookingSystem {
    private List<Room> rooms = new ArrayList<>();
    private List<Guest> guests = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public void createBooking(Room room, Guest guest) {
        bookings.add(new Booking(room, guest));
    }

    public List<Room> filterRoomsByType(String roomType) {
        List<Room> filteredRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getRoomType().equalsIgnoreCase(roomType)) {
                filteredRooms.add(room);
            }
        }
        return filteredRooms;
    }

    public Booking searchBookingByGuestName(String guestName) {
        for (Booking booking : bookings) {
            if (booking.getGuest().getName().equalsIgnoreCase(guestName)) {
                return booking;
            }
        }
        return null;
    }

    public void sortRoomsByNumber() {
        rooms.sort(Comparator.comparing(Room::getRoomNumber));
    }

    public void displayAllBookings() {
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public static void main(String[] args) {
        HotelBookingSystem system = new HotelBookingSystem();

        system.addRoom(new Room("101", "Deluxe"));
        system.addRoom(new Room("102", "Standard"));
        system.addRoom(new Room("103", "Suite"));
        system.addGuest(new Guest("Alice"));
        system.addGuest(new Guest("Bob"));

        Room room1 = system.filterRoomsByType("Deluxe").get(0);
        Guest guest1 = system.guests.get(0);
        system.createBooking(room1, guest1);

        system.displayAllBookings();

        Booking searchedBooking = system.searchBookingByGuestName("Alice");
        System.out.println("Searched Booking: " + searchedBooking);

        system.sortRoomsByNumber();
        System.out.println("Sorted Rooms: " + system.rooms);
    }
}
