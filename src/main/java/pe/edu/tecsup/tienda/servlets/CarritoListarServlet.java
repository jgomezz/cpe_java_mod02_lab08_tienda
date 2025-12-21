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

/**
 * Servlet implementation class CarritoListarServlet
 */
@WebServlet("/CarritoListarServlet")
public class CarritoListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CarritoListarServlet.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoListarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Get CarritoListarServlet");
		
		HttpSession session = request.getSession();
		
		List<Producto> productos 
			= (List<Producto>) session.getAttribute("productos");
		
		if(productos == null) {
			productos = new ArrayList<Producto>();
		}
		
		request.setAttribute("productos", productos);
		
		request.getRequestDispatcher("/WEB-INF/jsp/carrito/listar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
