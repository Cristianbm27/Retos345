package co.usa.alquilercomputadores.alquilercomputadores.repository.crud;

import org.springframework.data.repository.CrudRepository;

import co.usa.alquilercomputadores.alquilercomputadores.model.Category;

public interface CategoryCrudRepositorio extends  CrudRepository<Category,Integer> {
    
}
