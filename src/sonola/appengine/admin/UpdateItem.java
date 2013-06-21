package sonola.appengine.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UpdateItem extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7448271658013114555L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		try {
			String description = (String) request.getParameter("update_description");
			PrintWriter out = response.getWriter();
			out.print(description);
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
