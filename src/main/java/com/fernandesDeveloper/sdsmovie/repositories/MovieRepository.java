package com.fernandesDeveloper.sdsmovie.repositories;

import com.fernandesDeveloper.sdsmovie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
