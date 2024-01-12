package org.example;

import org.example.api.ChuckNorrisJokesApiRespose;
import org.example.controller.ChuckNorrisJokesController;
import org.example.controller.VoiceRssController;
import org.example.service.AudioPlayService;
import org.example.service.ChuckNorrisJokesService;
import org.example.service.VoiceRssService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//ChucknNorrisAplication
//        ChuckNorrisJokesService chuckNorrisJokesService = new ChuckNorrisJokesService();
//        ChuckNorrisJokesController chuckNorrisJokesController = new ChuckNorrisJokesController(chuckNorrisJokesService);
//        ChuckNorrisJokesApiRespose chuckNorrisJokesApiRespose = chuckNorrisJokesController.randomJoke();
//        String joke = chuckNorrisJokesApiRespose.getValue();
        AudioPlayService audioPlayService = new AudioPlayService();
        VoiceRssService voiceRssService = new VoiceRssService(audioPlayService);
        VoiceRssController voiceRssController = new VoiceRssController(voiceRssService);
        boolean played = voiceRssController.play("Hello Java");
    }
}