package com.fernandesDeveloper.sdsmovie.repositories;

import com.fernandesDeveloper.sdsmovie.entities.Score;
import com.fernandesDeveloper.sdsmovie.entities.ScorePK;
import com.fernandesDeveloper.sdsmovie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
