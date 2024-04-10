package possacode.gestionmembre.dto.methode2;

import lombok.*;
import possacode.gestionmembre.entity.Cotisation;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class CotisationDTO {

    private String objet;
    private double montant;
    private Date dateVersement;
    private String modePaiment;
    private String statut;
    private MembreDTO membreDTO;

    public static CotisationDTO fromCotistaion(Cotisation cotisation){
        return CotisationDTO.builder()
                .objet(cotisation.getObjet())
                .montant(cotisation.getMontant())
                .dateVersement(cotisation.getDateVersement())
                .modePaiment(cotisation.getModePaiment())
                .statut(cotisation.getStatut())
                .membreDTO(MembreDTO.fromMember(cotisation.getMembre()))
                .build();
    }

    public static Cotisation fromCotistaionDTO(CotisationDTO cotisationDTO){
        return Cotisation.builder()
                .objet(cotisationDTO.getObjet())
                .montant(cotisationDTO.getMontant())
                .dateVersement(cotisationDTO.getDateVersement())
                .modePaiment(cotisationDTO.getModePaiment())
                .statut(cotisationDTO.getStatut())
                .membre(MembreDTO.fromMemberDto(cotisationDTO.getMembreDTO()))
                .build();
    }
}
