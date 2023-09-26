package fr.mns.erasmusnetwork.gestionUsers.service;

import fr.mns.erasmusnetwork.gestionUsers.model.User;
import fr.mns.erasmusnetwork.gestionUsers.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User save(User user){
        return userRepository.findById(user.getId()).orElse(null);
    }

    public User getById(long id){
        return userRepository.findById(id).orElse(null);
    }

    public User create(String mail, String password){
        User us = new User(mail, password);
        userRepository.save(us);
        return  us;
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public User update(Long id, String email, String password){
        User us = userRepository.findById(id).orElseThrow();
        us.setEmail(email);
        us.setPassword(password);
        userRepository.save(us);
        return  us;
    }

    public User getByEmail(String email) throws EntityNotFoundException {
        User user = userRepository.findOneByEmail(email);
        if(user == null) throw new EntityNotFoundException(email + " non trouvé");
        return user;
    }

    public User enableUser(User user){
        user.setBlocked(false);
        userRepository.save(user);
        return user;
    }
    public User disableUser(User user){
        user.setBlocked(true);
        userRepository.save(user);
        return user;
    }
}
