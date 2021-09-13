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
@Table(name="Users")
public class User extends Person implements Serializable {
	private static final long serialVersionUID =1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Basic(optional = false)
	@Column(name="IdUser")//para la columna
	private Integer Id_User;//para mapeo
	
	@Column(name="IdUsers")
	private String Id_Users;
	
	@Column(name="UserPassword")
	private String User_Password;

	public User() {
		super();
	}
	
	public User(int Id) {
		super();
		this.Id_User = Id;
	}
//G&S

	public Integer getId_User() {
		return Id_User;
	}

	public void setId_User(Integer id_User) {
		Id_User = id_User;
	}

	public String getId_Users() {
		return Id_Users;
	}

	public void setId_Users(String id_Users) {
		Id_Users = id_Users;
	}

	public String getUser_Password() {
		return User_Password;
	}

	public void setUser_Password(String user_Password) {
		User_Password = user_Password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}












