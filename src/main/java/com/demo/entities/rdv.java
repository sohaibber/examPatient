package  com.demo.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
//@Table(name="RENDEZVS")
public class rdv {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean annule=false;
    private String med_nom;
    private Long patient_id;
}
