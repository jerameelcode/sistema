package com.meel.sistema.resources;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meel.sistema.domain.Categoria;
import com.meel.sistema.repository.CategoriaRepository;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public CategoriaResource() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Categoria> listar() {
		Iterable<Categoria> categorias = this.categoriaRepository.findAll();
		return categorias;
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable(name = "id") Integer id) {
		Optional<Categoria> categoria = this.categoriaRepository.findById(id);
		if(!categoria.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(categoria.get());
		
	}
	
	@PostMapping(value="/")
	public ResponseEntity<Categoria> saveCategoria(@RequestBody @Valid Categoria categoria) {
		try {
			Categoria savedCategoria = this.categoriaRepository.save(categoria);
			return ResponseEntity.ok(savedCategoria);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PutMapping(value="/")
	public ResponseEntity<Categoria> update(@RequestBody Categoria categoria){
		Optional<Categoria> cat = this.categoriaRepository.findById(categoria.getId());
		if(cat.isPresent()) {
			Categoria updateCategoria = this.categoriaRepository.save(categoria);
			return ResponseEntity.ok(updateCategoria);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Categoria> delete(@PathVariable(name = "id") Integer id) {
		Optional<Categoria> categoria = this.categoriaRepository.findById(id);
		if(categoria.isPresent()) {
			this.categoriaRepository.delete(categoria.get());
			return ResponseEntity.status(HttpStatus.GONE).build();
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
