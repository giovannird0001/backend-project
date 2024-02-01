package com.sthore.msOperador.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sthore.msOperador.models.Categorias;
import com.sthore.msOperador.repository.CategoriasRepository;

@Service
public class CategoriaService {
    @Autowired
    private  CategoriasRepository categoriasRepository;
   

    @Autowired
    public CategoriaService(CategoriasRepository CategoriaRepository) {
        this.categoriasRepository = CategoriaRepository;
    }

    public List<Categorias> getAllCategorias() {
        return categoriasRepository.findAll();
    }

    public Categorias getCategoriaById(Integer id) {
        return categoriasRepository.findById(id).orElse(null);
    }

    public void saveCategoria(Categorias Categoria) {
        categoriasRepository.save(Categoria);
    }

    public void deleteCategoria(Integer id) {
        categoriasRepository.deleteById(id);
    }
       public void saveSampleCategorias(List<Categorias> sampleCategorias) {
        for (Categorias categorias : sampleCategorias) {
          
            categoriasRepository.save(categorias);
        }
    }  
}