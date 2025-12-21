package pe.edu.tecsup.tienda.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.entities.Producto;
import pe.edu.tecsup.tienda.utils.ConexionBD;


public class ProductoRepositoryImpl implements ProductoRepository {

	private static final Logger log 
		= Logger.getLogger(ProductoRepositoryImpl.class);

	@Override
	public List<Producto> obtenerProductos() {
		
    	log.info("Llamada al repositorio");

    	List<Producto> productos = new ArrayList<Producto>();
    	 
    	try {

             // Conectarme a la Base de datos
             Connection con = ConexionBD.obtenerConexion();

             // Preparar la sentencia      
             String sql= """
                             SELECT p.id, 
                                    p.categorias_id, 
             		                c.nombre AS categorias_nombre, 
             		                p.nombre, 
             		                p.descripcion, 
             		                p.precio, 
             		                p.stock, 
             		                p.imagen_nombre, 
             		                p.imagen_tipo, 
             		                p.imagen_tamanio, 
             		                p.creado, 
             		                p.estado 
							 FROM productos p 
							 INNER JOIN categorias c 
							       ON c.id=p.categorias_id 
							 WHERE estado = 1  
							 ORDER BY id 
							 
                          """;
             
             PreparedStatement stmt= con.prepareStatement(sql);

             ResultSet rs = stmt.executeQuery();

             while(rs.next()) {

            	Producto producto = new Producto();
     			producto.setId(rs.getInt("id"));
     			producto.setCategorias_id(rs.getInt("categorias_id"));
     			
     			Categoria categoria = new Categoria();
     			categoria.setId(rs.getInt("categorias_id"));
     			categoria.setNombre(rs.getString("categorias_nombre"));
     			producto.setCategoria(categoria);
     			
     			producto.setNombre(rs.getString("nombre"));
     			producto.setDescripcion(rs.getString("descripcion"));
     			producto.setPrecio(rs.getDouble("precio"));
     			if(rs.wasNull()) producto.setPrecio(null);
     			producto.setStock(rs.getInt("stock"));
     			producto.setImagen_nombre(rs.getString("imagen_nombre"));
     			producto.setImagen_tipo(rs.getString("imagen_tipo"));
     			producto.setImagen_tamanio(rs.getLong("imagen_tamanio"));
     			if(rs.wasNull()) producto.setImagen_tamanio(null);
     			producto.setEstado(rs.getInt("estado"));
     			
     			productos.add(producto);
     			
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

    	 
		return productos;
	}

	@Override
	public void registrar(Producto producto) {
		
		log.info("Llamando a registrar(producto: " + producto + ")");
		
		try {

            // Conectarme a la Base de datos
            Connection con = ConexionBD.obtenerConexion();

            // Preparar la sentencia      
            String sql= """
                        INSERT INTO productos ( categorias_id, 
		            		                    nombre, 
		            		                    descripcion, 
		            		                    precio, 
		            		                    stock, 
		            		                    imagen_nombre, 
		            		                    imagen_tipo, 
		            		                    imagen_tamanio )
            			VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            				 
                        """;
            
            PreparedStatement stmt= con.prepareStatement(sql);
            //
            stmt.setInt(1, producto.getCategorias_id());
    		stmt.setString(2, producto.getNombre());
    		stmt.setString(3, producto.getDescripcion());
    		stmt.setDouble(4, producto.getPrecio());
    		stmt.setInt(5, producto.getStock());
    		stmt.setString(6, producto.getImagen_nombre());
    		stmt.setString(7, producto.getImagen_tipo());
    		stmt.setObject(8, producto.getImagen_tamanio());
    		//
    		stmt.executeUpdate();
            
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

		
	}

	@Override
	public void eliminar(Integer id) {
		
		try {

            // Conectarme a la Base de datos
            Connection con = ConexionBD.obtenerConexion();

            // Preparar la sentencia      
            String sql= """
            		
                        DELETE FROM productos WHERE id=?
            			
                        """;
            
            PreparedStatement stmt= con.prepareStatement(sql);
            //
    		stmt.setInt(1, id);
    		//
    		stmt.executeUpdate();
            
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

}
