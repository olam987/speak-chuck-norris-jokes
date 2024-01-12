package org.example.repository;

import org.example.repository.entity.JokesEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JokesRepositoryTest {
    @Autowired
    private JokesRepository jokesRepository;

    //given
    @Test
    void saveJoke() {
        JokesEntity jokesEntity = new JokesEntity();
        //when
        JokesEntity savedJokeEntity = jokesRepository.save(jokesEntity);
        //then
        Assertions.assertNotNull(savedJokeEntity, "");
    }


}