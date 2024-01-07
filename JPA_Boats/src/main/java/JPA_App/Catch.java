package JPA_App;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table
public class Catch extends AbstractThingie{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trip_id", referencedColumnName = "id", nullable = false)
    private Trip trip;
    private int weight = 0;
}
