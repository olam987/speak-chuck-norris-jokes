package org.example.controller;

import org.example.service.ChuckNorrisJokesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChuckNorrisJokesControllerTest {

    @Test
    void randomJoke() {
        //given
        ChuckNorrisJokesService chuckNorrisJokesService = new ChuckNorrisJokesService(null);
        ChuckNorrisJokesController chuckNorrisJokesController = new ChuckNorrisJokesController(chuckNorrisJokesService);
        //when
        chuckNorrisJokesController.randomJoke();
        ///then
        Assertions.assertNotNull(chuckNorrisJokesController,"");
    }
}