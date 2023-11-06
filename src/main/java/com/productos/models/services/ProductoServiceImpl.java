package com.productos.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productos.models.dao.IProductoDAO;
import com.productos.models.documents.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoDAO productoDAO;

	@Override
	public Flux<Producto> findAll() {
		return productoDAO.findAll();
	}

	@Override
	public Mono<Producto> findById(String id) {
		return productoDAO.findById(id);
	}

	@Override
	public Mono<Producto> save(Producto producto) {
		return productoDAO.save(producto);
	}

	@Override
	public Mono<Void> delete(Producto producto) {
		return productoDAO.delete(producto);
	}

	@Override
	public Flux<Producto> findAllConNombreUpperCase() {
		return productoDAO.findAll().map(producto -> {

			producto.setNombre(producto.getNombre().toUpperCase());
			return producto;
		});

	}

}
