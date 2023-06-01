package com.curso.service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.dao.PedidosDao;
import com.curso.model.AuxiliarProducto;
import com.curso.model.Pedido;

@Service
public class PedidosServiceImpl implements PedidosService {
	
	@Autowired
	RestTemplate template;

	private String url = "http://localhost:8080/";
	
	@Autowired
	PedidosDao dao;

	@Override
	public List<Pedido> pedidos() {
		return dao.findAll();
	}

	@Override
	public Pedido buscarPedido(int idPedido) {
		return dao.findById(idPedido).orElse(null);
	}

	@Override
	public List<Pedido> nuevoPedido(Pedido pedido) {
		
		AuxiliarProducto producto = template.getForObject(url + "producto/"+ pedido.getCodigoProducto(), AuxiliarProducto.class);
		pedido.setTotal(obtenerTotal(pedido,producto.getPrecioUnitario()));
		Date date = Date.from(Instant.now());
		pedido.setFechaPedido(date);
		dao.save(pedido);
		template.put(url+"producto/{codigoproducto}/{unidades}",null,pedido.getCodigoProducto(),pedido.getUnidades());
		return dao.findAll();
	}

	@Override
	public void actualizarPedido(Pedido pedido) {
		dao.save(pedido);

	}

	@Override
	public List<Pedido> eliminarPedido(int idPedido) {
		dao.deleteById(idPedido);
		return dao.findAll();
	}
	
	public double obtenerTotal(Pedido pedido, double precioUnitario) {
		pedido.setTotal(pedido.getUnidades()*precioUnitario);
		return pedido.getTotal();
	}

}
