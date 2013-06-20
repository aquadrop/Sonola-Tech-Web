package sonola.appengine.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import sonola.appengine.datastore.ReadDatabase;
import sonola.appengine.models.Item;

public class ListItem extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3172056027353272684L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		if (session.isNew() || session.getAttribute("admin") == null) {
			try {
				PrintWriter out = response.getWriter();
				out.println("Haha");
				response.sendRedirect(response.encodeRedirectURL("Login"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				
				ReadDatabase readdatabase = new ReadDatabase();
				List<Item> items = readdatabase.readDatabase();
				
				request.setAttribute("items", items);
				
				
				
				
				RequestDispatcher view = request.getRequestDispatcher("listitem.jsp");
				view.forward(request, response);
			} catch (Exception e) {
				session.setAttribute("servlet-error",
						"Servlet: "+ ListItem.class.getSimpleName() +"<br> "+ "Error: "+e.getMessage());
				RequestDispatcher view = request.getRequestDispatcher("/error/error-page.jsp");
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
	
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		
	}
}
