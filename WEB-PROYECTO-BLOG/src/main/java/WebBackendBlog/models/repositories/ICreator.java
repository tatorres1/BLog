package WebBackendBlog.models.repositories;

import org.springframework.data.repository.CrudRepository;

import WebBackendBlog.models.entities.Creator;

public interface ICreator extends CrudRepository <Creator,Integer>{
	

}
