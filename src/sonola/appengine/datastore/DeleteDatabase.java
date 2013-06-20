package sonola.appengine.datastore;

import java.io.File;


import sonola.appengine.constants.Constant;

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

public class DeleteDatabase {

	public void deleteDatabase(String keyId) {
		try {

			

			DatastoreService datastore = DatastoreServiceFactory
					.getDatastoreService();
			Key key = KeyFactory.createKey(Constant.entity_name,
					Long.parseLong(keyId));

			// deal with blobstore
			Filter filter = new FilterPredicate(Entity.KEY_RESERVED_PROPERTY,
					FilterOperator.EQUAL, key);
			Query q = new Query(Constant.entity_name).setFilter(filter);
			PreparedQuery pq = datastore.prepare(q);
			Entity result = pq.asSingleEntity();

			BlobKey blobKey = (BlobKey) result
					.getProperty(Constant.table_blobKey);
			BlobstoreService blobstoreService = BlobstoreServiceFactory
					.getBlobstoreService();
			blobstoreService.delete(blobKey);

			// deal with thumbnail url
			String url = (String) result.getProperty("imgurl");
			try {
				deleteFile(url);
			} catch (Exception e) {
				// ignore
			}

			datastore.delete(key);
			
			CacheUtil.addtoCache(Constant.memcache_query_is_updated, true);
		} catch (Exception e) {

		}
	}

	public boolean deleteFile(String filename) {
		File file = new File(filename);
		return file.delete();
	}

}
