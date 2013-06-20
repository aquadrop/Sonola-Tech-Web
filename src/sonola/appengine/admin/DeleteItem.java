package sonola.appengine.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

public class DeleteItem extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3830961801327177986L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {
			String id = request.getParameter("DeleteItem");
			PrintWriter out = response.getWriter();

			// out.print(id);

			DatastoreService datastore = DatastoreServiceFactory
					.getDatastoreService();
			Key key = KeyFactory.createKey("item_datastore",
					Integer.parseInt(id));

			// deal with blobstore
			Filter filter = new FilterPredicate(Entity.KEY_RESERVED_PROPERTY,
					FilterOperator.EQUAL, key);
			Query q = new Query("item_datastore").setFilter(filter);
			PreparedQuery pq = datastore.prepare(q);
			Entity result = pq.asSingleEntity();

			String blobKeyStr = (String) result.getProperty("blobKey");
			BlobKey blobKey = new BlobKey(blobKeyStr);
			BlobstoreService blobstoreService = BlobstoreServiceFactory
					.getBlobstoreService();
			blobstoreService.delete(blobKey);

			// deal with thumbnail url
			String url = (String) result.getProperty("imgurl");
			// out.print(url);
			try {
				deleteFile(url);
			} catch (Exception e) {
				// ignore
			}

			datastore.delete(key);

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

	private boolean deleteFile(String filename) {
		File file = new File(filename);
		return file.delete();
	}

}
