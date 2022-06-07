package com.tsi.yash.program.repositories;

import com.tsi.yash.program.model.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Integer> {
}
