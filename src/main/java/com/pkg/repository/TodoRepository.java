package com.pkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pkg.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
