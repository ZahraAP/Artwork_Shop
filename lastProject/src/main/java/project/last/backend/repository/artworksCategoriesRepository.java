
package project.last.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.last.backend.model.ArtworksCategories;

public interface artworksCategoriesRepository extends JpaRepository<ArtworksCategories, Integer> {
    
}
