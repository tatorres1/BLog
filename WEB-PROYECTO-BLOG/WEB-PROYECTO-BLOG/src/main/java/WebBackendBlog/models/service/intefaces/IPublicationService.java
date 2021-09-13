package WebBackendBlog.models.service.intefaces;

import java.util.List;
import java.util.Optional;
import WebBackendBlog.models.entities.Publication;


public interface IPublicationService {

	public void save(Publication publication);//c
	public Optional<Publication> findById(Integer id);//consult
	public void delete (Integer id);//update
	public List<Publication>findAll();//list
}
