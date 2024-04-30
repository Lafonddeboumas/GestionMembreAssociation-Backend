package possacode.gestionmembre.controller.controllerImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import possacode.gestionmembre.controller.AdhesionController;
import possacode.gestionmembre.dto.methode1.AdhesionDTO;
//import possacode.gestionmembre.dto.methode2.AdhesionDTO;
import possacode.gestionmembre.repository.AdhesionRepository;
import possacode.gestionmembre.service.AdhesionService;

import java.util.List;

@RestController
@RequestMapping("/adhesion")
@RequiredArgsConstructor
public class AdhesionControllerImpl implements AdhesionController {

    private final AdhesionService adhesionService;

    @PostMapping("/")
    @Override
    public AdhesionDTO save(@RequestBody AdhesionDTO adhesionDTO) {
        return adhesionService.save(adhesionDTO);
    }

    @GetMapping("/{id}")
    @Override
    public AdhesionDTO findById(@PathVariable(value = "id") Integer id) {
        return adhesionService.findById(id);
    }

    @GetMapping("/")
    @Override
    public List<AdhesionDTO> findAll() {
        return adhesionService.findAll();
    }

    @DeleteMapping("/{id}")
    @Override
    public void deleteById(@PathVariable(value = "id") Integer id) {
      adhesionService.delete(id);
    }
}
