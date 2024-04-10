package possacode.gestionmembre.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import possacode.gestionmembre.dto.methode2.MembreDTO;
import possacode.gestionmembre.entity.Membre;
import possacode.gestionmembre.repository.MembreRepository;
import possacode.gestionmembre.service.MembreService;

import java.util.List;

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
        return null;
    }

    @Override
    public MembreDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<MembreDTO> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
