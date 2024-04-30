package possacode.gestionmembre.controller.controllerImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
//import possacode.gestionmembre.dto.methode2.MembreDTO;
import possacode.gestionmembre.dto.methode1.MembreDTO;
import possacode.gestionmembre.service.MembreService;

import java.util.List;

@RestController
@RequestMapping("/gestionmembre/v1/membre")
@RequiredArgsConstructor
public class MembreController {

    private final MembreService membreService;

    @PostMapping("/")
    public MembreDTO save(@RequestBody MembreDTO membreDTO){
        return membreService.save(membreDTO);
    }

    @GetMapping("/")
    public List<MembreDTO> findAll(){
        return membreService.findAll();
    }

    @GetMapping("/{id}")
    public MembreDTO findById(@PathVariable(value = "id") Integer id){
        return membreService.findById(id);
    }
}
