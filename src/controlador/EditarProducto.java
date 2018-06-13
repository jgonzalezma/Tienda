package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Producto;
import modelo.ProductoModelo;

/**
 * Servlet implementation class EditarProducto
 */
@WebServlet("/EditarProducto")
public class EditarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// coger la id del producto que hemos puesto en la url
		int idProducto = Integer.parseInt(request.getParameter("id"));
		// importar el modelo del producto, ProductoModelo y crearlo
		ProductoModelo productoModelo = new ProductoModelo();
		// poner el selectPorId
		Producto producto = productoModelo.selectPorId(idProducto);
		// hacer el request
		request.setAttribute("producto", producto);
		// enviarlo a la vista
		request.getRequestDispatcher("formEdicion.jsp").forward(request, response);
	}
}
