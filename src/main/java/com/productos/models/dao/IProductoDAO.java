package com.productos.models.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.productos.models.documents.Producto;

public interface IProductoDAO extends ReactiveMongoRepository<Producto, String> {

}
