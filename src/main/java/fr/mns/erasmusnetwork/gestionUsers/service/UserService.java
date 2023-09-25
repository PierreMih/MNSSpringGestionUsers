package fr.mns.erasmusnetwork.gestionUsers.service;

import fr.mns.erasmusnetwork.gestionUsers.model.User;
import fr.mns.erasmusnetwork.gestionUsers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User save(User user){
        return userRepository.findById(user.getId()).orElse(null);
    }

    public User getById(long id){
        return userRepository.findById(id).orElse(null);
    }

    //create, delete, update

    public User create(Long id, String firstname, String lastname, Date date, String mail, String password){
        User us = new User(id, firstname, lastname, date, mail, password);
        // à vérifier
        userRepository.save(us);
        return  us;
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public User update(Long id, String firstname, String lastname, Date date, String mail, String password){
        User us = userRepository.findById(id).orElseThrow();
        us.setFirstname(firstname);
        us.setLastname(lastname);
        us.setBirthdate(date);
        us.setMail(mail);
        us.setPassword(password);
        userRepository.save(us);
        return  us;
    }
}
