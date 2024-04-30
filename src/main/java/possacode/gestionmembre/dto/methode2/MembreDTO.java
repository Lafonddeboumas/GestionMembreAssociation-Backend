package possacode.gestionmembre.dto.methode2;

import lombok.*;
import possacode.gestionmembre.entity.Membre;
import possacode.gestionmembre.entity.StatutMembre;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class MembreDTO {

    private Integer id;
    private String nomMembre;
    private String prenom;
    private String adresse;
    private String email;
    private String telephone;
    private Date dateDeNaissance;
    private Date dateAdhesion;
    private StatutMembre statutMembre;
    private String photo;

    public static MembreDTO fromMember(Membre membre){
       return MembreDTO.builder()
               .id(membre.getId())
               .nomMembre(membre.getNom())
               .prenom(membre.getPrenom())
               .adresse(membre.getAdresse())
               .email(membre.getEmail())
               .telephone(membre.getTelephone())
               .dateDeNaissance(membre.getDateDeNaissance())
               .dateAdhesion(membre.getDateAdhesion())
               .statutMembre(membre.getStatutMembre())
               .photo(membre.getPhoto())
               .build();
    }

    public static Membre fromMemberDto(MembreDTO membreDTO){
        return Membre.builder()
                .id(membreDTO.getId())
                .nom(membreDTO.getNomMembre())
                .prenom(membreDTO.getPrenom())
                .adresse(membreDTO.getAdresse())
                .email(membreDTO.getEmail())
                .telephone(membreDTO.getTelephone())
                .dateDeNaissance(membreDTO.getDateDeNaissance())
                .dateAdhesion(membreDTO.getDateAdhesion())
                .statutMembre(membreDTO.getStatutMembre())
                .photo(membreDTO.getPhoto())
                .build();
    }

}
