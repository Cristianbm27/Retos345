package co.usa.alquilercomputadores.alquilercomputadores.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.alquilercomputadores.alquilercomputadores.model.Computer;
import co.usa.alquilercomputadores.alquilercomputadores.repository.ComputerRepositorio;




@Service
public class ComputerServicio {
    @Autowired
    private ComputerRepositorio computerRepositorio;

    public  List<Computer> getAll(){
        return  computerRepositorio.getAll();
    }

    public Optional<Computer>getComputer(int id){
        return computerRepositorio.getComputer(id);
    }

    public Computer save(Computer computer){
        if (computer.getId()==null) {
            return computerRepositorio.save(computer);
        } else {
            Optional<Computer>  consulta=computerRepositorio.getComputer(computer.getId());
            if (consulta.isEmpty()) {
                return  computerRepositorio.save(computer);
            } else {
                return computer;
            }
        }
    }

    public Computer update(Computer computer){
        if(computer.getId()!=null){
            Optional<Computer> e=computerRepositorio.getComputer(computer.getId());
            if(!e.isEmpty()){
                if(computer.getName()!=null){
                    e.get().setName(computer.getName());
                }
                if(computer.getBrand()!=null){
                    e.get().setBrand(computer.getBrand());
                }
                if(computer.getYear()!=null){
                    e.get().setYear(computer.getYear());
                }
                if(computer.getDescription()!=null){
                    e.get().setDescription(computer.getDescription());
                }
                if(computer.getCategory()!=null){
                    e.get().setCategory(computer.getCategory());
                }
                computerRepositorio.save(e.get());
                return e.get();
            }else{
                return computer;
            }
        }else{
            return computer;
        }
    }


    public boolean deleteComputer(int computerId) {
        Boolean aBoolean = getComputer(computerId).map(computer -> {
            computerRepositorio.delete(computer);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
