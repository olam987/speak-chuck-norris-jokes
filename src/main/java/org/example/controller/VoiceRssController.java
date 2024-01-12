package org.example.controller;

import org.example.service.VoiceRssService;

import java.io.IOException;
import java.util.logging.Logger;

public class VoiceRssController {
    private static final Logger LOGGER = Logger.getLogger(VoiceRssController.class.getName());

    private final VoiceRssService voiceRssService;

    public VoiceRssController(VoiceRssService voiceRssService) {
        this.voiceRssService = voiceRssService;
    }

    public boolean play(String textToVoice) throws IOException {
        boolean spoken = voiceRssService.speakJoke(textToVoice);
        return spoken;
    }
}
