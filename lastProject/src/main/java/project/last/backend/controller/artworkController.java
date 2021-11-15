
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
import project.last.backend.model.Artwork;
import project.last.backend.service.artworkService;

@RestController
public class artworkController {
    
    public final artworkService artworkServ;

    public artworkController(artworkService artworkServ) {
        this.artworkServ = artworkServ;
    }
    
    @GetMapping(value = "/getArtworks")
    public List<Artwork> getArtworks(){
        return artworkServ.getArtworks();
    }
    
    @GetMapping(value = "/getArtworkById/{id}")
    public Optional<Artwork> getArtworkById(@PathVariable Integer id) {
        return artworkServ.getArtworkById(id);
    }
    
    @PostMapping(value= "/addArtwork")
    public String addArtwork (@RequestBody Artwork a) {
        return artworkServ.addArtwork(a);
    }
    
    @PutMapping (value= "/updateArtwork/{id}")
    public String updateArtwork(@RequestBody Artwork a, @PathVariable Integer id){
        return artworkServ.updateArtwork(a, id);
    }
    
    @DeleteMapping("/deleteArtwork/{id}")
    public String deleteArtwork(@PathVariable Integer id) {
        return artworkServ.deleteArtwork(id);
    }
    
    @GetMapping(value="/getArtworksByArtist/{artistId}")
    public List<Artwork> getArtworksByArtist(@PathVariable("artistId") Integer artistId){
        return artworkServ.getArtworksByArtist(artistId);
    }
    
    @GetMapping(value = "/countPurchasedItemsByCustomer/{customerIdIN}")
    public int countPurchasedItemsByCustomer(@PathVariable("customerIdIN") Integer customerIdIN) {
        return artworkServ.countPurchasedItemsByCustomer(customerIdIN);
    }
    
    @GetMapping(value = "/getSoldArtworks")
    public List <Artwork> getSoldArtworks() {
        return artworkServ.getSoldArtworks();
    }
    
    @GetMapping(value = "/getUnsoldArtworks")
    public List <Artwork> getUnsoldArtworks() {
        return artworkServ.getUnsoldArtworks();
    }
    
    @GetMapping(value = "/priceLowerThan/{priceIN}")
    public List <Artwork> priceLowerThan(@PathVariable("priceIN") Integer priceIN) {
        return artworkServ.priceLowerThan(priceIN);
    }
    
    @GetMapping(value = "/priceUpperThan/{priceIN}")
    public List <Artwork> priceUpperThan(@PathVariable("priceIN") Integer priceIN) {
        return artworkServ.priceUpperThan(priceIN);
    }
}
