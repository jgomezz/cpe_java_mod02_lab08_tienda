package pe.edu.tecsup.tienda.services;

import java.util.List;

import pe.edu.tecsup.tienda.entities.Producto;

public interface ProductoService {

    List<Producto> obtenerProductos();

	void registrar(Producto producto);

	void eliminar(Integer id);

	Producto obtener(int id);

	
}










