package com.zentaoverflow.springboot.app.user.reply.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"REPLY\"", schema = "public")
public class ReplyModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reply", nullable = false)
    private long id;
	@Column(name = "replycontent", nullable = false)
    private String replycontent;
	@Column(name = "fk_id_post", nullable = false)
    private String fk_id_post;
	@Column(name = "createdat", nullable = false)
    private Date createdat;
	@Column(name = "updatedat", nullable = false)
    private Date updatedat;
	@Column(name = "fk_id_user", nullable = false)
    private String fk_id_user;
	@Column(name = "fk_id_status", nullable = false)
    private long fk_id_status;
     
    public ReplyModel() {
  
    }

	public ReplyModel(String replycontent, String fk_id_post, Date createdat, Date updatedat, String fk_id_user,
			          long fk_id_status) {
		super();
		this.replycontent = replycontent;
		this.fk_id_post = fk_id_post;
		this.createdat = createdat;
		this.updatedat = updatedat;
		this.fk_id_user = fk_id_user;
		this.fk_id_status = fk_id_status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReplycontent() {
		return replycontent;
	}

	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}

	public String getFk_id_post() {
		return fk_id_post;
	}

	public void setFk_id_post(String fk_id_post) {
		this.fk_id_post = fk_id_post;
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

	public String getFk_id_user() {
		return fk_id_user;
	}

	public void setFk_id_user(String fk_id_user) {
		this.fk_id_user = fk_id_user;
	}

	public long getFk_id_status() {
		return fk_id_status;
	}

	public void setFk_id_status(long fk_id_status) {
		this.fk_id_status = fk_id_status;
	}
	
	@Override
    public String toString() {
        return "ReplyModel[id=" + id + ", replycontent=" + replycontent + ", fk_id_post=" + fk_id_post + ", createdat=" + createdat
        		+ ", updatedat=" + updatedat + ", fk_id_user" + fk_id_user + ", fk_id_status=" + fk_id_status + "]";
    }

    
}
