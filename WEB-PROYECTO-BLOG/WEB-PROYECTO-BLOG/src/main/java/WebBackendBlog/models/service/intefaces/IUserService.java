package WebBackendBlog.models.service.intefaces;

import java.util.List;
import java.util.Optional;
import WebBackendBlog.models.entities.User;

//Interfaz de servicio define cuales son los metodos
//interfaz porque inyeccion de dependencias elemento dentro de otro element
public interface IUserService {

	public void save(User user);//c
	public Optional< User> findById(Integer id);//consult
	public void delete (Integer id);//update
	public List<User>findAll();//list
	//funcion creada en IUser
	public User findByIdUsers(String u);
}
