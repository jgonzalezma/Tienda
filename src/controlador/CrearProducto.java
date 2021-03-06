package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Marca;
import modelo.MarcaModelo;

/**
 * Servlet implementation class CrearProducto
 */
@WebServlet("/CrearProducto")
public class CrearProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// llamar al modelo de marcas
		MarcaModelo marcaModelo = new MarcaModelo();
		// hacer el selectAll de marcas
		ArrayList<Marca> marcas = marcaModelo.selectAll();
		// guardarlos en el request
		request.setAttribute("marcas", marcas);
		// enviarlos al formulario
		request.getRequestDispatcher("formCrear.jsp").forward(request, response);
	}
}
