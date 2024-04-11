package possacode.gestionmembre.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Membre extends AbstractEntity {

    private String nom;

    private String prenom;

    private String adresse;

    private String email;

    private int telephone;

    private Date dateDeNaissance;

    private Date dateAdhesion;

    private boolean statut;

    private String photo;

   @OneToMany(mappedBy = "membre")
    private List<Cotisation> cotisation;

   @OneToMany(mappedBy = "membre")
   private List<Participation> participations;

    @OneToMany(mappedBy = "membre")
   private List<Adhesion> adhesions;

}
