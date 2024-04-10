package possacode.gestionmembre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import possacode.gestionmembre.entity.Cotisation;

public interface CotisationRepository extends JpaRepository<Cotisation, Integer> {
}
