package  com.demo.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
//@Table(name="CONSULTATION")
public class consultation{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_rdv;
    private String description;
    private String traitement;
    private Boolean type=false;
}
