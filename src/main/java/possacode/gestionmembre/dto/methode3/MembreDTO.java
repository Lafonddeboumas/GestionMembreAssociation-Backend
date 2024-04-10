package possacode.gestionmembre.dto.methode3;

import lombok.*;
import org.springframework.beans.BeanUtils;
import possacode.gestionmembre.entity.Membre;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
      MembreDTO membreDTO = new MembreDTO();
        BeanUtils.copyProperties(membre, membreDTO);
        return membreDTO;
    }

    public static Membre fromMemberDto(MembreDTO membreDTO){
        Membre membre = new Membre();
        BeanUtils.copyProperties(membreDTO,membre);
        return membre;
    }

}
