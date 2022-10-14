package com.example.reto3f.repository.crudRepository;

import com.example.reto3f.entities.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository<Score, Integer> {
}