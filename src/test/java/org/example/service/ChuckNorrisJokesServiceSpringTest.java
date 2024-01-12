package org.example.service;

import org.example.api.ChuckNorrisJokesApiRespose;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ChuckNorrisJokesServiceSpringTest {
    @Autowired
    private ChuckNorrisJokesService chuckNorrisJokesService;

    @Test
    void randomJoke(){
        //given
        //when
        ChuckNorrisJokesApiRespose chuckNorrisJokesApiRespose = chuckNorrisJokesService.randomJoke();
        //then
        Assertions.assertNotNull(chuckNorrisJokesApiRespose,"");
    }

    @Test
    void getResponse() throws IOException {
        //given
        String url = "https://api.chucknorris.io/jokes/random";
        //when
        String response = chuckNorrisJokesService.getResponse(url);
        //then
        Assertions.assertNotNull(response,"");
    }
}