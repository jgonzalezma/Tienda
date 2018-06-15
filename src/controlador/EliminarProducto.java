package controlador;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Producto;
import modelo.ProductoModelo;

/**
 * Servlet implementation class EliminarProducto
 */
@WebServlet("/EliminarProducto")
public class EliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// coger la id
		int id = Integer.parseInt(request.getParameter("id"));
		// llamar al modelo
		ProductoModelo productoModelo = new ProductoModelo();
		// conseguir datos del producto a eliminar
		Producto producto = productoModelo.selectPorId(id);
		producto.setId(id);
		// ejecutar el delete
		productoModelo.delete(id);
		// meterlo en el request
		request.setAttribute("producto", producto);
		// enviar a la vista
		request.getRequestDispatcher("infoEliminado.jsp").forward(request, response);
	}
}
