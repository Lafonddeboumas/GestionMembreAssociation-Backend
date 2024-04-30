package possacode.gestionmembre.dto.methode2;

import lombok.*;
import possacode.gestionmembre.entity.Adhesion;
import possacode.gestionmembre.enumforentity.StatutAdhesion;
import possacode.gestionmembre.enumforentity.TypeAdhesion;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AdhesionDTO {

    private TypeAdhesion typeAdhesion;
    private double tarif;
    private StatutAdhesion statutAdhesion;
    private MembreDTO membreDTO;

    /*
        Ceci est la deuxième méthode d'utilisation du Pattern DTO
        en utilisant cette fois ci la méthode builder fournis par
        l'annotation @Builder qui viens de la dépendance lombok
     */

    public static AdhesionDTO fromAdhesion(Adhesion adhesion){
        return AdhesionDTO.builder()
                .typeAdhesion(adhesion.getTypeAdhesion())
                .tarif(adhesion.getTarif())
                .statutAdhesion(adhesion.getStatutAdhesion())
                .membreDTO(MembreDTO.fromMember(adhesion.getMembre()))
                .build();
    }

    public static Adhesion fromAdhesionDTO(AdhesionDTO adhesionDTO){
        return Adhesion.builder()
                .typeAdhesion(adhesionDTO.getTypeAdhesion())
                .tarif(adhesionDTO.getTarif())
                .statutAdhesion(adhesionDTO.getStatutAdhesion())
                .membre(MembreDTO.fromMemberDto(adhesionDTO.getMembreDTO()))
                .build();
    }
}
