package com.productos.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.productos.models.documents.Producto;
import com.productos.models.services.IProductoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class ProductoController {
	
	private static final Logger log = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private IProductoService productoDAO;
	
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		Flux<Producto> productos =  productoDAO.findAllConNombreUpperCase();
		
		
		model.addAttribute("productos", productos);
		model.addAttribute("titulo", "Listado de productos");
		
		return "listar";
	}
	
	
	@GetMapping("/form")
	public Mono<String> crear(Model model){
		
		model.addAttribute("producto",new Producto());
		model.addAttribute("titulo", "Formulario de producto");
		
		return Mono.just("form");
	}
	
	@PostMapping("/form")
	public Mono<String> guardar(Producto producto){
		return productoDAO.save(producto).doOnNext( p -> {
			log.info("Producto guardado: " + p.getNombre() + "Id: " + p.getId());
		}).thenReturn("redirect:/listar");
	}
	
	
	@GetMapping("/form/{id}")
	public Mono<String> editar(@PathVariable String id, Model model){
	
		Mono<Producto> producto = productoDAO.findById(id).doOnNext( p -> {
			log.info("Producto: " + p.getNombre());
		});
		
		model.addAttribute("titulo", "Editar producto");
		model.addAttribute("producto",  producto);
		
		return Mono.just("form");
		
		
	}
	

}
