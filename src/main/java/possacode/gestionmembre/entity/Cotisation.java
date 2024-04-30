package possacode.gestionmembre.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Cotisation extends AbstractEntity {

    private String objet;
    private double montant;
    private Date dateVersement;
    private String modePaiment;
    private String position;
    @ManyToOne
    @JoinColumn(name = "id_membre")
    private Membre membre;
}
