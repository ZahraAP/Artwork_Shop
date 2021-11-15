
package project.last.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import project.last.backend.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").hasAnyAuthority("ADMIN", "ARTIST", "CUSTOMER")
            .antMatchers("//addArtwork", "/updateArtwork/**", "/deleteArtwork/**").hasAnyAuthority("ADMIN", "ARTIST")
            .antMatchers("/deleteCustomer/**", "/getCustomerById/**").hasAnyAuthority("ADMIN", "CUSTOMER")
            .antMatchers("/updateCategory/**").hasAuthority("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll()
            .and()
            .logout().permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/403")
            ;
    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // Disable CSRF
//        http.csrf().disable()
//                // Only admin can perform HTTP delete operation
//                .authorizeRequests().antMatchers(HttpMethod.GET).hasRole(Role.ADMIN)
//                // any authenticated user can perform all other operations
//                .antMatchers("/artist-controller/**").hasAnyRole(Role.ADMIN, Role.CUSTOMER).and().httpBasic()
//                // Permit all other request without authentication
//                .and().authorizeRequests().anyRequest().permitAll()
//                // We don't need sessions to be created.
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .logout().permitAll()
//                .and()
//                .exceptionHandling().accessDeniedPage("/403");
//    }
 
}
