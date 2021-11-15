
package project.last.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.last.backend.model.Customer;

@Repository
public interface customerRepository extends JpaRepository<Customer, Integer> {
    
}
