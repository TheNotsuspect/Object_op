import java.util.Objects;

public class Room {
    private String type;
    private int roomNumber;
    private double pricePerNight;

    public Room(String type, int roomNumber, double pricePerNight) {
        this.type = type;
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void display() {
        System.out.println("Room Type: " + type + ", Room Number: " + roomNumber + ", Price per Night: $" + pricePerNight);
    }

    @Override
    public String toString() {
        return "Room{" +
                "type='" + type + '\'' +
                ", roomNumber=" + roomNumber +
                ", pricePerNight=" + pricePerNight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNumber == room.roomNumber &&
                Double.compare(room.pricePerNight, pricePerNight) == 0 &&
                Objects.equals(type, room.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, roomNumber, pricePerNight);
    }
}