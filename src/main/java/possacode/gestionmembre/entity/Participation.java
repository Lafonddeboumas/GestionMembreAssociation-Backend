package possacode.gestionmembre.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Participation extends AbstractEntity {

    private Date dateInscription;
    private StatutParticipation statutParticipation;
    @ManyToOne
    @JoinColumn(name = "evenement_id")
    private Evenement evenement;
    @ManyToOne
    @JoinColumn(name = "membre_id")
    private Membre membre;
}
