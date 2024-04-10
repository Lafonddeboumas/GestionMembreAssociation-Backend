package possacode.gestionmembre.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Adhesion extends AbstractEntity{

    private TypeAdhesion typeAdhesion;
    private double tarif;
    private Date dateDebut;
    private Date dateFin;
    private StatutAdhesion statutAdhesion;
}
