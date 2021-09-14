package WebBackendBlog.models.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WebBackendBlog.models.entities.Creator;
import WebBackendBlog.models.repositories.ICreator;
import WebBackendBlog.models.service.intefaces.ICreatorService;

@Service
public class CreatorService implements ICreatorService {

	@Autowired//realiza la inyeccion de dependencia
	ICreator repository;
	
	@Override
	@Transactional
	public void save(Creator creator) {
		// TODO Auto-generated method stub
		repository.save(creator);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Creator> findById(Integer id) {
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
	public List<Creator> findAll() {
		// TODO Auto-generated method stub
		return (List<Creator>) repository.findAll();
	}

}
