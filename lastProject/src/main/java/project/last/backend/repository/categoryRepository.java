
package project.last.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.last.backend.model.Category;

public interface categoryRepository extends JpaRepository<Category, Integer> {
    
}
