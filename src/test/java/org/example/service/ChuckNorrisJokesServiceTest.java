package org.example.service;

import org.example.api.ChuckNorrisJokesApiRespose;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ChuckNorrisJokesServiceTest {
    //given
    //when
    //then

    @Test
    void run() throws IOException {
        //given
        ChuckNorrisJokesService chuckNorrisJokesService = new ChuckNorrisJokesService(null);
        String url = "https://api.chucknorris.io/jokes/random";

        //when
        String response = chuckNorrisJokesService.getResponse(url);
        //then
        Assertions.assertNotNull(response,"");
    }

    @Test
    void convert() {
        //given
        ChuckNorrisJokesService chuckNorrisJokesService = new ChuckNorrisJokesService(null);

        //when
        ChuckNorrisJokesApiRespose chuckNorrisJokesApiRespose = chuckNorrisJokesService.convert("{\n" +
                "\"icon_url\" : \"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\n" +
                "\"id\" : \"kHZY5TcPSiCTfEQLjw1muQ\",\n" +
                "\"url\" : \"\",\n" +
                "\"value\" : \"Wilt Chamberlain claimed to have slept with 20,000 women in his life, or only 1.8 billion less than Chuck Norris.\"\n" +
                "}");
        //then
        Assertions.assertNotNull(chuckNorrisJokesApiRespose,"");
    }

    @Test
    void randomJoke() {
        //given
        ChuckNorrisJokesService chuckNorrisJokesService = new ChuckNorrisJokesService(null);
        //when
        ChuckNorrisJokesApiRespose chuckNorrisJokesApiRespose = chuckNorrisJokesService.randomJoke();
        //then
        Assertions.assertNotNull(chuckNorrisJokesApiRespose,"");
    }
}