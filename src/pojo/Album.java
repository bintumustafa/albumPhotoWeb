package pojo;

import java.util.Date;

public class Album {
	private String nomAlb;
	private String idAlb;
	private Date dateCreationAlb;
	private User albOwner;
	
	public Album(String nomAlb, String idAlb, Date dateCreationAlb, User albOwner) {
		super();
		this.nomAlb = nomAlb;
		this.idAlb = idAlb;
		this.dateCreationAlb = dateCreationAlb;
		this.albOwner = albOwner;
	}

	public Album(String nomAlb) {
		this.nomAlb = nomAlb;	}

	public String getNomAlb() {
		return nomAlb;
	}

	public void setNomAlb(String nomAlb) {
		this.nomAlb = nomAlb;
	}

	public String getIdAlb() {
		return idAlb;
	}

	public void setIdAlb(String idAlb) {
		this.idAlb = idAlb;
	}

	public Date getDateCreationAlb() {
		return dateCreationAlb;
	}

	public void setDateCreationAlb(Date dateCreationAlb) {
		this.dateCreationAlb = dateCreationAlb;
	}

	public User getAlbOwner() {
		return albOwner;
	}

	public void setAlbOwner(User albOwner) {
		this.albOwner = albOwner;
	}
	
}
