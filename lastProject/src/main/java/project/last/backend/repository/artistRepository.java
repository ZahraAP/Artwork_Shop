/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project.last.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.last.backend.model.Artist;

public interface artistRepository extends JpaRepository<Artist, Integer> {
    
    @Query(value="SELECT a FROM Artist a WHERE a.firstName = :firstName AND a.lastName = :lastName")
    public List<Artist> findArtistByName(@Param("firstName") String firstName, @Param("lastName")  String lastName);

}
