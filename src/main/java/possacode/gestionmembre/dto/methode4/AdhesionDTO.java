package possacode.gestionmembre.dto.methode4;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import possacode.gestionmembre.entity.Adhesion;
import possacode.gestionmembre.enumforentity.StatutAdhesion;
import possacode.gestionmembre.enumforentity.TypeAdhesion;

@Getter
@Setter
public class AdhesionDTO {

    private TypeAdhesion typeAdhesion;
    private double tarif;
    private StatutAdhesion statutAdhesion;
    private MembreDTO membreDTO;


    public static AdhesionDTO fromAdhesion(Adhesion adhesion){
        ModelMapper modelMapper = new ModelMapper();
        AdhesionDTO adhesionDTO = modelMapper.map(adhesion, AdhesionDTO.class);
        adhesionDTO.setMembreDTO(MembreDTO.fromMembre(adhesion.getMembre()));
        return adhesionDTO;
    }

    public static Adhesion fromAdhesionDTO(AdhesionDTO adhesionDTO){
        ModelMapper modelMapper = new ModelMapper();
        Adhesion adhesion = modelMapper.map(adhesionDTO, Adhesion.class);
        adhesion.setMembre(MembreDTO.fromMembreDTO(adhesionDTO.getMembreDTO()));
        return adhesion;
    }
}
