package sonola.appengine.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sonola.appengine.datastore.DeleteDatabase;


public class DeleteItem extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3830961801327177986L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {
			String keyId = request.getParameter("DeleteItem");
			
			DeleteDatabase deletedatabase = new DeleteDatabase();
			deletedatabase.deleteDatabase(keyId);
			

			response.sendRedirect(response.encodeRedirectURL("/admin/ListItem"));
		}

		catch (Exception e) {
			session.setAttribute("servlet-error", "Servlet: "+ DeleteItem.class.getSimpleName()
					+ "<br>" + "Error: " + e.getMessage());
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
