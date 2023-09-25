package fr.mns.erasmusnetwork.gestionUsers.service;

import fr.mns.erasmusnetwork.gestionUsers.entities.User;
import fr.mns.erasmusnetwork.gestionUsers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){

    }

    public User save(User user){

    }

    public User getById(Lond id){
        return userRepository.findById(id).;
    }
}
