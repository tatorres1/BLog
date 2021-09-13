package WebBackendBlog.models.repositories;

import org.springframework.data.repository.CrudRepository;

import WebBackendBlog.models.entities.Publication;

public interface IPublication extends CrudRepository <Publication, Integer> {

}
