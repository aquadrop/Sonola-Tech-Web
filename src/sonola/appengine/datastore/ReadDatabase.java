package sonola.appengine.datastore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sonola.appengine.models.Item;
import sonola.appengine.constants.Constant;

import com.google.appengine.api.blobstore.BlobKey;
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
		
		Query q = new Query(Constant.entity_name);
		PreparedQuery pq = datastore.prepare(q);
		Map<String, String> keyIds = new HashMap<String, String>();
		
		for (Entity result: pq.asIterable()){
			BlobKey blobkey = (BlobKey) result.getProperty(Constant.table_blobKey);
			String title = (String) result.getProperty(Constant.table_title);
			Text description = (Text) result.getProperty(Constant.table_description);
			String imgUrl = (String) result.getProperty(Constant.table_imgUrl);
			Key key =(Key) result.getKey();
			
			Item item = new Item();
			item.setKey(key);
			item.setBlobKey(blobkey);
			item.setTitle(title);
			//item.setDescription(description);
			try{
			item.setDescription(description);
			}catch(Exception e){}
			item.setImgUrl(imgUrl);
			items.add(item);
			
			//we only provide string key
			CacheUtil.addtoCache(Long.toString(key.getId()), item);
			keyIds.put(Long.toString(key.getId()), Long.toString(key.getId()));
			
		}
		
		CacheUtil.addtoCache(Constant.memcache_keyId_List, keyIds);
		CacheUtil.addtoCache(Constant.memcache_query_is_updated, false);
		
		return items;
	}
}
