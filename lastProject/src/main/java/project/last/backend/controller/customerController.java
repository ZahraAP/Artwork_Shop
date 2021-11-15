
package project.last.backend.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.last.backend.model.Customer;
import project.last.backend.service.customerService;

@RestController
public class customerController {
    
    public final customerService customerServ;
    
    public customerController(customerService customerServ) {
        this.customerServ = customerServ;
    }
    
    @GetMapping(value = "/getCustomers")
    public List<Customer> getCustomers(){
        return customerServ.getCustomers();
    }
    
    @GetMapping(value = "/getCustomerById/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Integer id) {
        return customerServ.getCustomerById(id);
    }
    
    @PostMapping(value= "/addCustomer")
    public String addCustomer (@RequestBody Customer c) {
        return customerServ.addCustomer(c);
    }
    
    @PutMapping (value= "/updateCustomer/{id}")
    public String updateCustomer(@RequestBody Customer c, @PathVariable Integer id){
        return customerServ.updateCustomer(c, id);
    }
    
    @DeleteMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        return customerServ.deleteCustomer(id);
    }
}
