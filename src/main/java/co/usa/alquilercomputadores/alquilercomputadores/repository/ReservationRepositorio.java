package co.usa.alquilercomputadores.alquilercomputadores.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.alquilercomputadores.alquilercomputadores.model.Client;
import co.usa.alquilercomputadores.alquilercomputadores.model.Reservation;
import co.usa.alquilercomputadores.alquilercomputadores.model.Reporte.ContReservas;
import co.usa.alquilercomputadores.alquilercomputadores.repository.crud.ReservationCrudRepositorio;

@Repository
public class ReservationRepositorio {
    @Autowired
    private ReservationCrudRepositorio reservationCrudRepositorio;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepositorio.findAll();

    }

    public Optional<Reservation>getReservation(int id){
        return reservationCrudRepositorio.findById(id);
    }

    public Reservation save(Reservation reservation){
        return reservationCrudRepositorio.save(reservation);
    }

    public void delete(Reservation reservation){
        reservationCrudRepositorio.delete(reservation);
    }

    public List<Reservation> getReservacionporClientes(String estado){
        return reservationCrudRepositorio.findAllByStatus(estado);
    }

    public List<Reservation> getReservacionFechas(Date fechaIni, Date fechaFin){
        return reservationCrudRepositorio.findAllByStartDateAfterAndStartDateBefore(fechaIni, fechaFin);
    }

    public List<ContReservas> getTopClientes(){
        List<ContReservas> res= new ArrayList<>();
        
        List<Object[]> reporte=reservationCrudRepositorio.countTotalReservationsByClient();

        for (int i = 0; i < reporte.size(); i++) {
            res.add(new ContReservas((Long) reporte.get(i)[1],(Client) reporte.get(i)[0]));
        }

        return res;
    }
}
