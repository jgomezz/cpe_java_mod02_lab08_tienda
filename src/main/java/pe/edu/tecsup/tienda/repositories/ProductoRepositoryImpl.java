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

	private static final Logger log = Logger.getLogger(ProductoRepositoryImpl.class);

	
	@Override
	public List<Producto> obtenerProductos() {

		log.info("Llamada al repositorio de Productos");
    	
        List<Producto> productos = new ArrayList<Producto>();
		
        try {

            // Conectarme a la Base de datos
            Connection con = ConexionBD.obtenerConexion();
        
            // Preparar la sentencia
            String sql= 
            		"""
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

                // Lee informacion de un registro de la tabla productos
 
            	// Producto
            	Producto producto = new Producto();
 
            	producto.setId(rs.getInt("id"));
            	producto.setNombre(rs.getString("nombre"));
     			producto.setDescripcion(rs.getString("descripcion"));
     			producto.setPrecio(rs.getDouble("precio"));
     			if(rs.wasNull()) 
     				producto.setPrecio(null);
     			producto.setStock(rs.getInt("stock"));
     			producto.setImagen_nombre(rs.getString("imagen_nombre"));
     			producto.setImagen_tipo(rs.getString("imagen_tipo"));
     			producto.setImagen_tamanio(rs.getLong("imagen_tamanio"));
     			if(rs.wasNull()) 
     				producto.setImagen_tamanio(null);
     			producto.setEstado(rs.getInt("estado"));
            	
     			// Informacion de la categoria del producto
     			Categoria categoria = new Categoria();
     			categoria.setId(rs.getInt("categorias_id"));
     			categoria.setNombre(rs.getString("categorias_nombre"));
     		
     			// Agregar la Categoria asociada al producto
     			producto.setCategoria(categoria);
     			
                // Agrega el objeto a la lista
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

		log.info("Grabando producto en base de datos");
    	
		
        try {

            // Conectarme a la Base de datos
            Connection con = ConexionBD.obtenerConexion();

            // TODO
            
            
            // Cerrar conexion a base de datos
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
