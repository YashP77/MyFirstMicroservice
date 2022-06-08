package com.tsi.yash.program.repositories;

import com.tsi.yash.program.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
