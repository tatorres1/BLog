package WebBackendBlog.models.repositories;

import org.springframework.data.repository.CrudRepository;

import WebBackendBlog.models.entities.User;

public interface IUser extends CrudRepository <User,Integer>{

	
	
}
