package  com.demo.repo;

import com.demo.entities.consultation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultRepo extends JpaRepository<consultation, Long> {
    Page<consultation> findById(Long id, Pageable pageable);}
