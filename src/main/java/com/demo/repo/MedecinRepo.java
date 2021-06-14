package  com.demo.repo;

import com.demo.entities.medecin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepo extends JpaRepository<medecin, Long> {
    Page<medecin> findByNomContains(String motCle, Pageable pageable);}
