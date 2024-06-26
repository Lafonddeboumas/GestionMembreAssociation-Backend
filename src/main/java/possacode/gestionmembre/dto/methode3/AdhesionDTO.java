package possacode.gestionmembre.dto.methode3;

import lombok.*;
import org.springframework.beans.BeanUtils;
import possacode.gestionmembre.entity.Adhesion;
import possacode.gestionmembre.enumforentity.StatutAdhesion;
import possacode.gestionmembre.enumforentity.TypeAdhesion;

import java.util.Date;

@Getter
@Setter
public class AdhesionDTO {

    private TypeAdhesion typeAdhesion;
    private double tarif;
    private StatutAdhesion statutAdhesion;
    private MembreDTO membreDTO;

        /*
        Ceci est la troisième méthode d'utilisation du Pattern DTO
        en utilisant cette fois ci la classe BeanUtils avec sa méthode
        copyProperties  fournis par SPRING
     */

    public static AdhesionDTO fromAdhesion(Adhesion adhesion){
       AdhesionDTO adhesionDTO = new AdhesionDTO();
        BeanUtils.copyProperties(adhesion, adhesionDTO);
        adhesionDTO.setMembreDTO(MembreDTO.fromMembre(adhesion.getMembre()));
        return adhesionDTO;
    }

    public static Adhesion fromAdhesionDTO(AdhesionDTO adhesionDTO){
        Adhesion adhesion = new Adhesion();
        BeanUtils.copyProperties(adhesionDTO, adhesion);
        adhesion.setMembre(MembreDTO.fromMembreDto(adhesionDTO.getMembreDTO()));
        return adhesion;
    }
}
