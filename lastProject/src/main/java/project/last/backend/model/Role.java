package project.last.backend.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String ADMIN = "ADMIN";
    public static final String ARTIST = "ARTIST";
    public static final String CUSTOMER = "CUSTOMER";
    
    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    public static String getARTIST() {
        return ARTIST;
    }

    public static String getCUSTOMER() {
        return CUSTOMER;
    }
 
    private String name;
    
    public String getName() {
        return name;
    }

    public Role(String name, Set<UserEntity> users) {
        this.name = name;
        this.users = users;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static String getADMIN() {
        return ADMIN;
    }

    public int getRoleId() {
        return roleId;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }
 
 
    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users;

    public Role() {
    }
 
    public Role(String name) {
        this.name = name;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(name, ((Role) obj).getName());
    }
 
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Role [name=").append(name).append("]").append("[id=").append(roleId).append("]");
        return builder.toString();
    }


    
}
