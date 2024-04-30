package possacode.gestionmembre.dto.methode3;

import lombok.Data;
import org.springframework.beans.BeanUtils;
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
        Ceci est la troisième méthode d'utilisation du Pattern DTO
        en utilisant cette fois ci la classe BeanUtils avec sa méthode
        copyProperties  fournis par SPRING
     */


    public static CotisationDTO fromCotisation(Cotisation cotisation){
        CotisationDTO cotisationDTO = new CotisationDTO();
        BeanUtils.copyProperties(cotisation,cotisationDTO);
        cotisationDTO.setIdMembre(cotisation.getMembre().getId());
        cotisationDTO.setNomMembre(cotisation.getMembre().getNom());
        return cotisationDTO;
    }

    public static Cotisation fromCotisation(CotisationDTO cotisationDTO){
        Cotisation cotisation = new Cotisation();
        BeanUtils.copyProperties(cotisationDTO,cotisation);
        cotisation.setMembre(
                Membre.builder()
                        .id(cotisationDTO.getIdMembre())
                        .build()
        );
        return cotisation;
    }


}
