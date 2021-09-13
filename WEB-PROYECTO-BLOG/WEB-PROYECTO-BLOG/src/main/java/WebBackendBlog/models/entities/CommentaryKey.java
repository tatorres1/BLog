package WebBackendBlog.models.entities;

import java.io.Serializable;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CommentaryKey implements Serializable {
	private static final long serialVersionUID =1L;
	
	@Column(name="IdUser")
	private Integer Id_User;
	
	@Column(name="IdPublication")
	private Integer Id_Publication;
	 
	
	public CommentaryKey(Integer id_User, Integer id_Publication) {
		super();
		Id_User = id_User;
		Id_Publication = id_Publication;
	}

	public CommentaryKey() {
		super();
	}
	
	public Integer getId_User() {
		return Id_User;
			
	}
	
	public void setId_User(Integer id_User) {
		Id_User = id_User;
	}
	public Integer getId_Publication() {
		return Id_Publication;
	}
	public void setId_Publication(Integer id_Publication) {
		Id_Publication = id_Publication;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id_Publication, Id_User);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentaryKey other = (CommentaryKey) obj;
		return Objects.equals(Id_Publication, other.Id_Publication) && Objects.equals(Id_User, other.Id_User);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
