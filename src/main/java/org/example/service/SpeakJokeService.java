package org.example.service;

import org.example.api.ChuckNorrisJokesApiRespose;

import java.io.IOException;
import java.util.logging.Logger;

public class SpeakJokeService {
    private static final Logger LOGGER = Logger.getLogger(SpeakJokeService.class.getName());

    private final ChuckNorrisJokesService chuckNorrisJokesService;
    private final VoiceRssService voiceRssService;

    public SpeakJokeService(ChuckNorrisJokesService chuckNorrisJokesService, VoiceRssService voiceRssService) {
        this.chuckNorrisJokesService = chuckNorrisJokesService;
        this.voiceRssService = voiceRssService;
    }

    public boolean speakJoke() throws IOException {
        ChuckNorrisJokesApiRespose chuckNorrisJokesApiRespose = chuckNorrisJokesService.randomJoke();
        String joke  = chuckNorrisJokesApiRespose.getValue();

        boolean spoken = voiceRssService.speakJoke(joke);
        return spoken;
    }
}
