package sonola.appengine.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sonola.appengine.datastore.FrontDatabase;
import sonola.appengine.models.Item;

//this class is to maintain the welcome.jsp
public class HomePage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -334131036426048364L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {
			
			FrontDatabase frontdatabase = new FrontDatabase();
			List<Item> items = frontdatabase.query_Database();
			
			request.setAttribute("frontitems", items);
			
			RequestDispatcher view = request
					.getRequestDispatcher("welcome.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			session.setAttribute(
					"servlet-error",
					"Servlet: "+ HomePage.class.getSimpleName() + "<br> " + "Error: "
							+ e.getMessage());
			RequestDispatcher view = request
					.getRequestDispatcher("/error/error-page.jsp");
			try {
				view.forward(request, response);
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
