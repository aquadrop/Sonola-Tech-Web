package sonola.appengine.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sonola.appengine.datastore.ReadDatabase;
import sonola.appengine.models.Item;


public class PresentItem extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7415735033128420585L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		try{
		String keyId = request.getParameter("keyId");
		
		ReadDatabase readDatabase = new ReadDatabase();
		Item item = readDatabase.queryItem(keyId);
		
		request.setAttribute("Item", item);
		
		RequestDispatcher view = request
				.getRequestDispatcher("/product/item.jsp");
		view.forward(request, response);
		}catch(Exception e){
			session.setAttribute(
					"servlet-error",
					"Servlet: "+ PresentItem.class.getSimpleName() + "<br> " + "Error: "
							+ e.getMessage()
							+ request.getParameter("description"));
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
