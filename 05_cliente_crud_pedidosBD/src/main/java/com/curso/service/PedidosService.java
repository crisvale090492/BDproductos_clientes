package com.curso.service;

import java.util.List;


import com.curso.model.Pedido;

public interface PedidosService {
	
	List<Pedido> pedidos();
	Pedido buscarPedido(int idPedido);
	List<Pedido> nuevoPedido(Pedido pedido);
	void actualizarPedido(Pedido pedido);
	List<Pedido> eliminarPedido(int idPedido);

}
