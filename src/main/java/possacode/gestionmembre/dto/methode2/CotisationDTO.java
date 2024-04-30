package possacode.gestionmembre.dto.methode2;

import lombok.*;
import org.modelmapper.ModelMapper;
import possacode.gestionmembre.entity.Cotisation;
import possacode.gestionmembre.entity.Membre;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CotisationDTO {

    private Integer id;
    private String objet;
    private double montant;
    private Date dateVersement;
    private String modePaiment;
    private Integer idMembre;
    private String nomMembre;

     /*
        Ceci est la deuxième méthode d'utilisation du Pattern DTO
        en utilisant cette fois ci la méthode builder fournis par
        l'annotation @Builder qui viens de la dépendance lombok
     */

    public static CotisationDTO fromCotisation(Cotisation cotisation){
         return CotisationDTO.builder()
                 .id(cotisation.getId())
                 .objet(cotisation.getObjet())
                 .montant(cotisation.getMontant())
                 .dateVersement(cotisation.getDateVersement())
                 .modePaiment(cotisation.getModePaiment())
                 .idMembre(cotisation.getMembre().getId())
                 .nomMembre(cotisation.getMembre().getNom())
                 .build();

    }

    public static Cotisation fromCotisationDTO(CotisationDTO cotisationDTO){
        return Cotisation.builder()
                .id(cotisationDTO.getId())
                .objet(cotisationDTO.getObjet())
                .montant(cotisationDTO.getMontant())
                .dateVersement(cotisationDTO.getDateVersement())
                .modePaiment(cotisationDTO.getModePaiment())
                .membre(
                        Membre.builder()
                                .id(cotisationDTO.getIdMembre())
                        .build())
                .build();

    }
}
