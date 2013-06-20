package sonola.appengine.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Welcome extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3995124462828380064L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		if (session.isNew()||session.getAttribute("admin") == null)
		{
			try {
				response.sendRedirect(response.encodeRedirectURL("/admin/Login"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			try {
				RequestDispatcher view = request.getRequestDispatcher("/admin/panel.jsp");
				view.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
