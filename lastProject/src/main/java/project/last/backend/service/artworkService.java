
package project.last.backend.service;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import project.last.backend.model.Artwork;
import project.last.backend.repository.artworkRepository;

@Service
public class artworkService {
    
    public final artworkRepository artworkRepo;
    @PersistenceContext
    public EntityManager em;

    public artworkService(artworkRepository artworkRepo) {
        this.artworkRepo = artworkRepo;
    }
    public List <Artwork> getArtworks() {
        return artworkRepo.findAll();
    }
    
    public Optional<Artwork> getArtworkById(Integer id) {
        return artworkRepo.findById(id);
    }

    public String addArtwork(Artwork a){
        try {
            artworkRepo.save(a);
            return "Added";
        } catch(Exception ex) {
            return "Failed";
        }
    }
    
    public String updateArtwork(Artwork a, Integer id) {
        try{
            artworkRepo.save(a);
            return "Updated";
        } catch(Exception ex) {
            return "Failed";
        }
    }
    
    public String deleteArtwork(Integer id) {
        try {
            artworkRepo.deleteById(id);
            return "Deleted";
        } catch(Exception ex) {
            return "Failed";
        }
    }
    
    public List<Artwork> getArtworksByArtist(@Param("artistId") Integer artistId){
        List<Artwork> result = artworkRepo.getArtworksByArtist(artistId);
        if(CollectionUtils.isEmpty(result)){
            throw new NoResultException("Not found");
        } else {
            return result;
        }
    }
    
    public int countPurchasedItemsByCustomer(Integer customerIdIN) {
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("countPurchasedItemsByCustomer");
            spq.registerStoredProcedureParameter("customerIdIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("purchasedItems", Integer.class, ParameterMode.OUT);
            spq.setParameter("customerIdIN", customerIdIN);
            spq.execute();
            int purchasedItems = ((int)spq.getOutputParameterValue("purchasedItems"));
            return purchasedItems;
        }  catch (Exception ex) {
            return 0;
        }
    }
    
    public List <Artwork> getSoldArtworks() {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("getSoldArtworks");
        spq.execute();
        return spq.getResultList();
    }
    
    public List <Artwork> getUnsoldArtworks() {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("getUnsoldArtworks");
        spq.execute();
        return spq.getResultList();
    }
    
    public List <Artwork> priceLowerThan(@Param("priceIN") Integer priceIN) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("priceLowerThan");
        spq.registerStoredProcedureParameter("priceIN", Integer.class, ParameterMode.IN);
        spq.setParameter("priceIN", priceIN);
        spq.execute();
        return spq.getResultList();
    }
    
    public List <Artwork> priceUpperThan(Integer priceIN) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("priceUpperThan");
        spq.registerStoredProcedureParameter("priceIN", Integer.class, ParameterMode.IN);
        spq.setParameter("priceIN", priceIN);
        spq.execute();
        return spq.getResultList();
    }
}
