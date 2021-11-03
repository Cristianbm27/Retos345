package co.usa.alquilercomputadores.alquilercomputadores.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.alquilercomputadores.alquilercomputadores.model.Category;
import co.usa.alquilercomputadores.alquilercomputadores.repository.CategoryRepositorio;

@Service
public class CategoryServicio {
    @Autowired
    private CategoryRepositorio categoryRepositorio;

    public  List<Category> getAll(){
        return  categoryRepositorio.getAll();
    }

    public Optional<Category>getCategory(int id){
        return categoryRepositorio.getCategory(id);
    }

    public Category save(Category category){
        if (category.getId()==null) {
            return categoryRepositorio.save(category);
        } else {
            Optional<Category>  consulta=categoryRepositorio.getCategory(category.getId());
            if (consulta.isEmpty()) {
                return  categoryRepositorio.save(category);
            } else {
                return category;
            }
        }
    }

    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> e=categoryRepositorio.getCategory(category.getId());
            if(!e.isEmpty()){
                if(category.getName()!=null){
                    e.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    e.get().setDescription(category.getDescription());
                }
                return categoryRepositorio.save(e.get());
            }
        }
        return category;
    }


    public boolean deleteCategory(int categoryId) {
        Boolean aBoolean = getCategory(categoryId).map(category -> {
            categoryRepositorio.delete(category);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
