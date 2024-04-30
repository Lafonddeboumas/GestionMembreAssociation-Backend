package possacode.gestionmembre.service.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import possacode.gestionmembre.dto.methode1.MembreDTO;
//import possacode.gestionmembre.dto.methode2.MembreDTO;
import possacode.gestionmembre.entity.Membre;
import possacode.gestionmembre.repository.MembreRepository;
import possacode.gestionmembre.service.MembreService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MembreServiceImpl implements MembreService {

    private final MembreRepository membreRepository;

    @Override
    public MembreDTO save(MembreDTO membreDTO) {
        Membre membre = MembreDTO.fromMembreDTO(membreDTO);
        membre.setDateAdhesion(new Date());
        Membre savedMembre =  membreRepository.save(membre);
        return MembreDTO.fromMembre(savedMembre);
    }

    @Override
    public MembreDTO update(MembreDTO membreDTO) {
        Membre membre = MembreDTO.fromMembreDTO(membreDTO);
        Membre savedMembre =  membreRepository.save(membre);
        return MembreDTO.fromMembre(savedMembre);
    }

    @Override
    public MembreDTO findById(Integer id) {
        return membreRepository.findById(id)
                .map(MembreDTO::fromMembre)
                .orElseThrow(()-> new EntityNotFoundException("Pas de membre trouvé avec l'ID"+id));
    }

    @Override
    public List<MembreDTO> findAll() {
        return membreRepository.findAll()
                .stream()
                .map(MembreDTO::fromMembre)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        membreRepository.deleteById(id);
    }
}
