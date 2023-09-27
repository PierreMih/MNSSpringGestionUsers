package fr.mns.erasmusnetwork.gestionUsers.controller;

import fr.mns.erasmusnetwork.gestionUsers.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getAll() {


    }

    @Test
    void getById() {
        RequestBuilder request = MockMvcRequestBuilders.get("/id");
        //MvcResult result = mvc.perform(request).andReturn();
    }

    @Test
    void delete() {
    }

    @Test
    void create() {
    }

    @Test
    void getByEmail() {
    }

    @Test
    void enableUser() {
    }

    @Test
    void disableUser() {
    }
}