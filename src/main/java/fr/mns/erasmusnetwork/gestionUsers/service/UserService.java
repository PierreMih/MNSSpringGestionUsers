package fr.mns.erasmusnetwork.gestionUsers.service;

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
