package possacode.gestionmembre.dto.methode4;

import lombok.Data;
import org.modelmapper.ModelMapper;
import possacode.gestionmembre.entity.Membre;
import possacode.gestionmembre.enumforentity.StatutMembre;

import java.util.Date;

@Data
public class MembreDTO {

    private Integer id;
    private String nomMembre;
    private String prenom;
    private String adresse;
    private String email;
    private String telephone;
    private Date dateDeNaissance;
    private Date dateAdhesion;
    private StatutMembre statutMembre;
    private String photo;

    public static MembreDTO fromMembre(Membre membre){
        ModelMapper modelMapper = new ModelMapper();
        MembreDTO membreDTO = modelMapper.map(membre, MembreDTO.class);
        return membreDTO;
    }

    public static Membre fromMembreDTO(MembreDTO membreDTO){
        ModelMapper modelMapper = new ModelMapper();
        Membre membre = modelMapper.map(membreDTO, Membre.class);
        return membre;
    }

}
