package possacode.gestionmembre.dto.methode2;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import possacode.gestionmembre.entity.Evenement;
import possacode.gestionmembre.entity.Membre;
import possacode.gestionmembre.entity.Participation;
import possacode.gestionmembre.entity.StatutParticipation;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ParticipationDTO {

    private Date dateInscription;
    private StatutParticipation statutParticipation;
    private EvenementDTO evenementDTO;
    private MembreDTO membreDTO;


    public static ParticipationDTO fromParticipation(Participation participation){
        return ParticipationDTO.builder()
                .dateInscription(participation.getDateInscription())
                .statutParticipation(participation.getStatutParticipation())
                .evenementDTO(EvenementDTO.fromEvenement(participation.getEvenement()))
                .membreDTO(MembreDTO.fromMember(participation.getMembre()))
                .build();
    }

    public static Participation fromParticipationDTO(ParticipationDTO participationDTO){
        return Participation.builder()
                .dateInscription(participationDTO.getDateInscription())
                .statutParticipation(participationDTO.getStatutParticipation())
                .evenement(EvenementDTO.fromEvenementDTO(participationDTO.getEvenementDTO()))
                .membre(MembreDTO.fromMemberDto(participationDTO.getMembreDTO()))
                .build();
    }

}
