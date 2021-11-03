package co.usa.alquilercomputadores.alquilercomputadores.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.alquilercomputadores.alquilercomputadores.model.Computer;
import co.usa.alquilercomputadores.alquilercomputadores.repository.crud.ComputerCrudRepositorio;

@Repository
public class ComputerRepositorio {
    
    @Autowired
    private ComputerCrudRepositorio computerCrudRepositorio;

    public List<Computer> getAll(){
        return (List<Computer>) computerCrudRepositorio.findAll();

    }

    public Optional<Computer>getComputer(int id){
        return computerCrudRepositorio.findById(id);
    }

    public Computer save(Computer computer){
        return computerCrudRepositorio.save(computer);
    }

    public void delete(Computer computer){
        computerCrudRepositorio.delete(computer);
    }
}
