package possacode.gestionmembre.service.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import possacode.gestionmembre.dto.methode2.MembreDTO;
import possacode.gestionmembre.entity.Membre;
import possacode.gestionmembre.repository.MembreRepository;
import possacode.gestionmembre.service.MembreService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MembreServiceImpl implements MembreService {

    private final MembreRepository membreRepository;

    @Override
    public MembreDTO save(MembreDTO membreDTO) {
        Membre membre = MembreDTO.fromMemberDto(membreDTO);
        Membre savedMembre =  membreRepository.save(membre);
        return MembreDTO.fromMember(savedMembre);
    }

    @Override
    public MembreDTO update(MembreDTO membreDTO) {
        Membre membre = MembreDTO.fromMemberDto(membreDTO);
        Membre savedMembre =  membreRepository.save(membre);
        return MembreDTO.fromMember(savedMembre);
    }

    @Override
    public MembreDTO findById(Integer id) {
        return membreRepository.findById(id)
                .map(MembreDTO::fromMember)
                .orElseThrow(()-> new EntityNotFoundException("Pas de membre trouvé avec l'ID"+id));
    }

    @Override
    public List<MembreDTO> findAll() {
        return membreRepository.findAll()
                .stream()
                .map(MembreDTO::fromMember)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        membreRepository.deleteById(id);
    }
}
