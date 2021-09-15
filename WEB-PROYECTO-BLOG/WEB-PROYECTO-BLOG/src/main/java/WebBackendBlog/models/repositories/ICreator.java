package WebBackendBlog.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import WebBackendBlog.models.entities.Creator;

public interface ICreator extends CrudRepository <Creator,Integer>{
	
	@Query("SELECT C FROM Creator C WHERE C.Id_Creators = :c")
	public Creator findByIdCreators(String c);
}
