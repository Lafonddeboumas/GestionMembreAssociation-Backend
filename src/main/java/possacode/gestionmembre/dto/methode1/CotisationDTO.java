package possacode.gestionmembre.dto.methode1;

import lombok.Data;
import possacode.gestionmembre.entity.Cotisation;
import possacode.gestionmembre.entity.Membre;

import java.util.Date;

@Data
public class CotisationDTO {

    private Integer id;
    private String objet;
    private double montant;
    private Date dateVersement;
    private String modePaiment;
    private Integer idMembre;
    private String nomMembre;

    /*
        Ceci est la première méthode d'utilisation du Pattern DTO
        qui est la plus penible en faisant des Get & Set
        Mais qui est important à comprendre cela vous permet de
        savoir comment fonctionne les Frameworks de Mapping Entité-DTO
        comme --> Mapstruct , ModelMapper
     */

    public static CotisationDTO fromCotisation(Cotisation cotisation){
        CotisationDTO cotisationDTO = new CotisationDTO();
        cotisationDTO.setId(cotisation.getId());
        cotisationDTO.setObjet(cotisation.getObjet());
        cotisationDTO.setMontant(cotisation.getMontant());
        cotisationDTO.setDateVersement(cotisation.getDateVersement());
        cotisationDTO.setModePaiment(cotisation.getModePaiment());
        cotisationDTO.setIdMembre(cotisation.getMembre().getId());
        cotisationDTO.setNomMembre(cotisation.getMembre().getNom());
        return cotisationDTO;
    }

    public static Cotisation fromCotisationDTO(CotisationDTO cotisationDTO){
        Cotisation cotisation = new Cotisation();
        cotisation.setId(cotisationDTO.getId());
        cotisation.setObjet(cotisationDTO.getObjet());
        cotisation.setMontant(cotisationDTO.getMontant());
        cotisation.setDateVersement(cotisationDTO.getDateVersement());
        cotisation.setModePaiment(cotisationDTO.getModePaiment());
        cotisation.setMembre(
                Membre.builder()
                        .id(cotisationDTO.getIdMembre())
                        .build()
        );
        return cotisation;
    }
}
