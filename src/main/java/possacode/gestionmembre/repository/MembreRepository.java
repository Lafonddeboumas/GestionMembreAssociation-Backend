package possacode.gestionmembre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import possacode.gestionmembre.entity.Membre;

public interface MembreRepository extends JpaRepository<Membre, Integer> {
}
