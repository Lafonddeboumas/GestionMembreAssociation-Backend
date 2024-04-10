package possacode.gestionmembre.dto.methode2;

import lombok.*;
import possacode.gestionmembre.entity.Membre;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class MembreDTO {

    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private int telephone;
    private Date dateDeNaissance;
    private Date dateAdhesion;
    private boolean statut;
    private String photo;

    public static MembreDTO fromMember(Membre membre){
       return MembreDTO.builder()
               .nom(membre.getNom())
               .prenom(membre.getPrenom())
               .adresse(membre.getAdresse())
               .email(membre.getEmail())
               .telephone(membre.getTelephone())
               .dateDeNaissance(membre.getDateDeNaissance())
               .dateAdhesion(membre.getDateAdhesion())
               .statut(membre.isStatut())
               .photo(membre.getPhoto())
               .build();
    }

    public static Membre fromMemberDto(MembreDTO membreDTO){
        return Membre.builder()
                .nom(membreDTO.getNom())
                .prenom(membreDTO.getPrenom())
                .adresse(membreDTO.getAdresse())
                .email(membreDTO.getEmail())
                .telephone(membreDTO.getTelephone())
                .dateDeNaissance(membreDTO.getDateDeNaissance())
                .dateAdhesion(membreDTO.getDateAdhesion())
                .statut(membreDTO.isStatut())
                .photo(membreDTO.getPhoto())
                .build();
    }

}
