package possacode.gestionmembre.dto.methode2;

import lombok.*;
import possacode.gestionmembre.entity.Adhesion;
import possacode.gestionmembre.entity.Membre;
import possacode.gestionmembre.entity.StatutAdhesion;
import possacode.gestionmembre.entity.TypeAdhesion;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AdhesionDTO {

    private TypeAdhesion typeAdhesion;
    private double tarif;
    private Date dateDebut;
    private Date dateFin;
    private StatutAdhesion statutAdhesion;
    private MembreDTO membreDTO;

    public static AdhesionDTO fromAdhesion(Adhesion adhesion){
        return AdhesionDTO.builder()
                .typeAdhesion(adhesion.getTypeAdhesion())
                .tarif(adhesion.getTarif())
                .dateDebut(adhesion.getDateDebut())
                .dateFin(adhesion.getDateFin())
                .statutAdhesion(adhesion.getStatutAdhesion())
                .membreDTO(MembreDTO.fromMember(adhesion.getMembre()))
                .build();
    }

    public static Adhesion fromAdhesionDTO(AdhesionDTO adhesionDTO){
        return Adhesion.builder()
                .typeAdhesion(adhesionDTO.getTypeAdhesion())
                .tarif(adhesionDTO.getTarif())
                .dateDebut(adhesionDTO.getDateDebut())
                .dateFin(adhesionDTO.getDateFin())
                .statutAdhesion(adhesionDTO.getStatutAdhesion())
                .membre(MembreDTO.fromMemberDto(adhesionDTO.getMembreDTO()))
                .build();
    }
}
