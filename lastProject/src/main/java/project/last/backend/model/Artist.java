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
@Table(name = "artist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artist.findAll", query = "SELECT a FROM Artist a"),
    @NamedQuery(name = "Artist.findById", query = "SELECT a FROM Artist a WHERE a.id = :id"),
    @NamedQuery(name = "Artist.findByFirstName", query = "SELECT a FROM Artist a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "Artist.findByLastName", query = "SELECT a FROM Artist a WHERE a.lastName = :lastName"),
    @NamedQuery(name = "Artist.findByEmail", query = "SELECT a FROM Artist a WHERE a.email = :email"),
    @NamedQuery(name = "Artist.findByPhoneNumber", query = "SELECT a FROM Artist a WHERE a.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Artist.findByBankCardNumber", query = "SELECT a FROM Artist a WHERE a.bankCardNumber = :bankCardNumber"),
    @NamedQuery(name = "Artist.findByNationalNumber", query = "SELECT a FROM Artist a WHERE a.nationalNumber = :nationalNumber"),
    @NamedQuery(name = "Artist.findByBirthday", query = "SELECT a FROM Artist a WHERE a.birthday = :birthday"),
    @NamedQuery(name = "Artist.findByPassword", query = "SELECT a FROM Artist a WHERE a.password = :password")})
public class Artist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "bank_card_number")
    private int bankCardNumber;
    @Basic(optional = false)
    @Column(name = "national_number")
    private int nationalNumber;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    public Artist() {
    }

    public Artist(Integer id) {
        this.id = id;
    }

    public Artist(Integer id, String firstName, String lastName, String email, String phoneNumber, int bankCardNumber, int nationalNumber, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bankCardNumber = bankCardNumber;
        this.nationalNumber = nationalNumber;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(int bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public int getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(int nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Artist)) {
            return false;
        }
        Artist other = (Artist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "project.last.backend.model.Artist[ id=" + id + " ]";
    }
    
}
