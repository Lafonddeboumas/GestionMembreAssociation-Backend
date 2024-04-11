package possacode.gestionmembre.dto.methode3;

import lombok.*;
import org.springframework.beans.BeanUtils;
import possacode.gestionmembre.entity.Adhesion;
import possacode.gestionmembre.entity.StatutAdhesion;
import possacode.gestionmembre.entity.TypeAdhesion;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdhesionDTO {

    private TypeAdhesion typeAdhesion;
    private double tarif;
    private Date dateDebut;
    private Date dateFin;
    private StatutAdhesion statutAdhesion;

    public static AdhesionDTO fromAdhesion(Adhesion adhesion){
       AdhesionDTO adhesionDTO = new AdhesionDTO();
        BeanUtils.copyProperties(adhesion, adhesionDTO);
        return adhesionDTO;
    }

    public static Adhesion fromAdhesionDTO(AdhesionDTO adhesionDTO){
        return Adhesion.builder()
                .typeAdhesion(adhesionDTO.getTypeAdhesion())
                .tarif(adhesionDTO.getTarif())
                .dateDebut(adhesionDTO.getDateDebut())
                .dateFin(adhesionDTO.getDateFin())
                .statutAdhesion(adhesionDTO.getStatutAdhesion())
                .build();
    }
}
