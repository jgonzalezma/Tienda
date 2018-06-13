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
 * Servlet implementation class VerProducto
 */
@WebServlet("/VerProducto")
public class VerProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sacar el int que hemos puesto en la url de listado.jsp (hay que declararlo aqui)
		int idProducto = Integer.parseInt(request.getParameter("id"));
		// importar el modelo de productos, ProductosModelo
		ProductoModelo productoModelo = new ProductoModelo();
		// sacar el selectPorId del modelo
		Producto producto = productoModelo.selectPorId(idProducto);
		// hacer el request
		request.setAttribute("producto", producto);
		// enviarlo a la vista
		request.getRequestDispatcher("vistaProducto.jsp").forward(request, response);
	}
}
