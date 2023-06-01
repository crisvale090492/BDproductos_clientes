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

import com.curso.model.Pedido;
import com.curso.service.PedidosService;



@RestController
public class PedidosController {
	
	@Autowired
	PedidosService service;
	
	//http://localhost:9090/pedidos
	@GetMapping(value="pedidos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> pedidos() {
		return service.pedidos();
	}
	//http://localhost:9090/pedido/1
	@GetMapping(value="pedido/{idpedido}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Pedido buscarPedido(@PathVariable int idpedido) {
		return service.buscarPedido(idpedido);
	}
	//http://localhost:9090/pedido
	@PostMapping(value="pedido", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> nuevoPedido(@RequestBody Pedido pedido) {
		service.nuevoPedido(pedido);
		return service.pedidos();
	}
	//http://localhost:9090/pedido
	@PutMapping(value="pedido", produces=MediaType.APPLICATION_JSON_VALUE)
	void actualizarProducto(@RequestBody Pedido pedido) {
		service.actualizarPedido(pedido);
	}
	//http://localhost:9090/pedido/1
	@DeleteMapping(value="pedido/{idpedido}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> eliminarPedido(@PathVariable int idpedido) {
		service.eliminarPedido(idpedido);
		return service.pedidos();
	}

}

