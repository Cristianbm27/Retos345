package co.usa.alquilercomputadores.alquilercomputadores.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.alquilercomputadores.alquilercomputadores.model.Reservation;
import co.usa.alquilercomputadores.alquilercomputadores.model.Reporte.ContReservas;
import co.usa.alquilercomputadores.alquilercomputadores.model.Reporte.ContStatusReservas;
import co.usa.alquilercomputadores.alquilercomputadores.repository.ReservationRepositorio;

@Service
public class ReservationServicio {
    @Autowired
    private ReservationRepositorio reservationRepositorio;

    public  List<Reservation> getAll(){
        return  reservationRepositorio.getAll();
    }

    public Optional<Reservation>getReservation(int id){
        return reservationRepositorio.getReservation(id);
    }

    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation()==null) {
            return reservationRepositorio.save(reservation);
        } else {
            Optional<Reservation>  consulta=reservationRepositorio.getReservation(reservation.getIdReservation());
            if (consulta.isEmpty()) {
                return  reservationRepositorio.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= reservationRepositorio.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                reservationRepositorio.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            reservationRepositorio.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<ContReservas> getTopClientes(){
        return reservationRepositorio.getTopClientes();
    }

    public ContStatusReservas getReporteReservas(){
        List<Reservation> Completado=reservationRepositorio.getReservacionporClientes("completed");
        List<Reservation> Cancelado=reservationRepositorio.getReservacionporClientes("cancelled");

        ContStatusReservas  reportEstado= new ContStatusReservas(Completado.size(), Cancelado.size());
        return  reportEstado;
    }

    public List<Reservation> getReservacionFechas(String fecha1, String fecha2){
        SimpleDateFormat    formato=new SimpleDateFormat("yyyy-MM-dd");
        Date  fechaIni= new Date();
        Date  fechaFin=new Date();

        try {
            fechaIni=formato.parse(fecha1);
            fechaFin=formato.parse(fecha2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (fechaIni.before(fechaFin)) {
            return  reservationRepositorio.getReservacionFechas(fechaIni, fechaFin);
        } else {
            return new ArrayList<>();
        }
    }
}
