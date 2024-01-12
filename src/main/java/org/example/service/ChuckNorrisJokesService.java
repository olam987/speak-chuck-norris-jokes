package org.example.service;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.example.api.ChuckNorrisJokesApiRespose;
import org.example.repository.JokesRepository;
import org.example.repository.entity.JokesEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ChuckNorrisJokesService {
    private static final Logger LOGGER = Logger.getLogger(ChuckNorrisJokesService.class.getName());
    private static final String API_URL = "https://api.chucknorris.io/jokes/random";
    private final JokesRepository jokesRepository;
    private OkHttpClient client = new OkHttpClient();

    public ChuckNorrisJokesService(JokesRepository jokesRepository) {
        this.jokesRepository = jokesRepository;
    }

    public ChuckNorrisJokesApiRespose randomJoke(){
        try {
            String responseBody = getResponse(API_URL);
            ChuckNorrisJokesApiRespose chuckNorrisJokesApiRespose = convert(responseBody);
            String joke = chuckNorrisJokesApiRespose.getValue();
            JokesEntity jokeEntity = new JokesEntity();
            jokeEntity.setJoke(joke);
            jokesRepository.save(jokeEntity);
            return chuckNorrisJokesApiRespose;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Unable to connect with external API");
        }
        return null;
    }

    public String getResponse(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String body =  response.body().string();
            LOGGER.info("run " + body);
            return body;
        }
    }

    public ChuckNorrisJokesApiRespose convert (String body) {
        Gson gson = new Gson();
        ChuckNorrisJokesApiRespose chuckNorrisJokesApiRespose = gson.fromJson(body, ChuckNorrisJokesApiRespose.class);
        return chuckNorrisJokesApiRespose;
    }
}
