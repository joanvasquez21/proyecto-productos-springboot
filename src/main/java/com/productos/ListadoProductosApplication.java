package com.productos;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.productos.models.dao.IProductoDAO;
import com.productos.models.documents.Producto;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class ListadoProductosApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(ListadoProductosApplication.class);

	@Autowired
	private IProductoDAO productoDAO;

	@Autowired
	private ReactiveMongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ListadoProductosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		mongoTemplate.dropCollection("productos").subscribe();
		
		
		Flux.just(new Producto("Tablet Xiaomi", 905632, "hiraoka@hiraoka.com"), 
				new Producto("Iphone 13", 9143232,  "hiraoka@hiraoka.com"),
				new Producto("Bicicleta", 2132312, "hiraoka@hiraoka.com"), 
				new Producto("Armario de Cocina", 2532423,  "hiraoka@hiraoka.com"),
				new Producto("Raqueta", 832432,  "hiraoka@hiraoka.com")

		).flatMap(producto -> {
			producto.setCreateAt(new Date());
			
			return 
			productoDAO.save(producto);
			
		})
		 .subscribe(producto -> log.info("Insert: " + producto.getId() + " " + producto.getNombre()));
	}

}
