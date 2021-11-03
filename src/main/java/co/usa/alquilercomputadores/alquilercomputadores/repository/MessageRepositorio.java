package co.usa.alquilercomputadores.alquilercomputadores.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.alquilercomputadores.alquilercomputadores.model.Message;
import co.usa.alquilercomputadores.alquilercomputadores.repository.crud.MessageCrudRepositorio;

@Repository
public class MessageRepositorio {
    @Autowired
    private MessageCrudRepositorio messageCrudRepositorio;

    public List<Message> getAll(){
        return (List<Message>) messageCrudRepositorio.findAll();

    }

    public Optional<Message>getMessage(int id){
        return messageCrudRepositorio.findById(id);
    }

    public Message save(Message message){
        return messageCrudRepositorio.save(message);
    }

    public void delete(Message message){
        messageCrudRepositorio.delete(message);
    }
}
