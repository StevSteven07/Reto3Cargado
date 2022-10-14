package com.example.reto3f.repository.crudRepository;

import com.example.reto3f.entities.Reservation;
import org.springframework.data.repository.CrudRepository;
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}