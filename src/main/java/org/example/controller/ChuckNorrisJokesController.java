package org.example.controller;

import org.example.api.ChuckNorrisJokesApiRespose;
import org.example.service.ChuckNorrisJokesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/jokes")
public class ChuckNorrisJokesController {

    private static final Logger LOGGER = Logger.getLogger(ChuckNorrisJokesController.class.getName());
    private ChuckNorrisJokesService chuckNorrisJokesService;

    public ChuckNorrisJokesController(ChuckNorrisJokesService chuckNorrisJokesService) {
        this.chuckNorrisJokesService = chuckNorrisJokesService;
    }

    @GetMapping
    public String jokeView() {
        return "jokes.html";
    }

    @PostMapping
    public String joke(ModelMap modelMap) {
        ChuckNorrisJokesApiRespose chuckNorrisJokesApiRespose = randomJoke();
        modelMap.addAttribute("joke",chuckNorrisJokesApiRespose.getValue());
        return "jokes.html";
    }

    public ChuckNorrisJokesApiRespose randomJoke() {
        ChuckNorrisJokesApiRespose chuckNorrisJokesApiRespose = chuckNorrisJokesService.randomJoke();
        return chuckNorrisJokesApiRespose;
    }
}
