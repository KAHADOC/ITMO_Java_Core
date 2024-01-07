package JPA_App;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "VESSELS")
public class Vessel extends AbstractThingie{
    @Column(unique = true, nullable = false)
    private String certificate;
    @Column(nullable = false)
    private String type;
    private int displacement;
    private LocalDate manufactured;

    public Vessel(int id, String name, String certificate, String type, int tons, String date) {
        super.setId(id);
        super.setName(name);
        this.certificate = certificate;
        this.type = type;
        this.displacement = tons;
        this.manufactured = LocalDate.parse(date);
    }

    @Override
    public String toString() {
        return "Vessel{ "+super.toString()+ '\'' +
                " certificate='" + certificate + '\'' +
                ", type='" + type + '\'' +
                ", displacement=" + displacement +
                ", manufactured=" + manufactured +"} ";
    }
//    @OneToOne(mappedBy = "id", cascade = CascadeType.ALL)
//    @OneToOne(mappedBy = "name")
//    private Trip trip;

}
