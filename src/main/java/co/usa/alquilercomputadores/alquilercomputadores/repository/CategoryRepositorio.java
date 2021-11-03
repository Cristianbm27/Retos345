package co.usa.alquilercomputadores.alquilercomputadores.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.alquilercomputadores.alquilercomputadores.model.Category;
import co.usa.alquilercomputadores.alquilercomputadores.repository.crud.CategoryCrudRepositorio;

@Repository
public class CategoryRepositorio {
    @Autowired
    private CategoryCrudRepositorio categoryCrudRepositorio;

    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepositorio.findAll();

    }

    public Optional<Category>getCategory(int id){
        return categoryCrudRepositorio.findById(id);
    }

    public Category save(Category category){
        return categoryCrudRepositorio.save(category);
    }

    public void delete(Category category){
        categoryCrudRepositorio.delete(category);
    }
}
