package pe.edu.tecsup.tienda.servlets;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.entities.Producto;
import pe.edu.tecsup.tienda.services.ProductoService;
import pe.edu.tecsup.tienda.services.ProductoServiceImpl;

/**
 * Servlet implementation class ProductoListarServlet
 */
@WebServlet("/ProductoListarServlet")
public class ProductoListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private static final Logger log 
		= Logger.getLogger(ProductoListarServlet.class);
	
	private ProductoService productoService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoListarServlet() {
        super();
        this.productoService = new ProductoServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	log.info("Llamada al servlet");

		// Obtener los productos
		List<Producto> productos
			= this.productoService.obtenerProductos();
		
    	log.info("Mostrando productos ");

		for(Producto item : productos) {
			log.info(item);
		}

		// Graba en el request los productos
		request.setAttribute("productos", productos);

		request.getRequestDispatcher("/WEB-INF/jsp/producto/listar.jsp")
			   .forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
