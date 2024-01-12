package org.example.controller;

import org.example.api.ChuckNorrisJokesApiRespose;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChuckNorrisJokesControllerSpringTest {
    @Autowired
    ChuckNorrisJokesController chuckNorrisJokesController;

    @Test
    void randomJoke() {
        //given
        //when
        ChuckNorrisJokesApiRespose chuckNorrisJokesApiRespose = chuckNorrisJokesController.randomJoke();
        //then
        Assertions.assertNotNull(chuckNorrisJokesController,"");
    }
}