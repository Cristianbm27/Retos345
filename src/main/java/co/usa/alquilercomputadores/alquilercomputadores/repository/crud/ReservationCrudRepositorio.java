package co.usa.alquilercomputadores.alquilercomputadores.repository.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.usa.alquilercomputadores.alquilercomputadores.model.Reservation;

public interface ReservationCrudRepositorio extends  CrudRepository<Reservation,Integer>{
   
    //JPQL
    //public String estado="completed";where e.status="+estado+"
    @Query("Select e.client, COUNT(e.client) from Reservation as e  group by e.client order by COUNT(e.client) desc")
    public List<Object[]> countTotalReservationsByClient();

    //Query methods
    public List<Reservation>findAllByStartDateAfterAndStartDateBefore(Date fechaIni, Date fechaFin);

    public List<Reservation> findAllByStatus(String estado);

}
