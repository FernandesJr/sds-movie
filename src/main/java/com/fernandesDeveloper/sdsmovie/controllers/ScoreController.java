package com.fernandesDeveloper.sdsmovie.controllers;

import com.fernandesDeveloper.sdsmovie.dto.MovieDTO;
import com.fernandesDeveloper.sdsmovie.dto.ScoreDTO;
import com.fernandesDeveloper.sdsmovie.services.MovieService;
import com.fernandesDeveloper.sdsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController //Quando é uma construção de API usa-se o Rest que é diferente do esteriotipo Controller
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private ScoreService service;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO dto){ //Capturando do body da requisição
        return service.saveScore(dto);
    }
}
