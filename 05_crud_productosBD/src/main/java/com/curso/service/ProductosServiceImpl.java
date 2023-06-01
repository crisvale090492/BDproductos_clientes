package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.ProductosDao;
import com.curso.model.Producto;

@Service
public class ProductosServiceImpl implements ProductosService {
	
	@Autowired
	ProductosDao dao;

	@Override
	public List<Producto> productos() {
		return dao.findAll();
	}

	@Override
	public Producto buscarProducto(int codigoProducto) {
		return dao.findById(codigoProducto).orElse(null);
	}

	@Override
	public List<Producto> nuevoProducto(Producto producto) {
		dao.save(producto);
		return dao.findAll();
	}

	@Override
	public void actualizarProducto(int  codigoProducto, int unidades) {
		Producto producto = dao.findById(codigoProducto).orElse(null);
		producto.setStock(producto.getStock()-unidades);
		dao.save(producto);
	
	}

	@Override
	public List<Producto> eliminarProducto(int codigoProducto) {
		dao.deleteById(codigoProducto);
		return dao.findAll();
	}

}
