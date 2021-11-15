
package project.last.backend.service;

import java.util.List;
import java.util.Optional;
import javax.persistence.NoResultException;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import project.last.backend.model.Artist;
import project.last.backend.repository.artistRepository;

@Service
public class artistService {
    
    public final artistRepository artistRepo;

    public artistService(artistRepository artistRepo) {
        this.artistRepo = artistRepo;
    }
    
    public List <Artist> getArtists() {
        return artistRepo.findAll();
    }
    
    public Optional<Artist> getArtistById(Integer id) {
        return artistRepo.findById(id);
    }

    public String addArtist(Artist a){
        try {
            artistRepo.save(a);
            return "Added";
        } catch(Exception ex) {
            return "Failed";
        }
    }
    
    public String updateArtist(Artist a, Integer id) {
        try{
            artistRepo.save(a);
            return "Updated";
        } catch(Exception ex) {
            return "Failed";
        }
    }
    
    public String deleteArtist(Integer id) {
        try {
            artistRepo.deleteById(id);
            return "Deleted";
        } catch(Exception ex) {
            return "Failed";
        }
    }
    
    public List<Artist> findArtistByName(@Param("firstName") String firstName,@Param("lastName") String lastName){
        List<Artist> result = artistRepo.findArtistByName(firstName, lastName);
        if(CollectionUtils.isEmpty(result)){
            throw new NoResultException("No artist found");
        } else {
            return result;
        }
    }
    
}
