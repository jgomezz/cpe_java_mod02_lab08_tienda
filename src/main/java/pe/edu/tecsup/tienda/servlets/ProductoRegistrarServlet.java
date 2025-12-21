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
import pe.edu.tecsup.tienda.services.CategoriaService;
import pe.edu.tecsup.tienda.services.CategoriaServiceImpl;

/**
 * Servlet implementation class ProductoRegistrarServlet
 */
@WebServlet("/ProductoRegistrarServlet")
public class ProductoRegistrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log 
		= Logger.getLogger(ProductoRegistrarServlet.class);
	
	private CategoriaService categoriaService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoRegistrarServlet() {
        super();
		this.categoriaService = new CategoriaServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		log.info("Iniciando doGet() ProductoRegistrarServlet");
		
		List<Categoria> categorias = categoriaService.obtenerCategorias();
		
		request.setAttribute("categorias", categorias);
		
		request.getRequestDispatcher("/WEB-INF/jsp/producto/registrar.jsp")
			   .forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("Iniciando doPost() ProductoRegistrarServlet");

		String categorias_id = request.getParameter("categorias_id");
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		String stock = request.getParameter("stock");
		String descripcion = request.getParameter("descripcion");
		
		Producto producto = new Producto();
		producto.setCategorias_id(Integer.parseInt(categorias_id));
		producto.setNombre(nombre);
		producto.setPrecio(Double.parseDouble(precio));
		producto.setStock(Integer.parseInt(stock));
		producto.setDescripcion(descripcion); 
		
		log.info("Producto ingresado -> " + producto);

		
		response.sendRedirect(request.getContextPath() + "/ProductoListarServlet");

		
	}

}
