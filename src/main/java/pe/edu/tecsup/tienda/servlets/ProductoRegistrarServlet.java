package pe.edu.tecsup.tienda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.services.CategoriaService;
import pe.edu.tecsup.tienda.services.CategoriaServiceImpl;
import pe.edu.tecsup.tienda.services.ProductoService;
import pe.edu.tecsup.tienda.services.ProductoServiceImpl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class ProductoRegistrarServlet
 */
@WebServlet("/ProductoRegistrarServlet")
public class ProductoRegistrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	private static final Logger log 
		= Logger.getLogger(ProductoRegistrarServlet.class);

	private ProductoService productoService;
	
	private CategoriaService categoriaService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoRegistrarServlet() {
        super();
        this.productoService = new ProductoServiceImpl();
        this.categoriaService = new CategoriaServiceImpl();
    }

	/**
	 * 
	 * Muestra formulario de registro de producto
	 * 
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("Cargando formulario de registro de producto");
		
		// Obtener las categorias
		List<Categoria> cats = this.categoriaService.obtenerCategorias();
		
		// Guarda las categorias en el request
		request.setAttribute("categorias", cats);
		
		// Redireccionar al JSP registrar 
		request.getRequestDispatcher("/WEB-INF/jsp/producto/registrar.jsp")
			   .forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Atender Formulario: ").append(request.getContextPath());
	}

}
