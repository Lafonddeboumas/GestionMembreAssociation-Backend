package possacode.gestionmembre.dto.methode4;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import possacode.gestionmembre.entity.Cotisation;
import possacode.gestionmembre.entity.Membre;

import java.util.Date;

@Data
public class CotisationDTO {

    private Integer id;
    private String objet;
    private double montant;
    private Date dateVersement;
    private String modePaiment;
    private String position;
    private Integer idMembre;

    public static CotisationDTO fromCotisation(Cotisation cotisation){
        ModelMapper modelMapper = new ModelMapper();
        CotisationDTO cotisationDTO = modelMapper.map(cotisation, CotisationDTO.class);
        cotisationDTO.setIdMembre(cotisation.getMembre().getId());
        return cotisationDTO;
    }

    public static Cotisation fromCotisationDTO(CotisationDTO cotisationDTO){
        ModelMapper modelMapper = new ModelMapper();
        Cotisation cotisation = modelMapper.map(cotisationDTO, Cotisation.class);
        cotisation.setMembre(
                Membre.builder()
                        .id(cotisationDTO.idMembre)
                        .build()
        );
        return cotisation;
    }
}
