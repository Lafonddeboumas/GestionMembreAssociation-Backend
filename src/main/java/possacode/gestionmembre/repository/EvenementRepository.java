package possacode.gestionmembre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import possacode.gestionmembre.entity.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {
}
