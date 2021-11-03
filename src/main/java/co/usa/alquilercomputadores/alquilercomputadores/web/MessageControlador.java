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

import co.usa.alquilercomputadores.alquilercomputadores.model.Message;
import co.usa.alquilercomputadores.alquilercomputadores.service.MessageServicio;

@RestController
@RequestMapping("api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,
RequestMethod.PUT})
public class MessageControlador {
    @Autowired
    private MessageServicio messageServicio;

    @GetMapping("/all")
    public  List<Message>getMessages(){
        return  messageServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Message>getMessage(@PathVariable("id") int id){
        return   messageServicio.getMessage(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public  Message save(@RequestBody Message message){
        return  messageServicio.save(message);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message) {
        return messageServicio.update(message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        return messageServicio.deleteMessage(messageId);
    }
}
