
package project.last.backend.controller;

import io.swagger.annotations.Api;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.last.backend.model.Artist;
import project.last.backend.service.artistService;

@RestController
public class artistController {
    
    public final artistService artistServ;

    public artistController(artistService artistServ) {
        this.artistServ = artistServ;
    }
    
    @GetMapping(value = "/getArtists")
    public List<Artist> getArtists(){
        return artistServ.getArtists();
    }
    
    @GetMapping(value = "/getArtistById/{id}")
    public Optional<Artist> getArtistById(@PathVariable Integer id) {
        return artistServ.getArtistById(id);
    }
    
    @PostMapping(value= "/addArtist")
    public String addArtist (@RequestBody Artist a) {
        return artistServ.addArtist(a);
    }
    
    @PutMapping (value= "/updateArtist/{id}")
    public String updateArtist(@RequestBody Artist a, @PathVariable Integer id){
        return artistServ.updateArtist(a, id);
    }
    
    @DeleteMapping("/deleteArtist/{id}")
    public String deleteArtist(@PathVariable Integer id) {
        return artistServ.deleteArtist(id);
    }
    
    @GetMapping(value="/findArtistByName/{firstName}/{lastName}")
    public List<Artist> findArtistByName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
        return artistServ.findArtistByName(firstName, lastName);
    }
    
    
}
