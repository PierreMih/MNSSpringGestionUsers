package fr.mns.erasmusnetwork.gestionUsers.service;

import fr.mns.erasmusnetwork.gestionUsers.model.User;
import fr.mns.erasmusnetwork.gestionUsers.repository.UserRepository;
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
    }

    @Test
    void save() {
    }

    @Test
    void getById() {
        User user = new User("laaouine@gmail.com", "4656");
        RestTemplate restTemplate = mock(RestTemplate.class);
        when(restTemplate.getForEntity("localhost:8084/users/", User.class))
                .thenReturn(new ResponseEntity<>(user, HttpStatus.OK));
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("localhost:8084/users/", User.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
    @Test
    void getByEmail() {
        User user = new User("pomme@gmail.fr", "1234");
        RestTemplate restTemplate = mock(RestTemplate.class);
        when(restTemplate.getForEntity("localhost:8084/users/getByEmail", User.class))
                .thenReturn(new ResponseEntity<>(user, HttpStatus.OK));
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("localhost:8084/users/getByEmail", User.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
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