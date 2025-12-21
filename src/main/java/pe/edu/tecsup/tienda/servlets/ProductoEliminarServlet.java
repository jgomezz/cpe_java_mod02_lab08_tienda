package pe.edu.tecsup.tienda.servlets;

import java.io.IOException;

import org.apache.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.edu.tecsup.tienda.services.ProductoService;
import pe.edu.tecsup.tienda.services.ProductoServiceImpl;

/**
 * Servlet implementation class ProductoEliminarServlet
 */
@WebServlet("/ProductoEliminarServlet")
public class ProductoEliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log 
		= Logger.getLogger(ProductoEliminarServlet.class);

	private ProductoService productoService;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoEliminarServlet() {
        super();
    	this.productoService = new ProductoServiceImpl();
    }

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		log.info("llamando a  ProductoEliminarServlet");

		Integer id = Integer.parseInt(request.getParameter("id"));
		
		productoService.eliminar(id);
		
		request.getSession().setAttribute("success", "Registro eliminado satisfactoriamente");

		response.sendRedirect(request.getContextPath() + "/ProductoListarServlet");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
