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

    public User create(Long id, String firstName, String lastName, Date date, String mail, String passWord){
        User us = new User(id, firstName, lastName, date, mail, passWord);
        // à vérifier
        userRepository.save(us);
        return  us;
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public User update(Long id, String firstName, String lastName, Date date, String mail, String passWord){
        User us = userRepository.findById(id).orElseThrow();
        us.setFirstName(firstName);
        us.setLastName(lastName);
        us.setBirthDate(date);
        us.setMail(mail);
        us.setPassWord(passWord);
        userRepository.save(us);
        return  us;
    }
}
