package pe.edu.tecsup.tienda.servlets.carrito;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pe.edu.tecsup.tienda.entities.Producto;
import pe.edu.tecsup.tienda.services.ProductoService;
import pe.edu.tecsup.tienda.services.ProductoServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

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

	/**
	 * Agregar producto al carrito de compra
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");

		Producto producto = this.productoService.obtener(Integer.parseInt(id));
		log.info(producto);
		
		// Trabajo con la sesion del usuario
				
		HttpSession session = request.getSession();
		
		List<Producto> productosDelCarrito  = (List<Producto>)session.getAttribute("productos");
		
		if(productosDelCarrito == null) {
			productosDelCarrito = new ArrayList<Producto>();
		}
		
		productosDelCarrito.add(producto);
		
		// Grabar en el carrito de compra mis productos
		session.setAttribute("productos", productosDelCarrito);
		
		
		response.sendRedirect(request.getContextPath() + "/CarritoListarServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
