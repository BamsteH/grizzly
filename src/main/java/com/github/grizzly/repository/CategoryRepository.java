package com.github.grizzly.repository;

import com.github.grizzly.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findCategoryById(long id);

    List<Category> findCategoriesByParentId(long parentId);

    List<Category> findCategoriesByParentIdIsNull();

}
