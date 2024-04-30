package possacode.gestionmembre.controller.cotisationImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import possacode.gestionmembre.controller.CotisationController;
import possacode.gestionmembre.dto.methode2.CotisationDTO;
import possacode.gestionmembre.service.CotisationService;

import java.util.List;

@RestController
@RequestMapping("/cotisation")
@RequiredArgsConstructor
public class CotisationControllerImpl implements CotisationController {

    private final CotisationService cotisationService;

    @PostMapping("/")
    @Override
    public CotisationDTO save(@RequestBody CotisationDTO cotisationDTO) {
        return cotisationService.save(cotisationDTO);
    }

    @GetMapping("/{id}")
    @Override
    public CotisationDTO findById(@PathVariable(name = "id") Integer id) {
        return cotisationService.findById(id);
    }

    @GetMapping("/")
    @Override
    public List<CotisationDTO> findAll() {
        return cotisationService.findAll();
    }

    @DeleteMapping("/{id}")
    @Override
    public void deleteById(@PathVariable(name = "id") Integer id) {
        cotisationService.delete(id);
    }
}
