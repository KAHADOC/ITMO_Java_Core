package JPA_App;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "TRIPS")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "boat_id", referencedColumnName = "id", nullable = false),
            @JoinColumn(name = "boat_name", referencedColumnName = "name", nullable = false)
    })
    private Vessel boat;
    @Column(nullable = false)
    private LocalDate departure;
    @Column(nullable = false)
    private LocalDate arrival;

}
