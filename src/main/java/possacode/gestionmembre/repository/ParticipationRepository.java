package possacode.gestionmembre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import possacode.gestionmembre.entity.Participation;

public interface ParticipationRepository extends JpaRepository<Participation, Integer> {
}
