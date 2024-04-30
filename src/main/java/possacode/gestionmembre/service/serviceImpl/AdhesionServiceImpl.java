package possacode.gestionmembre.service.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
//import possacode.gestionmembre.dto.methode2.AdhesionDTO;
import possacode.gestionmembre.dto.methode1.AdhesionDTO;
import possacode.gestionmembre.entity.Adhesion;
import possacode.gestionmembre.repository.AdhesionRepository;
import possacode.gestionmembre.service.AdhesionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdhesionServiceImpl implements AdhesionService {

    private final AdhesionRepository adhesionRepository;

    @Override
    public AdhesionDTO save(AdhesionDTO adhesionDTO) {
        Adhesion adhesion = AdhesionDTO.fromAdhesionDTO(adhesionDTO);
        Adhesion savedAdhesion = adhesionRepository.save(adhesion);
        return AdhesionDTO.fromAdhesion(savedAdhesion);
    }

    @Override
    public AdhesionDTO update(AdhesionDTO adhesionDTO) {
        Adhesion adhesion = AdhesionDTO.fromAdhesionDTO(adhesionDTO);
        Adhesion savedAdhesion = adhesionRepository.save(adhesion);
        return AdhesionDTO.fromAdhesion(savedAdhesion);
    }

    @Override
    public AdhesionDTO findById(Integer id) {
        return adhesionRepository.findById(id)
                .map(AdhesionDTO::fromAdhesion)
                .orElseThrow(()-> new EntityNotFoundException("Pas d'adhesion avec l'id fournit "+id));
    }

    @Override
    public List<AdhesionDTO> findAll() {
        return adhesionRepository.findAll()
                .stream()
                .map(AdhesionDTO::fromAdhesion)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        adhesionRepository.deleteById(id);
    }
}
