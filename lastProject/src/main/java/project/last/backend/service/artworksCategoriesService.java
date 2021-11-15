
package project.last.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import project.last.backend.model.ArtworksCategories;
import project.last.backend.repository.artworksCategoriesRepository;

@Service
public class artworksCategoriesService {
    
    public final artworksCategoriesRepository artworkCategoriesRepo;

    public artworksCategoriesService(artworksCategoriesRepository artworkCategoriesRepo) {
        this.artworkCategoriesRepo = artworkCategoriesRepo;
    }
    
    public List <ArtworksCategories> getArtworkCategories() {
        return artworkCategoriesRepo.findAll();
    }
    
    public Optional<ArtworksCategories> getArtworkCategoriesById(Integer id) {
        return artworkCategoriesRepo.findById(id);
    }

    public String addArtworkCategories(ArtworksCategories a){
        try {
            artworkCategoriesRepo.save(a);
            return "Added";
        } catch(Exception ex) {
            return "Failed";
        }
    }
    
    public String updateArtworkCategories(ArtworksCategories a, Integer id) {
        try{
            artworkCategoriesRepo.save(a);
            return "Updated";
        } catch(Exception ex) {
            return "Failed";
        }
    }
    
    public String deleteArtworkCategories(Integer id) {
        try {
            artworkCategoriesRepo.deleteById(id);
            return "Deleted";
        } catch(Exception ex) {
            return "Failed";
        }
    }
    
}
