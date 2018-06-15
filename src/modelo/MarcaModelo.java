package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MarcaModelo extends Conector{

	public ArrayList<Marca> selectAll() {
		ArrayList<Marca> marcas = new ArrayList<Marca>();
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM marcas");
			while(rs.next()){
				Marca marca = new Marca();
				marca.setId(rs.getInt("id"));
				marca.setNombre(rs.getString("nombre"));
				marcas.add(marca);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return marcas;
	}

}
