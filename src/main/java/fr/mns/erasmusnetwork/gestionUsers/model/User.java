package fr.mns.erasmusnetwork.gestionUsers.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,unique = true,updatable = false)
    public Long id;
    @Column
    public String firstname;
    @Column
    public String lastname;
    @Column
    public Date birthdate;
    @Column
    //bloquer ou pas
    public String mail;
    @Column
    public String password;
    @Column
    public Boolean blocked;


    public User(Long id, String firstname, String lastname, Date birthdate, String mail, String password){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.mail = mail;
        this.password = password;
        this.blocked = false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate=" + birthdate +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", blocked=" + blocked +
                '}';
    }

    public User(){

    }


    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getBlocked() {
        return blocked;
    }



}
