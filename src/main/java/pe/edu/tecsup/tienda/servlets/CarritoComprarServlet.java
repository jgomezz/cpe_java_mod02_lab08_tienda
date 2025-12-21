package pe.edu.tecsup.tienda.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pe.edu.tecsup.tienda.entities.Producto;
import pe.edu.tecsup.tienda.services.ProductoService;
import pe.edu.tecsup.tienda.services.ProductoServiceImpl;

/**
 * Servlet implementation class CarritoComprarServlet
 */
@WebServlet("/CarritoComprarServlet")
public class CarritoComprarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(CarritoComprarServlet.class);
	
	private ProductoService productoService;
	
	public CarritoComprarServlet() {
		this.productoService = new ProductoServiceImpl();
	}


	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Post CarritoComprarServlet");
		try {
			
			String id = request.getParameter("id");
			log.info("id: " + id);
			
			Producto producto = productoService.obtener(Integer.parseInt(id));
			log.info(producto);
			
			HttpSession session = request.getSession();
			
			List<Producto> productos 
				= (List<Producto>) session.getAttribute("productos");
			
			if(productos == null) {
				productos = new ArrayList<Producto>();
			}
			
			productos.add(producto);
			
			session.setAttribute("productos", productos);
			
			request.getSession().setAttribute("success", "Producto añadido al carrito");
			
			response.sendRedirect(request.getContextPath() + "/CarritoListarServlet");
	        
		} catch (Exception e) {
			log.error(e, e);
			throw new ServletException(e.getMessage(), e);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}
