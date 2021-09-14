package WebBackendBlog.models.service.implementation;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WebBackendBlog.models.entities.Commentary;
import WebBackendBlog.models.repositories.ICommentary;
import WebBackendBlog.models.service.intefaces.ICommentaryService;

@Service
public class CommentaryService implements ICommentaryService{

	@Autowired
	ICommentary repository;
	
	@Override
	@Transactional
	public void save(Commentary commentary) {
		// TODO Auto-generated method stub
		repository.save(commentary);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Commentary> findById(Integer id) {
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
	public List<Commentary> findAll() {
		// TODO Auto-generated method stub
		return (List<Commentary>) repository.findAll();
	}
	

}
