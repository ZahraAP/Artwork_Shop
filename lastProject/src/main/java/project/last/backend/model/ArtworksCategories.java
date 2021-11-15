/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.last.backend.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zahra AP
 */
@Entity
@Table(name = "artworks_categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArtworksCategories.findAll", query = "SELECT a FROM ArtworksCategories a"),
    @NamedQuery(name = "ArtworksCategories.findById", query = "SELECT a FROM ArtworksCategories a WHERE a.id = :id"),
    @NamedQuery(name = "ArtworksCategories.findByArtworkId", query = "SELECT a FROM ArtworksCategories a WHERE a.artworkId = :artworkId"),
    @NamedQuery(name = "ArtworksCategories.findByCategoryId", query = "SELECT a FROM ArtworksCategories a WHERE a.categoryId = :categoryId")})
public class ArtworksCategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "artwork_id")
    private int artworkId;
    @Basic(optional = false)
    @Column(name = "category_id")
    private int categoryId;

    public ArtworksCategories() {
    }

    public ArtworksCategories(Integer id) {
        this.id = id;
    }

    public ArtworksCategories(Integer id, int artworkId, int categoryId) {
        this.id = id;
        this.artworkId = artworkId;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getArtworkId() {
        return artworkId;
    }

    public void setArtworkId(int artworkId) {
        this.artworkId = artworkId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArtworksCategories)) {
            return false;
        }
        ArtworksCategories other = (ArtworksCategories) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "project.last.backend.model.ArtworksCategories[ id=" + id + " ]";
    }
    
}
