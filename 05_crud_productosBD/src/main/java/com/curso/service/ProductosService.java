package com.curso.service;

import java.util.List;


import com.curso.model.Producto;

public interface ProductosService {
	
	List<Producto> productos();
	Producto buscarProducto(int codigoProducto);
	List<Producto> nuevoProducto(Producto producto);
	void actualizarProducto(int codigoProducto, int unidades);
	List<Producto> eliminarProducto(int codigoProducto);

}
