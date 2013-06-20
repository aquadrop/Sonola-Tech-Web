package sonola.appengine.datastore;

import java.util.List;

import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;

public class CacheUtil {

	private static MemcacheService keycache = MemcacheServiceFactory.getMemcacheService();
	
	public static void addtoCache(String key, Object value){
		keycache.put(key, value);
	}
	
	public static void deletefromCache(String key){
		keycache.delete(key);
	}
	
	public static void deletefromCache(List<String> keys){
		keycache.deleteAll(keys);
	}
	
	public static Object getfromCache(String key){
		return keycache.get(key);
	}
}
