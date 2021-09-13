package WebBackendBlog.models.service.intefaces;

import java.util.List;
import java.util.Optional;
import WebBackendBlog.models.entities.Commentary;

public interface ICommentaryService {
	public void save(Commentary commentary);//c
	public Optional< Commentary> findById(Integer id);//consult
	public void delete (Integer id);//update
	public List<Commentary>findAll();//list
}
