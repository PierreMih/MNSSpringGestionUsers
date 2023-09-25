package fr.mns.erasmusnetwork.gestionUsers.controller;

import fr.mns.erasmusnetwork.gestionUsers.model.User;
import fr.mns.erasmusnetwork.gestionUsers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    // à repasser dessus aprés
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id){
        //TODO
        return ResponseEntity.ok(userService.getById(id));
        //return null;
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        //userService.delete(id);
        User us = userService.getById(id);
        userService.delete(us);
    }

    @PostMapping("/")
    public ResponseEntity<User> create(Long id, String firstName, String lastName, Date date, String mail, String passWord){
        return  ResponseEntity.ok(userService.create(id, firstName, lastName, date, mail, passWord));
    }






}
