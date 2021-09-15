package WebBackendBlog.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import WebBackendBlog.models.entities.User;

public interface IUser extends CrudRepository <User,Integer>{
//existen los crud
	//se crea un met dif
	//Se hace una propia quer con el user que utilzp jpa
	//metodos base, al intentar crear metodos propios se iene a la I de usuario que es la conexion con la bd
	//el @Query es para trabajar con JPA y sepuede haceruna query propiapara obtenerun rest que queramos
	//aqui se devuelve un user que eseluser que se encuentra con el nombre
	//si TODOS LOS USER RTIENEN EL MISMO NOMBRE SE DEVUELVE EL PRIMERO
	@Query("SELECT U FROM User U WHERE U.Id_Users = :u")
	public User findByIdUsers(String u);

	
}
