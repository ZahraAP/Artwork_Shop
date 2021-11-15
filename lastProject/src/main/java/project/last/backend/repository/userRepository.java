
package project.last.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.last.backend.model.UserEntity;

@Repository
public interface userRepository extends JpaRepository<UserEntity, Integer> {
    
//    UserEntity findByEmail(String email);
    
    @Query("SELECT u FROM UserEntity u WHERE u.email = :email")
    public UserEntity getUserByEmail(@Param("email") String email);
}
