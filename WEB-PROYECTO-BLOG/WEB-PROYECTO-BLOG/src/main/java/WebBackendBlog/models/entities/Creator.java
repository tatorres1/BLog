package WebBackendBlog.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Creators")
public class Creator extends Person implements Serializable{
	private static final long serialVersionUID =1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Basic(optional = false)
	@Column(name="IdCreator")
	private Integer Id_Creator;

	@Column(name="IdCreators")
	private String Id_Creators;
	
	@Column(name="CreatorPassword")
	private String Creator_Password;

	public Creator() {
		super();
	}
	
	public Creator(int Id) {
		super();
		this.Id_Creator= Id;
	}

	public Integer getId_Creator() {
		return Id_Creator;
	}

	public void setId_Creator(Integer id_Creator) {
		Id_Creator = id_Creator;
	}

	public String getId_Creators() {
		return Id_Creators;
	}

	public void setId_Creators(String id_Creators) {
		Id_Creators = id_Creators;
	}

	public String getCreator_Password() {
		return Creator_Password;
	}

	public void setCreator_Password(String creator_Password) {
		Creator_Password = creator_Password;
	}





}












