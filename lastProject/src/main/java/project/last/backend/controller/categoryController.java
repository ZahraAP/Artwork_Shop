
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
import project.last.backend.model.Category;
import project.last.backend.service.categoryService;

@RestController
public class categoryController {
    
    public final categoryService categoryServ;

    public categoryController(categoryService categoryServ) {
        this.categoryServ = categoryServ;
    }
    
    @GetMapping(value = "/getCategory")
    public List<Category> getCategories(){
        return categoryServ.getCategories();
    }
    
    @GetMapping(value = "/getCategoryById/{id}")
    public Optional<Category> getCategoryById(@PathVariable Integer id) {
        return categoryServ.getCategoryById(id);
    }
    
    @PostMapping(value= "/addCategory")
    public String addCategory (@RequestBody Category c) {
        return categoryServ.addCategory(c);
    }
    
    @PutMapping (value= "/updateCategory/{id}")
    public String updateCategory(@RequestBody Category c, @PathVariable Integer id){
        return categoryServ.updateCategory(c, id);
    }
    
    @DeleteMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        return categoryServ.deleteCategory(id);
    }
}
