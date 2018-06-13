package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Producto;
import modelo.ProductoModelo;

/**
 * Servlet implementation class CambiarProducto
 */
@WebServlet("/CambiarProducto")
public class CambiarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recoger los datos del formulario
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String nombre = request.getParameter("nombre");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date fecha_compra = sdf.parse(request.getParameter("fechaCompra"));
			Double precio = Double.parseDouble(request.getParameter("precio"));
			
			// crear objeto producto
			Producto producto = new Producto();
			producto.setId(id);
			producto.setNombre(nombre);
			producto.setFechaCompra(fecha_compra);
			producto.setPrecio(precio);
			
			// crear el productoModelo
			ProductoModelo productoModelo = new ProductoModelo();
			// hacer el update en el ProductoModelo y cogerlo
			productoModelo.update(producto);
			// abrir ver producto
			response.sendRedirect("VerProducto?id=" + id);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
