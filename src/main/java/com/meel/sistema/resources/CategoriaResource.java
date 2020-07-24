package com.meel.sistema.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meel.sistema.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	
	public CategoriaResource() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		Categoria informatica = new Categoria(1, "Informática");
		Categoria escritorio = new Categoria(1, "Escritório");
		return Arrays.asList(informatica, escritorio);
	}

}
