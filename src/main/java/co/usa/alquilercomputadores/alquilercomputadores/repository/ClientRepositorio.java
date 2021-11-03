package co.usa.alquilercomputadores.alquilercomputadores.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.alquilercomputadores.alquilercomputadores.model.Client;
import co.usa.alquilercomputadores.alquilercomputadores.repository.crud.ClientCrudRepositorio;

@Repository
public class ClientRepositorio {
    @Autowired
    private ClientCrudRepositorio clientCrudRepositorio;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepositorio.findAll();

    }

    public Optional<Client>getClient(int id){
        return clientCrudRepositorio.findById(id);
    }

    public Client save(Client client){
        return clientCrudRepositorio.save(client);
    }

    public void delete(Client client){
        clientCrudRepositorio.delete(client);
    }
}
