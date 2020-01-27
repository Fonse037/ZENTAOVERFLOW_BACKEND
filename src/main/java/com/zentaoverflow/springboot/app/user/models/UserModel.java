package com.zentaoverflow.springboot.app.user.models;
import java.util.Date;

//package net.guides.springboot2.crud.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"USER\"", schema = "public")
public class UserModel {
	
			
    	@Id
    	@GeneratedValue(strategy = GenerationType.IDENTITY)
    	@Column(name = "id_user", nullable = false)
	    private long id;
    	@Column(name = "username", nullable = false)
	    private String username;
    	@Column(name = "usersurname", nullable = false)
	    private String usersurname;
    	@Column(name = "useremail", nullable = false)
	    private String usermail;
    	@Column(name = "userpwd", nullable = false)
	    private String userpwd;
    	@Column(name = "createdat", nullable = false)
	    private Date createdat;
    	@Column(name = "updatedat", nullable = false)
	    private Date updatedat;
    	@Column(name = "fk_id_status", nullable = false)
	    private long fk_id_status;
	    
	 
	    public UserModel() {
	  
	    }
	 
	    public UserModel(String username, String usersurname, String usermail, String userpwd, Date createdat, Date updatedat, long fk_id_status) {
	         this.username = username;
	         this.usersurname = usersurname;
	         this.usermail = usermail;
	         this.userpwd = userpwd;
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
	 
	    
	    public String getUsername() {
	        return username;
	    }
	    public void setUsername(String username) {
	        this.username = username;
	    }
	 
	    
	    public String getUsersurname() {
	        return usersurname;
	    }
	    public void setUsersurname(String usersurname) {
	        this.usersurname = usersurname;
	    }
	 
	   
	    public String getUsermail() {
	        return usermail;
	    }
	    public void setUsermail(String usermail) {
	        this.usermail = usermail;
	    }

	    
	    public String getUserpwd() {
			return userpwd;
		}

		public void setUserpwd(String userpwd) {
			this.userpwd = userpwd;
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
	        return "UserModel[id=" + id + ", username=" + username + ", usersurname=" + usersurname + ", usermail=" + usermail
	        + ", userpwd=" + userpwd + ", createdat=" + createdat + ", updatedat=" + updatedat + ", fk_id_status=" + fk_id_status + "]";
	    }
	 
	
}
