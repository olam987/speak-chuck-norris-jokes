package org.example.service;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class AudioPlayService {
    private static final Logger LOGGER = Logger.getLogger(AudioPlayService.class.getName());
    private static final int BUFFER_SIZE = 4096;
    void play(InputStream inputStream) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);

            AudioFormat audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();

            System.out.println("Playback Started.");

            byte[] bufferBytes = new byte[BUFFER_SIZE];
            int readBytes = -1;
            while ((readBytes = audioStream.read(bufferBytes)) != -1) {
                sourceDataLine.write(bufferBytes, 0, readBytes);
            }
            sourceDataLine.drain();
            sourceDataLine.close();
            audioStream.close();

            System.out.println("Playback has been finished.");

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            System.out.println("Error occured during playback process:" + ex.getMessage());
        }
    }
}
