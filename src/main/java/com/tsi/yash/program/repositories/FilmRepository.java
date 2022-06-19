package com.tsi.yash.program.repositories;

import com.tsi.yash.program.model.Actor;
import com.tsi.yash.program.model.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Integer> {

}
