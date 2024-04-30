package possacode.gestionmembre.dto.methode2;

import lombok.*;
import possacode.gestionmembre.entity.Membre;
import possacode.gestionmembre.enumforentity.StatutMembre;

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
    private StatutMembre statutMembre;
    private String photo;

     /*
        Ceci est la deuxième méthode d'utilisation du Pattern DTO
        en utilisant cette fois ci la méthode builder fournis par
        l'annotation @Builder qui viens de la dépendance lombok
     */

    public static MembreDTO fromMember(Membre membre){
       return MembreDTO.builder()
               .id(membre.getId())
               .nomMembre(membre.getNom())
               .prenom(membre.getPrenom())
               .adresse(membre.getAdresse())
               .email(membre.getEmail())
               .telephone(membre.getTelephone())
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
                .statutMembre(membreDTO.getStatutMembre())
                .photo(membreDTO.getPhoto())
                .build();
    }

}
