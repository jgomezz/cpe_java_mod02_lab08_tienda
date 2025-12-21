package pe.edu.tecsup.tienda.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.utils.ConexionBD;

public class CategoriaRepositoryImpl implements CategoriaRepository {

    @Override
    public List<Categoria> obtenerCategorias() {

        List<Categoria> categorias = new ArrayList<Categoria>();

        try {

            // Conectarme a la Base de datos
            Connection con = ConexionBD.obtenerConexion();

            // Preparar la sentencia
            String sql= """
                            SELECT * FROM categorias
                        """;
            PreparedStatement stmt= con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {

                // Lee informacion de un registro de la tabla categorias
                int id= rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String orden = rs.getString("orden");

                // Crea un objeto Categoria
                Categoria categoria = new Categoria();
                categoria.setId(id);
                categoria.setNombre(nombre);
                categoria.setDescripcion(descripcion);
                categoria.setOrden(orden);

                // Agrega el objeto a la lista
                categorias.add(categoria);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return categorias;

    }

}
