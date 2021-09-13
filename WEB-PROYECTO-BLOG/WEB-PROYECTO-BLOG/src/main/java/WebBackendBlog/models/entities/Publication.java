package WebBackendBlog.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity //decorador
@Table(name="Publications")
public class Publication implements Serializable {
	private static final long serialVersionUID =1L;
	
	//identificador y decorador
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Basic(optional = false)
	@Column(name="IdPublication")
	private Integer Id_Publication;//clave primaria que se mapea con la clase primaria

	@Column(name="Title")
	private String _Title;
	
	@Column(name="DatePublication")
	private Date Date_Publication;
	
	@Column(name="Development")
	private String _Development;
	
	@Column(name="NumberPublication")
	private int Number_Publication;
	
	@Column(name="Rate")
	private int _Rate;

//dos constructores uno vacio y otro con la primary class
public Publication() {
	super();
}

public Publication(int Id) {
	super();
	this.Id_Publication = Id;
}

public Integer getId_Publication() {
	return Id_Publication;
}

public void setId_Publication(Integer id_Publication) {
	Id_Publication = id_Publication;
}

public String get_Title() {
	return _Title;
}

public void set_Title(String _Title) {
	this._Title = _Title;
}

public Date getDate_Publication() {
	return Date_Publication;
}

public void setDate_Publication(Date date_Publication) {
	Date_Publication = date_Publication;
}

public String get_Development() {
	return _Development;
}

public void set_Development(String _Development) {
	this._Development = _Development;
}

public int getNumber_Publication() {
	return Number_Publication;
}

public void setNumber_Publication(int number_Publication) {
	Number_Publication = number_Publication;
}

public int get_Rate() {
	return _Rate;
}

public void set_Rate(int _Rate) {
	this._Rate = _Rate;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}









}
//tipos de dato primitivo int, byte,short
