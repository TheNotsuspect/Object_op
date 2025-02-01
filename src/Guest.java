import java.util.Objects;

public class Guest extends Person {
    public Guest(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
    }

    @Override
    public void display() {
        System.out.println("Guest: " + getName() + ", Email: " + getEmail() + ", Phone: " + getPhoneNumber());
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return Objects.equals(getName(), guest.getName()) &&
                Objects.equals(getEmail(), guest.getEmail()) &&
                Objects.equals(getPhoneNumber(), guest.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getEmail(), getPhoneNumber());
    }
}