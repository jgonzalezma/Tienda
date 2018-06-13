package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Producto;
import modelo.ProductoModelo;

/**
 * Servlet implementation class Listar
 */
@WebServlet("/Listar")
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// importar el modelo de producto
		ProductoModelo productoModelo = new ProductoModelo();
		// hacer un selectAll del modeloProducto que devuelve el arraylist
		ArrayList<Producto> productos = productoModelo.selectAll();
		// hacer el request
		request.setAttribute("productos", productos);
		// enviarlo a la vista
		request.getRequestDispatcher("listado.jsp").forward(request, response);
		
	}
}
