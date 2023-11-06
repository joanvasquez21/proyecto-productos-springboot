package com.productos.models.documents;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "productos")
public class Producto {

	@Id
	private String id;
	
	private String nombre;
	
	private int productoId;
	
	private String email;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
	
	
	
	
	public Producto(String nombre, int productoId, String email ) {
		this.nombre = nombre;
		this.productoId = productoId;
		this.email = email;
	}
	
	
	public Producto() {	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getProductoId() {
		return productoId;
	}


	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}


	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
}
