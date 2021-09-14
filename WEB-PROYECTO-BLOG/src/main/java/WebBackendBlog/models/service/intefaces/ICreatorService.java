package WebBackendBlog.models.service.intefaces;

import java.util.List;
import java.util.Optional;
import WebBackendBlog.models.entities.Creator;

public interface ICreatorService {
	
	public void save(Creator creator);//c
	public Optional< Creator> findById(Integer id);//consult
	public void delete (Integer id);//update
	public List<Creator>findAll();//list
}
