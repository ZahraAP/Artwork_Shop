/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.last.backend.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zahra AP
 */
@Entity
@Table(name = "artwork")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artwork.findAll", query = "SELECT a FROM Artwork a"),
    @NamedQuery(name = "Artwork.findById", query = "SELECT a FROM Artwork a WHERE a.id = :id"),
    @NamedQuery(name = "Artwork.findByTitle", query = "SELECT a FROM Artwork a WHERE a.title = :title"),
    @NamedQuery(name = "Artwork.findByImageUrl", query = "SELECT a FROM Artwork a WHERE a.imageUrl = :imageUrl"),
    @NamedQuery(name = "Artwork.findByDescription", query = "SELECT a FROM Artwork a WHERE a.description = :description"),
    @NamedQuery(name = "Artwork.findByPrice", query = "SELECT a FROM Artwork a WHERE a.price = :price"),
    @NamedQuery(name = "Artwork.findBySize", query = "SELECT a FROM Artwork a WHERE a.size = :size"),
    @NamedQuery(name = "Artwork.findByArtistId", query = "SELECT a FROM Artwork a WHERE a.artistId = :artistId"),
    @NamedQuery(name = "Artwork.findByCustomerId", query = "SELECT a FROM Artwork a WHERE a.customerId = :customerId"),
    @NamedQuery(name = "Artwork.findByUploadDate", query = "SELECT a FROM Artwork a WHERE a.uploadDate = :uploadDate"),
    @NamedQuery(name = "Artwork.findBySellDate", query = "SELECT a FROM Artwork a WHERE a.sellDate = :sellDate")})
public class Artwork implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @Column(name = "size")
    private String size;
    @Basic(optional = false)
    @Column(name = "artist_id")
    private int artistId;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "upload_date")
    @Temporal(TemporalType.DATE)
    private Date uploadDate;
    @Column(name = "sell_date")
    @Temporal(TemporalType.DATE)
    private Date sellDate;

    public Artwork() {
    }

    public Artwork(Integer id) {
        this.id = id;
    }

    public Artwork(Integer id, String title, String imageUrl, int price, String size, int artistId) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.price = price;
        this.size = size;
        this.artistId = artistId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
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
        if (!(object instanceof Artwork)) {
            return false;
        }
        Artwork other = (Artwork) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "project.last.backend.model.Artwork[ id=" + id + " ]";
    }
    
}
