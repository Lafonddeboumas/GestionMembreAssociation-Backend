package possacode.gestionmembre.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import possacode.gestionmembre.enumforentity.StatutAdhesion;
import possacode.gestionmembre.enumforentity.TypeAdhesion;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Adhesion extends AbstractEntity{

    private TypeAdhesion typeAdhesion;
    private double tarif;
    private StatutAdhesion statutAdhesion;
    @ManyToOne
    @JoinColumn(name = "membre_id")
    private Membre membre;
}
