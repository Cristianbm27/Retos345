package co.usa.alquilercomputadores.alquilercomputadores.repository.crud;

import org.springframework.data.repository.CrudRepository;

import co.usa.alquilercomputadores.alquilercomputadores.model.Message;

public interface MessageCrudRepositorio extends  CrudRepository<Message,Integer>{
    
}
