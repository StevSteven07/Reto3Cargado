package com.example.reto3f.repository.crudRepository;

import com.example.reto3f.entities.Message;
import org.springframework.data.repository.CrudRepository;
public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}