
package project.last.backend.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.last.backend.model.ArtworksCategories;
import project.last.backend.service.artworksCategoriesService;

@RestController
public class artworkCaregoriesController {
    
    public final artworksCategoriesService artworksCategoriesServ;

    public artworkCaregoriesController(artworksCategoriesService artworksCategoriesServ) {
        this.artworksCategoriesServ = artworksCategoriesServ;
    }
    
    @GetMapping(value = "/getArtworksCategories")
    public List<ArtworksCategories> getArtworksCategories(){
        return artworksCategoriesServ.getArtworkCategories();
    }
    
    @GetMapping(value = "/getArtworksCategoriesById/{id}")
    public Optional<ArtworksCategories> getArtworksCategoriesById(@PathVariable Integer id) {
        return artworksCategoriesServ.getArtworkCategoriesById(id);
    }
    
    @PostMapping(value= "/addArtworksCategories")
    public String addArtworksCategories(@RequestBody ArtworksCategories a) {
        return artworksCategoriesServ.addArtworkCategories(a);
    }
    
    @PutMapping (value= "/updateArtworksCategories/{id}")
    public String updateArtworksCategories(@RequestBody ArtworksCategories a, @PathVariable Integer id){
        return artworksCategoriesServ.updateArtworkCategories(a, id);
    }
    
    @DeleteMapping("/deleteArtworksCategories/{id}")
    public String deleteArtworksCategories(@PathVariable Integer id) {
        return artworksCategoriesServ.deleteArtworkCategories(id);
    }
}
