package pe.edu.upeu.webapp_tienda.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.webapp_tienda.dao.ProductoDao;
import pe.edu.upeu.webapp_tienda.daoImpl.ProductoDaoImpl;
import pe.edu.upeu.webapp_tienda.model.Producto;


/**
 * Servlet implementation class ProductoController
 */
public class ProductoController extends HttpServlet {
	private ProductoDao pdao = new ProductoDaoImpl();
	private Gson gson = new Gson();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int opcion = Integer.parseInt(request.getParameter("opc"));//opc='1'
		switch (opcion) {
		case 1://todos los roles
				out.println(gson.toJson(pdao.readAll()));
			break;
		case 2://guardar
			out.println(gson.toJson(pdao.create(new Producto(request.getParameter("nombre"), Double.parseDouble(request.getParameter("precio")), Integer.parseInt(request.getParameter("cantidad"))))));
			break;
		case 3://read
			out.println(gson.toJson(pdao.read(Integer.parseInt(request.getParameter("id")))));
			break;
		case 4://modificar
			Producto p = new Producto();
			p.setIdprod(Integer.parseInt(request.getParameter("id")));
			p.setNombre(request.getParameter("nombre"));
			p.setPrecio(Double.parseDouble(request.getParameter("precio")));
			p.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
			out.println(gson.toJson(pdao.update(p)));
			break;
		case 5://eliminar
			out.println(gson.toJson(pdao.delete(Integer.parseInt(request.getParameter("id")))));
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
