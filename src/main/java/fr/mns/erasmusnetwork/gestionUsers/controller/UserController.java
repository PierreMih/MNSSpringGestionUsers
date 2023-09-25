package fr.mns.erasmusnetwork.gestionUsers.controller;

import fr.mns.erasmusnetwork.gestionUsers.dto.CreateUserRequest;
import fr.mns.erasmusnetwork.gestionUsers.dto.GetUserByEmailRequest;
import fr.mns.erasmusnetwork.gestionUsers.model.User;
import fr.mns.erasmusnetwork.gestionUsers.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

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
    public ResponseEntity<User> create(@RequestBody @Valid CreateUserRequest request){
        return  ResponseEntity.ok(userService.create(request.firstname, request.lastname, request.birthdate, request.email, request.password));
    }

    @GetMapping(value = "/getByEmail")
    public ResponseEntity<User> getByEmail(@RequestBody @Valid GetUserByEmailRequest request){
        User user;

        try {
            user = userService.getByEmail(request.email);
        } catch (EntityNotFoundException e) {
//            return ResponseEntity.notFound().build(); //Pourquoi ça renvoie rien??
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        return ResponseEntity.ok(user);
    }

    @PutMapping(value = "/{id}/enable")
    public ResponseEntity<User> enableUser(@PathVariable("id") Long id){
        User user = userService.getById(id);
        if(user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
        user = userService.enableUser(user);
        return ResponseEntity.ok(user);
    }
    @PutMapping(value = "/{id}/disable")
    public ResponseEntity<User> disableUser(@PathVariable("id") Long id){
        User user = userService.getById(id);
        if(user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
        user = userService.disableUser(user);
        return ResponseEntity.ok(user);
    }
}
