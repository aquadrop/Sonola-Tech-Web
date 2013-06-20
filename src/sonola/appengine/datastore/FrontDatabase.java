package sonola.appengine.datastore;

import java.util.List;

import sonola.appengine.models.Item;

public class FrontDatabase {

	public List<Item> readDatabase(){
		
//		boolean database_is_updated = (Boolean) CacheUtil.getfromCache("database_update");
//		boolean memcache_is_retrivable = (Boolean) CacheUtil.getfromCache("memcache_retrivable");
//		
//		if (database_is_updated)
//			update_Memcache();
//		if (memcache_is_retrivable)
//			query_Memcache();
//		else
		
		return query_Database();
		
	}
	
	public void update_Memcache(){
		
	}
	
	public void query_Memcache(){
		
	}
	
	public List<Item> query_Database(){
		ReadDatabase readdatabase = new ReadDatabase();
		return readdatabase.readDatabase();
		
	}
}
