package co.usa.alquilercomputadores.alquilercomputadores.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.alquilercomputadores.alquilercomputadores.model.Reservation;
import co.usa.alquilercomputadores.alquilercomputadores.model.Reporte.ContReservas;
import co.usa.alquilercomputadores.alquilercomputadores.model.Reporte.ContStatusReservas;
import co.usa.alquilercomputadores.alquilercomputadores.service.ReservationServicio;

@RestController
@RequestMapping("api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,
RequestMethod.PUT})
public class ReservationControlador {
    @Autowired
    private ReservationServicio reservationServicio;

    @GetMapping("/all")
    public  List<Reservation>getReservation(){
        return  reservationServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation>getReservation(@PathVariable("id") int id){
        return   reservationServicio.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public  Reservation save(@RequestBody Reservation reservation){
        return  reservationServicio.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationServicio.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return reservationServicio.deleteReservation(reservationId);
    }

    @GetMapping("/report-status")
    public ContStatusReservas getReporteEstados(){
        return  reservationServicio.getReporteReservas();
    }

    @GetMapping("/report-clients")
    public  List<ContReservas> getTopClientes(){
        return reservationServicio.getTopClientes();
    }

    @GetMapping("/report-dates/{fechaIni}/{fechaFin}")
    public  List<Reservation> getRervacionFechas(@PathVariable("fechaIni") String fecha1,@PathVariable("fechaFin") String fecha2){
        return reservationServicio.getReservacionFechas(fecha1, fecha2);
    }
}
