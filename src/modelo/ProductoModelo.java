package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductoModelo extends Conector{

	public ArrayList<Producto> selectAll() {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM productos");
			while(rs.next()){
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setNombre(rs.getString("nombre"));
				producto.setFechaCompra(rs.getDate("fecha_compra"));
				producto.setPrecio(rs.getDouble("precio"));
				productos.add(producto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
	}

	public Producto selectPorId(int idProducto) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("SELECT * FROM productos WHERE id = ?");
			pst.setInt(1, idProducto);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setNombre(rs.getString("nombre"));
				producto.setFechaCompra(rs.getDate("fecha_compra"));
				producto.setPrecio(rs.getDouble("precio"));
				//Marca marca = new Marca();
				//marca.setId(rs.getInt("id"));
				//producto.setMarca(marca);
				
				return producto;
			}else{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void update(Producto producto) {
		// TODO Auto-generated method stub
		
	}

}
