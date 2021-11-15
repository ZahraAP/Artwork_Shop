/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project.last.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.last.backend.model.Artwork;

public interface artworkRepository extends JpaRepository<Artwork, Integer> {
    @Query(value="SELECT a FROM Artwork a WHERE a.artistId = :artistId")
    public List<Artwork> getArtworksByArtist(@Param("artistId") Integer artistId);

}
