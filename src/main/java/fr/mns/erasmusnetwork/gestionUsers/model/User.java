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
    private Long id;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private Date birthDate;
    @Column
    //bloquer ou pas
    private String mail;
    @Column
    private String password;
    @Column
    private Boolean blocked;


    public User(Long id, String firstname, String lastname, Date date, String mail, String password){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = date;
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
                ", birthDate=" + birthDate +
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

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassWord(String password) {
        this.password = password;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public String getMail() {
        return mail;
    }

    public String getPassWord() {
        return password;
    }

    public Boolean getBlocked() {
        return blocked;
    }



}
