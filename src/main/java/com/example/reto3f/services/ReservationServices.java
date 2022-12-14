package com.example.reto3f.services;

import com.example.reto3f.entities.Reservation;
import com.example.reto3f.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServices {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save (Reservation reservation){
        if(reservation.getIdReservation()==null){
            reservation.setStatus("created");
            return reservationRepository.save(reservation);
        }else {
            Optional <Reservation> e = reservationRepository.getReservation(reservation.getIdReservation());
            if(e.isPresent()){
                return reservation;
            }else{
                return reservationRepository.save(reservation);
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> r = reservationRepository.getReservation(reservation.getIdReservation());
            if(r.isPresent()){
                if(reservation.getStartDate()!=null){
                    r.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    r.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    r.get().setStatus(reservation.getStatus());
                }/*
                if(reservation.getClient()!=null){
                    r.get().setClient(reservation.getClient());
                }
                if(reservation.getCloud()!=null){
                    r.get().setCloud(reservation.getCloud());
                }*/
                reservationRepository.save(r.get());
                return r.get();
            }else {
                return reservation;
            }
        }else {
            return reservation;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservation> reservation = reservationRepository.getReservation(id);
        if (reservation.isPresent()){
            reservationRepository.delete(reservation.get());
            flag=true;
        }
        return flag;
    }
}
