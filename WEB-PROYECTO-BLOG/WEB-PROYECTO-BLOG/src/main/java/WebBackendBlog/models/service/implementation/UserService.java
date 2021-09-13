package WebBackendBlog.models.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WebBackendBlog.models.entities.User;
import WebBackendBlog.models.repositories.IUser;
import WebBackendBlog.models.service.intefaces.IUserService;

//para el servicio debo agregar decorador define clase como servicio
@Service
public class UserService implements IUserService{
	
	@Autowired//realiza la inyeccion de dependencia
	IUser repository;//interfaz inyeccion de dependencia
	
	@Override
	@Transactional
	public void save(User user) {
		// TODO Auto-generated method stub
		repository.save(user);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional <User> findById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) repository.findAll();
	}

}
