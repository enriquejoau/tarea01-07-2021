package pe.edu.upeu.webapp_tienda.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.webapp_tienda.config.Conexion;
import pe.edu.upeu.webapp_tienda.dao.ProductoDao;
import pe.edu.upeu.webapp_tienda.model.Producto;

public class ProductoDaoImpl implements ProductoDao{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	@Override
	public int create(Producto p) {
		int x = 0;
		String SQL = "insert into producto (idprod, nombre, precio, cantidad) values(null, ?,?,?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, p.getNombre());
			ps.setDouble(2, p.getPrecio());
			ps.setInt(3, p.getCantidad());
			x = ps.executeUpdate();
			System.out.println(x);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public int update(Producto p) {
		// TODO Auto-generated method stub
		int x = 0;
		String SQL = "update producto set nombre = ?, precio = ?, cantidad = ? where idprod = ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, p.getNombre());
			ps.setDouble(2, p.getPrecio());
			ps.setInt(3, p.getCantidad());
			ps.setInt(4, p.getIdprod());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public Producto read(int id) {
		// TODO Auto-generated method stub
		Producto p = new Producto();
		String SQL = "select *from producto where idprod=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {				
				p.setIdprod(rs.getInt("idprod"));
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getDouble("precio"));
				p.setCantidad(rs.getInt("cantidad"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return p;
	}

	@Override
	public int delete(int id) {
		int x = 0;
		String SQL = "delete from producto where idprod=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public List<Producto> readAll() {
		// TODO Auto-generated method stub
		List<Producto> lista = new ArrayList<>();
		String SQL = "select *from producto";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery(SQL);
			while(rs.next()) {
				Producto p = new Producto();
				p.setIdprod(rs.getInt("idprod"));
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getDouble("precio"));
				p.setCantidad(rs.getInt("cantidad"));
				lista.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		
		return lista;
	}
}
