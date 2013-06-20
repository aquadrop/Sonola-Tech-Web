package sonola.appengine.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sonola.appengine.datastore.WriteDatabase;
import sonola.appengine.models.Item;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.Text;

public class UploadItem extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3172657656593936469L;
	private BlobstoreService blobstoreService = BlobstoreServiceFactory
			.getBlobstoreService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		if (session.isNew() || session.getAttribute("admin") == null) {
			try {
				response.sendRedirect(response.encodeRedirectURL("Login"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				RequestDispatcher view = request
						.getRequestDispatcher("uploaditem.jsp");
				view.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {

			// Upload Image Object, Title, and Description currently, later,
			// categories may join
			Map<String, java.util.List<BlobKey>> blobs = blobstoreService
					.getUploads(request);
			BlobKey blobKey = blobs.get("myFile").get(0);

			String title = request.getParameter("title");
			//replace special quotes
			Text description = new Text(request.getParameter("description")
					.replace((char) 0x201C, (char) 0x22)
					.replace((char) 0x201D, (char) 0x22));

			Item item = new Item();
			item.setBlobKey(blobKey);
			item.setTitle(title);
			item.setDescription(description);
			item.setImgUrl();
			writeDatabase(item);
			response.sendRedirect(response.encodeRedirectURL("/admin/ListItem"));

		} catch (Exception e) {
			session.setAttribute(
					"servlet-error",
					"Servlet: "+ UploadItem.class.getSimpleName() + "<br> " + "Error: "
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

	private void writeDatabase(Item item) {
		WriteDatabase writedatabase = new WriteDatabase();
		writedatabase.writeDatabase(item);

	}
}
