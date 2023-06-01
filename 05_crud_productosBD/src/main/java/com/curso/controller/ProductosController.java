package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Producto;
import com.curso.service.ProductosService;

@RestController
public class ProductosController {
	
	@Autowired
	ProductosService service;
	
	//http://localhost:8080/productos
	@GetMapping(value="productos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> productos() {
		return service.productos();
	}
	//http://localhost:8080/producto/1
	@GetMapping(value="producto/{codigoproducto}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Producto buscarProducto(@PathVariable int codigoproducto) {
		return service.buscarProducto(codigoproducto);
	}
	//http://localhost:8080/producto
	@PostMapping(value="producto", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> nuevoProducto(@RequestBody Producto producto) {
		service.nuevoProducto(producto);
		return service.productos();
	}
	//http://localhost:8080/producto
	@PutMapping(value="producto/{codigoproducto}/{unidades}", produces=MediaType.APPLICATION_JSON_VALUE)
	void actualizarProducto(@PathVariable int codigoproducto,@PathVariable int unidades) {
		service.actualizarProducto(codigoproducto,unidades);
	}
	//http://localhost:8080/curso/1
	@DeleteMapping(value="producto/{codigoproducto}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> eliminarProducto(@PathVariable int codigoproducto) {
		service.eliminarProducto(codigoproducto);
		return service.productos();
	}

}
