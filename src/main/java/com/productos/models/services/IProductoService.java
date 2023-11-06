package com.productos.models.services;

import com.productos.models.documents.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IProductoService {

	public Flux<Producto> findAll();

	public Flux<Producto> findAllConNombreUpperCase();
	
	public Mono<Producto> findById(String id);
	
	public Mono<Producto> save(Producto producto);
	
	public Mono<Void> delete(Producto producto);
	
	
}
