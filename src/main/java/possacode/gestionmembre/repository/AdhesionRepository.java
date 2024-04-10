package possacode.gestionmembre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import possacode.gestionmembre.entity.Adhesion;

public interface AdhesionRepository extends JpaRepository<Adhesion, Integer> {
}
