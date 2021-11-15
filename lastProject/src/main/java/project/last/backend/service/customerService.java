
package project.last.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import project.last.backend.model.Customer;
import project.last.backend.repository.customerRepository;

@Service
public class customerService {
    
    public final customerRepository customerRepo;

    public customerService(customerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }
    
    public List <Customer> getCustomers() {
        return customerRepo.findAll();
    }
    
    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepo.findById(id);
    }

    public String addCustomer(Customer c){
        try {
            customerRepo.save(c);
            return "Added";
        } catch(Exception ex) {
            return "Failed";
        }
    }
    
    public String updateCustomer(Customer c, Integer id) {
        try{
            customerRepo.save(c);
            return "Updated";
        } catch(Exception ex) {
            return "Failed";
        }
    }
    
    public String deleteCustomer(Integer id) {
        try {
            customerRepo.deleteById(id);
            return "Deleted";
        } catch(Exception ex) {
            return "Failed";
        }
    }
    
}
