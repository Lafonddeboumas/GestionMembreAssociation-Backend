package possacode.gestionmembre.dto.methode3;

import lombok.*;
import org.springframework.beans.BeanUtils;
import possacode.gestionmembre.entity.Membre;
import possacode.gestionmembre.enumforentity.StatutMembre;

import java.util.Date;

@Getter
@Setter
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
        Ceci est la troisième méthode d'utilisation du Pattern DTO
        en utilisant cette fois ci la classe BeanUtils avec sa méthode
        copyProperties  fournis par SPRING
     */

    public static MembreDTO fromMembre(Membre membre){
      MembreDTO membreDTO = new MembreDTO();
        BeanUtils.copyProperties(membre, membreDTO);
        return membreDTO;
    }

    public static Membre fromMembreDto(MembreDTO membreDTO){
        Membre membre = new Membre();
        BeanUtils.copyProperties(membreDTO,membre);
        return membre;
    }

}
