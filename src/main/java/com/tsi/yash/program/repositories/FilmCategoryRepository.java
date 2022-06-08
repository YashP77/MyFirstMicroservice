package com.tsi.yash.program.repositories;

import com.tsi.yash.program.model.FilmCategory;
import org.springframework.data.repository.CrudRepository;

public interface FilmCategoryRepository extends CrudRepository<FilmCategory, Integer> {
}
