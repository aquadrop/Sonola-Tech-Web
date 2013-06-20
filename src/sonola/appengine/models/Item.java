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
	private String title = null;
	private Text description = null;
	
	private String imgUrl = null;

	public void setKey(Key key){
		this.key = key;
	}
	
	public void setBlobKey(BlobKey blobkey) {
		this.blobkey = blobkey;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(Text description) {
		this.description = description;
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


	public String getTitle() {
		return this.title;
	}

	public Text getDescription() {
		return this.description;
	}
	
	
	public String getImgUrl(){
		return this.imgUrl;
	}
	
}
