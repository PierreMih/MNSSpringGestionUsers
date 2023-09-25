package fr.mns.erasmusnetwork.gestionUsers.model;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;


public class User implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    //bloquer ou pas
    private String mail;
    private String passWord;
    private Boolean blocked;


    public User(Long id, String firstName, String lastName, Date date, String mail, String passWord){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = date;
        this.mail = mail;
        this.passWord = passWord;
        this.blocked = false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", mail='" + mail + '\'' +
                ", passWord='" + passWord + '\'' +
                ", blocked=" + blocked +
                '}';
    }

    public User(){

    }


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public String getMail() {
        return mail;
    }

    public String getPassWord() {
        return passWord;
    }

    public Boolean getBlocked() {
        return blocked;
    }



}
