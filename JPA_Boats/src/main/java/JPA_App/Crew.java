package JPA_App;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Objects;

// @Data  - NOT using Lombok here, want to do one class manually!
@Entity
@Table
// @NoArgsConstructor
public class Crew extends AbstractThingie{

    @Column(nullable = false)
    private String address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trip_id", referencedColumnName = "id", nullable = false)
    private Trip trip;
    private String position;

    public Crew() {
        super();
    }

    public Crew(String name, String address, Trip trip, String position) {
        super(name);
        this.address = address;
        this.trip = trip;
        this.position = position;
    }
    public Crew(String name, String address, Trip trip) {
        super(name);
        this.address = address;
        this.trip = trip;
        this.position = null;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Crew crew)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getAddress(), crew.getAddress()) && Objects.equals(getTrip(), crew.getTrip()) && Objects.equals(getPosition(), crew.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAddress(), getTrip(), getPosition());
    }

    @Override
    public String toString() {
        return "Crew{" +
                "name=" + super.getName() + '\'' +
                ", address='" + address + '\'' +
                ", trip=" + trip +
                ", position='" + position + '\'' +
                '}';
    }
}
