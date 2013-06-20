package sonola.appengine.datastore;

import sonola.appengine.models.Item;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class WriteDatabase {

	public void writeDatabase(Item item){
		try{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Entity item_datastore = new Entity("item_datastore");
		
		item_datastore.setProperty("blobKey", item.getBlobKey().getKeyString());
		item_datastore.setProperty("title", item.getTitle());
		item_datastore.setProperty("description_text5", item.getDescription());
		item_datastore.setProperty("imgurl", item.getImgUrl());
		
		datastore.put(item_datastore);
		}
		catch(Exception e){
			System.out.print(e.getMessage());
		}
	}
}
