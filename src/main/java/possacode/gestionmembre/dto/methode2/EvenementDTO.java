package possacode.gestionmembre.dto.methode2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import possacode.gestionmembre.entity.Evenement;
import possacode.gestionmembre.entity.TypeEvenement;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class EvenementDTO {

    private String nom;
    private Date date;
    private Date heure;
    private Date lieu;
    private String description;
    private TypeEvenement typeEvenement;
    private double tarif;

    public static EvenementDTO fromEvenement(Evenement evenement){
        return EvenementDTO.builder()
                .nom(evenement.getNom())
                .date(evenement.getDate())
                .heure(evenement.getHeure())
                .lieu(evenement.getLieu())
                .description(evenement.getDescription())
                .tarif(evenement.getTarif())
                .build();
    }

    public static Evenement fromEvenementDTO(EvenementDTO evenementDTO){
        return Evenement.builder()
                .nom(evenementDTO.getNom())
                .date(evenementDTO.getDate())
                .heure(evenementDTO.getHeure())
                .lieu(evenementDTO.getLieu())
                .description(evenementDTO.getDescription())
                .tarif(evenementDTO.getTarif())
                .build();
    }
}
