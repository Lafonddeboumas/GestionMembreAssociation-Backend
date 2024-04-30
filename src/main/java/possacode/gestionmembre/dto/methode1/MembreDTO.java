package possacode.gestionmembre.dto.methode1;


import lombok.Data;
import possacode.gestionmembre.entity.Membre;
import possacode.gestionmembre.enumforentity.StatutMembre;

@Data
public class MembreDTO {

    private Integer id;
    private String nomMembre;
    private String prenomMembre;
    //private String adresse;
    private String email;
    private String telephone;
    private StatutMembre statutMembre;
    private String photo;

    /*
        Ceci est la première méthode d'utilisation du Pattern DTO
        qui est la plus penible en faisant des Get & Set
        Mais qui est important à comprendre cela vous permet de
        savoir comment fonctionne les Frameworks de Mapping Entité-DTO
        comme --> Mapstruct , ModelMapper
     */

    public static MembreDTO fromMembre(Membre membre){
        MembreDTO membreDTO = new MembreDTO();
        membreDTO.setId(membre.getId());
        membreDTO.setNomMembre(membre.getNom());
        membreDTO.setPrenomMembre(membre.getPrenom());
        //membreDTO.setAdresse(membre.getAdresse());
        membreDTO.setEmail(membre.getEmail());
        membreDTO.setTelephone(membre.getTelephone());
        membreDTO.setStatutMembre(membre.getStatutMembre());
        membreDTO.setPhoto(membre.getPhoto());
        return membreDTO;
    }

    public static Membre fromMembreDTO(MembreDTO membreDTO){
        Membre membre = new Membre();
        membre.setId(membreDTO.getId());
        membre.setNom(membreDTO.getNomMembre());
        membre.setPrenom(membreDTO.getPrenomMembre());
        //membre.setAdresse(membreDTO.getAdresse());
        membre.setEmail(membreDTO.getEmail());
        membre.setTelephone(membreDTO.getTelephone());
        membre.setStatutMembre(membreDTO.getStatutMembre());
        membre.setPhoto(membreDTO.getPhoto());
        return membre;
    }
}
