package fr.mns.erasmusnetwork.gestionUsers.service;

import fr.mns.erasmusnetwork.gestionUsers.model.User;
import fr.mns.erasmusnetwork.gestionUsers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){

        return null;
    }

    public User save(User user){

    }

    public User getById(long id){
        return userRepository.findById(id).orElse(null);
    }
}
