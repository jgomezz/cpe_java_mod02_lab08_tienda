package pe.edu.tecsup.tienda.repositories;

import java.util.List;

import pe.edu.tecsup.tienda.entities.Producto;

public interface ProductoRepository {

    List<Producto> obtenerProductos();

	void registrar(Producto producto);

	void eliminar(Integer id);

	Producto obtener(int id);

}
