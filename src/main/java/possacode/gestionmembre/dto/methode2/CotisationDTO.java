package possacode.gestionmembre.dto.methode2;

import lombok.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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
    private String position;
    private Integer idMembre;
    private String nomMembre;


    public static CotisationDTO fromCotisation(Cotisation cotisation){
       // return CotisationDTO.builder()
         //       .objet(cotisation.getObjet())
         //       .montant(cotisation.getMontant())
          //      .dateVersement(cotisation.getDateVersement())
         //       .modePaiment(cotisation.getModePaiment())
          //      .statut(cotisation.getStatut())
         //       .membreDTO(MembreDTO.fromMember(cotisation.getMembre()))
          //     // .idMembre(cotisation.getMembre().getId())
          //      .build();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        CotisationDTO cotisationDTO = modelMapper.map(cotisation, CotisationDTO.class);
        cotisationDTO.setIdMembre(cotisation.getMembre().getId());
        return cotisationDTO;
    }

    public static Cotisation fromCotisationDTO(CotisationDTO cotisationDTO){
        //return Cotisation.builder()
          //      .objet(cotisationDTO.getObjet())
            //    .montant(cotisationDTO.getMontant())
              //  .dateVersement(cotisationDTO.getDateVersement())
              //  .modePaiment(cotisationDTO.getModePaiment())
              //  .statut(cotisationDTO.getStatut())
              //  .membre(MembreDTO.fromMemberDto(cotisationDTO.getMembreDTO()))
              //  .build();
        ModelMapper modelMapper = new ModelMapper();
        Cotisation cotisation = modelMapper.map(cotisationDTO, Cotisation.class);
        cotisation.setMembre(Membre
                .builder()
                        .id(cotisationDTO.getIdMembre())
                .build());
        return cotisation;
    }
}
