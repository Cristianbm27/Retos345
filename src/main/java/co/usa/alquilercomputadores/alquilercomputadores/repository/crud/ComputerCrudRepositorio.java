package co.usa.alquilercomputadores.alquilercomputadores.repository.crud;

import org.springframework.data.repository.CrudRepository;

import co.usa.alquilercomputadores.alquilercomputadores.model.Computer;

public interface ComputerCrudRepositorio extends CrudRepository<Computer,Integer> {
    
}
