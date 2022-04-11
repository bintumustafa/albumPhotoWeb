package pojo;

import java.io.InputStream;

public class Photo {
	//private String idPhoto;
	private String title;
	private String description;
	private String [] keywords;
	private InputStream img;
	private Album nomAlb;
	
	public Photo(String idPhoto, String title, String description, String[] keywords, InputStream img, Album nomAlb) {
		super();
		//this.idPhoto = idPhoto;
		this.title = title;
		this.description = description;
		this.keywords = keywords;
		this.img = img;
		this.nomAlb = nomAlb;
	}
	

	public Photo(InputStream img) {
		super();
		this.img = img;
	}


	/*public String getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(String idPhoto) {
		this.idPhoto = idPhoto;
	}*/

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	public InputStream getImg() {
		return img;
	}

	public void setImg(InputStream img) {
		this.img = img;
	}

	public Album getNomAlb() {
		return nomAlb;
	}

	public void setNomAlb(Album nomAlb) {
		this.nomAlb = nomAlb;
	}


	public String getPath() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	

}
