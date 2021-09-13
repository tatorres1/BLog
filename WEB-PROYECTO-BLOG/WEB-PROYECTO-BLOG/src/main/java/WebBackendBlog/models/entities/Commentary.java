package WebBackendBlog.models.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name="Comments")
public class Commentary implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	@EmbeddedId
	private CommentaryKey id;
	
	@ManyToOne
	@MapsId("Id_User")
	@JoinColumn(name="IdUser")
	private User user;
	
	@ManyToOne
	@MapsId("Id_Publication")
	@JoinColumn(name="IdPublication")
	private Publication publication;
	
	@Column(name="Commentry")
	private String _Commentary;
	
	@Column(name="DateCommentary")
	private Date Date_Commentary;
	
	
	public Commentary() {
		super();
	}

	public Commentary(CommentaryKey id) {
		super();
		this.id = id;
	}

	public CommentaryKey getId() {
		return id;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String get_Commentary() {
		return _Commentary;
	}

	public void set_Commentary(String _Commentary) {
		this._Commentary = _Commentary;
	}

	public Date getDate_Commentary() {
		return Date_Commentary;
	}

	public void setDate_Commentary(Date date_Commentary) {
		Date_Commentary = date_Commentary;
	}

	public void setId(CommentaryKey id) {
		this.id = id;
	}

	
}
