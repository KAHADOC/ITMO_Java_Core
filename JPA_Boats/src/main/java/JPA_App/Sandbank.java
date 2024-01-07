package JPA_App;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SANDBANKS")
public class Sandbank extends AbstractThingie{
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trip_id", referencedColumnName = "id", nullable = false)
    private Trip trip;
    @Column(nullable = false)
    private LocalDate arrival;
    @Column(nullable = false)
    private LocalDate departure;
    private String quality;
}
