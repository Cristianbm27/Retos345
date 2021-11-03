package co.usa.alquilercomputadores.alquilercomputadores.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.alquilercomputadores.alquilercomputadores.model.Client;
import co.usa.alquilercomputadores.alquilercomputadores.repository.ClientRepositorio;

@Service
public class ClientServicio {
    @Autowired
    private ClientRepositorio clientRepositorio;

    public  List<Client> getAll(){
        return  clientRepositorio.getAll();
    }

    public Optional<Client>getClient(int id){
        return clientRepositorio.getClient(id);
    }

    public Client save(Client client){
        if (client.getIdClient()==null) {
            return clientRepositorio.save(client);
        } else {
            Optional<Client>  consulta=clientRepositorio.getClient(client.getIdClient());
            if (consulta.isEmpty()) {
                return  clientRepositorio.save(client);
            } else {
                return client;
            }
        }
    }

    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= clientRepositorio.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                clientRepositorio.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            clientRepositorio.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
