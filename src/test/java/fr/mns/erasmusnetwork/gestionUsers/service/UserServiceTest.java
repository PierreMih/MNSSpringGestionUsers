package fr.mns.erasmusnetwork.gestionUsers.service;

import fr.mns.erasmusnetwork.gestionUsers.model.User;
import fr.mns.erasmusnetwork.gestionUsers.repository.UserRepository;
import org.hibernate.mapping.Selectable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.Console;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private RestTemplate restTemplate;

    UserRepository userRepository;

    @InjectMocks
    private UserService userService = new UserService(userRepository);

    @Test
    void getAll() {
        User us1 = new User("laaouine@locakim.com", "0263");
        User us2 = new User("pomme@gmail.fr","0605");
        User us3 = new User("selim@icloud.fr","5896547");

        RestTemplate restTemplate = mock(RestTemplate.class);
        when(restTemplate.getForEntity("localhost:8084/users/", User.class))
                .thenReturn(new ResponseEntity<>(us1, HttpStatus.OK));
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("localhost:8084/users/", User.class);


        //....



    }

    @Test
    void save() {
        User user = new User("laaouine@gmail.com", "4656");
        RestTemplate restTemplate = mock(RestTemplate.class);
        when(restTemplate.getForEntity("localhost:8084/users/", User.class))
                .thenReturn(new ResponseEntity<>(user, HttpStatus.OK));
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("localhost:8084/users/", User.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void getById() {
        User user = new User("laaouine@gmail.com", "4656");
        RestTemplate restTemplate = mock(RestTemplate.class);
        when(restTemplate.getForEntity("localhost:8084/users/", User.class))
                .thenReturn(new ResponseEntity<>(user, HttpStatus.OK));
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("localhost:8084/users/", User.class);
        User responseBody = responseEntity.getBody();

        assertEquals(user.getId(), responseBody.getId());
        System.out.println(user.getPassword()+" et : "+responseBody.getPassword());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user.getId(), responseBody.getId());
    }
    @Test
    void getByEmail() {
        User user = new User("pomme@gmail.fr", "1234");
        RestTemplate restTemplate = mock(RestTemplate.class);
        when(restTemplate.getForEntity("localhost:8084/users/getByEmail", User.class))
                .thenReturn(new ResponseEntity<>(user, HttpStatus.OK));
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("localhost:8084/users/getByEmail", User.class);

        //Les test assertions
        User responseBody = responseEntity.getBody();
        System.out.println(user.getEmail()+" et : "+responseBody.getEmail());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user.getEmail(), responseBody.getEmail());
    }

    @Test
    void create() {
        RestTemplate restTemplate = mock(RestTemplate.class);
        User expectedUser = new User("laaouine@localim.com", "2569");
        when(restTemplate.getForEntity("http://localhost:8084/users/", User.class))
                .thenReturn(new ResponseEntity<>(expectedUser, HttpStatus.OK));
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://localhost:8084/users/", User.class);
        User responseBody = responseEntity.getBody();

        assertNotNull(responseBody);
        assertTrue(responseBody instanceof User);

        assertEquals("laaouine@localim.com", responseBody.getEmail());
        assertEquals("2569", responseBody.getPassword());
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }



    @Test
    void enableUser() {
    }

    @Test
    void disableUser() {
    }
}