package com.sthore.msOperador.Controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sthore.msOperador.models.Categorias;
import com.sthore.msOperador.service.CategoriaService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
 
import org.springframework.http.HttpStatus;
 

import java.util.List;

 

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
@RefreshScope
@Getter
@Setter
 
@CrossOrigin(origins = "*")
public class CategoriaController {
    @Autowired
    public  CategoriaService categoriaService;
     

     @GetMapping
    public ResponseEntity<List<Categorias>> getAllCategorias() {
        List<Categorias> categorias = categoriaService.getAllCategorias();
        return ResponseEntity.ok(categorias);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity getCategoriaById(@PathVariable Integer id) {
        Categorias categoria = categoriaService.getCategoriaById(id);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }  
         
    }

    @PostMapping
    public ResponseEntity<Categorias> createCategoria(@RequestBody Categorias categoria) {
        categoriaService.saveCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }
 
    @PutMapping("/{id}")
public ResponseEntity<Categorias> updateCategoria(@PathVariable Integer id, @RequestBody Categorias updatedCategoria) {
    Categorias existingCategoria = categoriaService.getCategoriaById(id);

    if (existingCategoria != null) {
        updatedCategoria.setId(Long.valueOf(id));  
        categoriaService.saveCategoria(updatedCategoria);
        return ResponseEntity.ok(updatedCategoria);
    } else {
        return ResponseEntity.notFound().build();
    }
}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Integer id) {
        Categorias existingCategoria = categoriaService.getCategoriaById(id);

        if (existingCategoria != null) {
            categoriaService.deleteCategoria(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

  

}
