package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
		try {
			PreparedStatement pst = super.conexion.prepareStatement("UPDATE productos SET nombre = ?, fecha_compra = ?, precio = ? WHERE id = ?");
				pst.setString(1, producto.getNombre());
				pst.setDate(2, new java.sql.Date(producto.getFechaCompra().getTime()));
				pst.setDouble(3, producto.getPrecio());
				pst.setInt(4, producto.getId());
				pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void delete(int id) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("DELETE FROM productos WHERE id = ?");
			pst.setInt(1, id);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public Producto insert(Producto producto) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO productos (nombre, fecha_compra, precio, id_marca) VALUES (?, ?, ?, ?)");
			pst.setString(1, producto.getNombre());
			pst.setDate(2, new java.sql.Date(producto.getFechaCompra().getTime()));
			pst.setDouble(3, producto.getPrecio());
			pst.setInt(4, producto.getMarca().getId());
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return producto;
	}
}
