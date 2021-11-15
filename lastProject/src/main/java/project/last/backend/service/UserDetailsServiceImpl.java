
package project.last.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.last.backend.MyUserDetails;
import project.last.backend.model.UserEntity;
import project.last.backend.repository.userRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private userRepository userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        UserEntity user = userRepository.getUserByEmail(email);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new MyUserDetails(user);
    }
 
}
