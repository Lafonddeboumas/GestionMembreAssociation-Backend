package possacode.gestionmembre.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import possacode.gestionmembre.enumforentity.StatutMembre;

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

    private String telephone;

    private Date dateAdhesion;
    @Enumerated(EnumType.STRING)
    private StatutMembre statutMembre;

    private String photo;

   @OneToMany(mappedBy = "membre")
    private List<Cotisation> cotisation;

    @OneToMany(mappedBy = "membre")
   private List<Adhesion> adhesions;

}
