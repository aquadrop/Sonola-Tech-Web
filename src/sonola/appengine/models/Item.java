package sonola.appengine.models;

import java.io.Serializable;

import javax.persistence.Entity;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.datastore.Text;
@Entity
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2573340157138890951L;

	private Key key = null;
	
	private BlobKey blobkey = null;
	private String blobkey_str = null;
	private String title = null;
	private Text description = null;
	
	//only for readdatabase
	private String description_str = null;
	
	private String imgUrl = null;

	//for readdatabase
	public void setKey(Key key){
		this.key = key;
	}
	
	public void setBlobKey(BlobKey blobkey) {
		this.blobkey = blobkey;
		setBlobKeyStr(blobkey.getKeyString());
	}
	
	public void setBlobKeyStr(String blobkey_str){
		this.blobkey_str = blobkey_str;
		this.blobkey = new BlobKey(blobkey_str);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(Text description) {
		this.description = description;
	}

	public void setDescriptionStr(String description_str){
		this.description_str = description_str;
	}
	
	public void setImgUrl(String imgurl){
		this.imgUrl = imgurl;
	}
	
	@SuppressWarnings("deprecation")
	public void setImgUrl(){
		ImagesService imageService = ImagesServiceFactory.getImagesService();
		this.imgUrl = imageService.getServingUrl(this.blobkey, 512, false);
	}
	
	public Key getKey(){
		return this.key;
	}
	
	public BlobKey getBlobKey() {
		return this.blobkey;
	}

	public String getBlobKeyStr() {
		return this.blobkey_str;
	}

	public String getTitle() {
		return this.title;
	}

	public Text getDescription() {
		return this.description;
	}
	
	public String getDescriptionStr(){
		return this.description_str;
	}
	
	public String getImgUrl(){
		return this.imgUrl;
	}
	
}
