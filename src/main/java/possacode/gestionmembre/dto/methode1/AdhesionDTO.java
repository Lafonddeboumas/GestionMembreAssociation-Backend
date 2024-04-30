package possacode.gestionmembre.dto.methode1;


import lombok.*;
import possacode.gestionmembre.dto.methode1.MembreDTO;
import possacode.gestionmembre.entity.Adhesion;
import possacode.gestionmembre.enumforentity.StatutAdhesion;
import possacode.gestionmembre.enumforentity.TypeAdhesion;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdhesionDTO {

    private TypeAdhesion typeAdhesion;
    private double tarif;
    private StatutAdhesion statutAdhesion;
    private MembreDTO membreDTO;

    /*
        Ceci est la première méthode d'utilisation du Pattern DTO
        qui est la plus penible en faisant des Get & Set
        Mais qui est important à comprendre cela vous permet de
        savoir comment fonctionne les Frameworks de Mapping Entité-DTO
        comme --> Mapstruct , ModelMapper
     */

    public static AdhesionDTO fromAdhesion(Adhesion adhesion){
       AdhesionDTO adhesionDTO = new AdhesionDTO();
        adhesionDTO.setTypeAdhesion(adhesion.getTypeAdhesion());
        adhesionDTO.setTarif(adhesion.getTarif());
        adhesionDTO.setStatutAdhesion(adhesion.getStatutAdhesion());
        adhesionDTO.setMembreDTO(MembreDTO.fromMembre(adhesion.getMembre()));
       return adhesionDTO;
    }

    public static Adhesion fromAdhesionDTO(AdhesionDTO adhesionDTO){
        Adhesion adhesion = new Adhesion();
        adhesion.setTypeAdhesion(adhesionDTO.getTypeAdhesion());
        adhesion.setTarif(adhesionDTO.getTarif());
        adhesion.setStatutAdhesion(adhesionDTO.getStatutAdhesion());
        adhesion.setMembre(MembreDTO.fromMembreDTO(adhesionDTO.getMembreDTO()));
        return adhesion;
    }
}
