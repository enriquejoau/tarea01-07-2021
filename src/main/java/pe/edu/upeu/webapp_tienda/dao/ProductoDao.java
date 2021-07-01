package pe.edu.upeu.webapp_tienda.dao;

import java.util.List;

import pe.edu.upeu.webapp_tienda.model.Producto;

public interface ProductoDao {
	int create(Producto p);
	int update(Producto p);
	int delete(int id);
	Producto read(int id);
	List<Producto> readAll();
}
