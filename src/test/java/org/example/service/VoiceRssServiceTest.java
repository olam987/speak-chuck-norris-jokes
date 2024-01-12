package org.example.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class VoiceRssServiceTest {
    //given
    //when
    //then

    @Test
    void speakJoke() throws IOException {
        //given
        AudioPlayService audioPlayService = new AudioPlayService();
        VoiceRssService voiceRssService = new VoiceRssService(audioPlayService);

        //when
        boolean spoken = voiceRssService.speakJoke("Hello Joke");
        //then
        Assertions.assertTrue(spoken, "not spoken");
    }
}