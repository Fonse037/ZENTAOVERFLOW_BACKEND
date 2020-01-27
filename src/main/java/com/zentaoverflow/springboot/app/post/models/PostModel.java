package com.zentaoverflow.springboot.app.post.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"POST\"", schema = "public")
public class PostModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_post", nullable = false)
	private long id;
	@Column(name = "posttitle", nullable = false)
	private String posttitle;
	@Column(name = "postcontent", nullable = false)
	private String postcontent;
	@Column(name = "fk_id_user", nullable = false)
	private String fk_id_user;
	@Column(name = "views", nullable = false)
	private String views;
	@Column(name = "createdat", nullable = false)
	private Date createdat;
	@Column(name = "updatedat", nullable = false)
	private Date updatedat;
	@Column(name = "fk_id_status", nullable = false)
	private long fk_id_status;
	
    public PostModel() {
  	  
    } 
    
	public PostModel(String posttitle, String postcontent, String fk_id_user, String views, Date createdat,
			         Date updatedat, long fk_id_status) {
		this.posttitle = posttitle;
		this.postcontent = postcontent;
		this.fk_id_user = fk_id_user;
		this.views = views;
		this.createdat = createdat;
		this.updatedat = updatedat;
		this.fk_id_status = fk_id_status;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPosttitle() {
		return posttitle;
	}
	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}
	public String getPostcontent() {
		return postcontent;
	}
	public void setPostcontent(String postcontent) {
		this.postcontent = postcontent;
	}
	public String getFk_id_user() {
		return fk_id_user;
	}
	public void setFk_id_user(String fk_id_user) {
		this.fk_id_user = fk_id_user;
	}
	public String getViews() {
		return views;
	}
	public void setViews(String views) {
		this.views = views;
	}
	public Date getCreatedat() {
		return createdat;
	}
	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}
	public Date getUpdatedat() {
		return updatedat;
	}
	public void setUpdatedat(Date updatedat) {
		this.updatedat = updatedat;
	}
	public long getFk_id_status() {
		return fk_id_status;
	}
	public void setFk_id_status(long fk_id_status) {
		this.fk_id_status = fk_id_status;
	}

	@Override
    public String toString() {
        return "PostModel[id=" + id + ", posttitle=" + posttitle + ", postcontent=" + postcontent + ", fk_id_user=" + fk_id_user
        + ", views=" + views + ", createdat=" + createdat + ", updatedat=" + updatedat + ", fk_id_status=" + fk_id_status + "]";
    }
	
}
