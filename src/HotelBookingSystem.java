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

    public void display() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
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

    public void display() {
        System.out.println("Guest Name: " + name);
    }
}

class Booking {
    private Room room;
    private Guest guest;

    public Booking(Room room, Guest guest) {
        this.room = room;
        this.guest = guest;
    }

    public void display() {
        System.out.println("=== Booking Details ===");
        guest.display();
        room.display();
    }
}

class HotelBookingSystem {
    public static void main(String[] args) {
        Guest guest = new Guest("Alex");
        Room room = new Room("101", "Deluxe Suite");

        guest.setName("Almat");
        room.setRoomNumber("2422");
        room.setRoomType("Standard Room");
        Booking booking = new Booking(room, guest);
        booking.display();
    }
}