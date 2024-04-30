package possacode.gestionmembre.service.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import possacode.gestionmembre.dto.methode2.CotisationDTO;
import possacode.gestionmembre.entity.Cotisation;
import possacode.gestionmembre.repository.CotisationRepository;
import possacode.gestionmembre.service.CotisationService;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CotisationServiceImpl implements CotisationService {

    private final CotisationRepository cotisationRepository;

    @Override
    public CotisationDTO save(CotisationDTO cotisationDTO) {
        Cotisation cotisation = CotisationDTO.fromCotisationDTO(cotisationDTO);
        Cotisation savedCotisation =   cotisationRepository.save(cotisation);
        return CotisationDTO.fromCotisation(savedCotisation);
    }

    @Override
    public CotisationDTO update(CotisationDTO cotisationDTO) {
        Cotisation cotisation = CotisationDTO.fromCotisationDTO(cotisationDTO);
        Cotisation savedCotisation =   cotisationRepository.save(cotisation);
        return CotisationDTO.fromCotisation(savedCotisation);
    }

    @Override
    public CotisationDTO findById(Integer id) {
        return cotisationRepository.findById(id)
                .map(CotisationDTO::fromCotisation)
                .orElseThrow(()->new EntityNotFoundException("Pas de cotisation trouver avec l'id : "+id));
    }

    @Override
    public List<CotisationDTO> findAll() {
        return cotisationRepository.findAll()
                .stream()
                .map(CotisationDTO::fromCotisation)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        cotisationRepository.deleteById(id);
    }
}
