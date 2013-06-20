package sonola.appengine.datastore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sonola.appengine.constants.Constant;
import sonola.appengine.models.Item;

public class FrontDatabase {

	@SuppressWarnings("unchecked")
	public List<Item> readDatabase() {

		Map<String, String> keyIds = new HashMap<String, String>();
		keyIds = (HashMap<String, String>) CacheUtil
				.getfromCache(Constant.memcache_keyId_List);

		Boolean memcache_needs_update = (Boolean) CacheUtil
				.getfromCache(Constant.memcache_query_is_updated);
		
		if (memcache_needs_update == null || keyIds == null) {
			return query_Database();
		} else {
			if ((boolean) memcache_needs_update) {

				return query_Database();

			} else
				return query_Memcache(keyIds);
		}

	}

	public void update_Memcache() {

	}

	public List<Item> query_Memcache(Map<String, String> keyIds) {
		List<Item> items = new ArrayList<Item>();
		for (Map.Entry<String, String> entry : keyIds.entrySet()) {
			items.add((Item) CacheUtil.getfromCache(entry.getValue()));
		}

		return items;
	}

	public List<Item> query_Database() {
		ReadDatabase readdatabase = new ReadDatabase();
		return readdatabase.readDatabase();

	}
}
