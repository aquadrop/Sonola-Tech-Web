package sonola.appengine.datastore;

import sonola.appengine.models.Item;
import sonola.appengine.constants.Constant;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class WriteDatabase {

	public void writeDatabase(Item item){
		try{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Entity item_datastore = new Entity(Constant.entity_name);
		
		item_datastore.setProperty(Constant.table_blobKey, item.getBlobKey());
		item_datastore.setProperty(Constant.table_title, item.getTitle());
		item_datastore.setProperty(Constant.table_description, item.getDescription());
		item_datastore.setProperty(Constant.table_imgUrl, item.getImgUrl());
		
		datastore.put(item_datastore);
		
		//notify memcache to sign update
		CacheUtil.addtoCache(Constant.memcache_query_is_updated, true);
		}
		catch(Exception e){
			System.out.print(e.getMessage());
		}
	}
}
