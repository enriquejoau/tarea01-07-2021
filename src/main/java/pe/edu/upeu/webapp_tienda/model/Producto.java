package pe.edu.upeu.webapp_tienda.model;

public class Producto {
	private int idprod;
	private String nombre;
	private double precio;
	private int cantidad;
	
	public Producto() {
		
	}
	
	public Producto(String nombre, double precio, int cantidad) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public int getIdprod() {
		return idprod;
	}

	public void setIdprod(int idprod) {
		this.idprod = idprod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
