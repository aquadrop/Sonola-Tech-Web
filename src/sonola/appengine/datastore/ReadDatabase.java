package sonola.appengine.datastore;

import java.util.ArrayList;
import java.util.List;

import sonola.appengine.models.Item;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Text;

public class ReadDatabase {

	public List<Item> readDatabase(){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		List<Item> items = new ArrayList<Item>();
		
		Query q = new Query("item_datastore");
		PreparedQuery pq = datastore.prepare(q);
		
		for (Entity result: pq.asIterable()){
			String blobkey_str = (String) result.getProperty("blobKey");
			String title = (String) result.getProperty("title");
			Text description = (Text) result.getProperty("description_text5");
			String imgUrl = (String) result.getProperty("imgurl");
			Key key =(Key) result.getKey();
			
			Item item = new Item();
			item.setKey(key);
			item.setBlobKeyStr(blobkey_str);
			item.setTitle(title);
			//item.setDescription(description);
			try{
			item.setDescriptionStr(description.getValue());
			}catch(Exception e){}
			item.setImgUrl(imgUrl);
			items.add(item);
			
//			//we only provide string key
//			CacheUtil.addtoCache(Long.toString(key.getId()), result);
		}
		
		return items;
	}
}
