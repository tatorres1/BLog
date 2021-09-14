package WebBackendBlog.models.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WebBackendBlog.models.entities.Publication;
import WebBackendBlog.models.repositories.IPublication;
import WebBackendBlog.models.service.intefaces.IPublicationService;

@Service
public class PublicationService implements IPublicationService{

	@Autowired//realiza la inyeccion de dependencia
	IPublication repository;
	
	@Override
	@Transactional()
	public void save(Publication publication) {
		// TODO Auto-generated method stub
		repository.save(publication);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Publication> findById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	@Transactional()
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Publication> findAll() {
		// TODO Auto-generated method stub
		return (List<Publication>) repository.findAll();
	}

}
