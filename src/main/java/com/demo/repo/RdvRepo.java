package  com.demo.repo;

import com.demo.entities.rdv;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RdvRepo extends JpaRepository<rdv, Long> {
    Page<rdv> findById(Long id, Pageable pageable);
}
