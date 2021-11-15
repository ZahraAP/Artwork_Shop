
package project.last.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import project.last.backend.model.Category;
import project.last.backend.repository.categoryRepository;

@Service
public class categoryService {
    
    public final categoryRepository categoryRepo;

    public categoryService(categoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
    
    public List <Category> getCategories() {
        return categoryRepo.findAll();
    }
    
    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepo.findById(id);
    }

    public String addCategory(Category c){
        try {
            categoryRepo.save(c);
            return "Added";
        } catch(Exception ex) {
            return "Failed";
        }
    }
    
    public String updateCategory(Category c, Integer id) {
        try{
            categoryRepo.save(c);
            return "Updated";
        } catch(Exception ex) {
            return "Failed";
        }
    }
    
    public String deleteCategory(Integer id) {
        try {
            categoryRepo.deleteById(id);
            return "Deleted";
        } catch(Exception ex) {
            return "Failed";
        }
    }
    
}
