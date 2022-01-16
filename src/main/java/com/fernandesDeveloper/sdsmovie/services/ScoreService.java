package com.fernandesDeveloper.sdsmovie.services;

import com.fernandesDeveloper.sdsmovie.dto.MovieDTO;
import com.fernandesDeveloper.sdsmovie.dto.ScoreDTO;
import com.fernandesDeveloper.sdsmovie.entities.Movie;
import com.fernandesDeveloper.sdsmovie.entities.Score;
import com.fernandesDeveloper.sdsmovie.entities.User;
import com.fernandesDeveloper.sdsmovie.repositories.MovieRepository;
import com.fernandesDeveloper.sdsmovie.repositories.ScoreRepository;
import com.fernandesDeveloper.sdsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO scoreDTO){

        User user = userRepository.findByEmail(scoreDTO.getEmail());
        if(user == null){
            user = userRepository.saveAndFlush(new User(scoreDTO.getEmail()));
        }

        Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();

        Score score =  new Score();
        score.setUser(user);
        score.setMovie(movie);
        score.setValue(scoreDTO.getScore());
        scoreRepository.save(score);

        movie = movieRepository.findById(scoreDTO.getMovieId()).get();

        double sum = 0.0;
        for(Score s : movie.getScores()){
            sum = sum + s.getValue();
        }
        double media = sum / movie.getScores().size();
        movie.setScore(media);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.saveAndFlush(movie);


        return new MovieDTO(movie);
    }
}
