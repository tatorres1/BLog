package WebBackendBlog.models.repositories;

import org.springframework.data.repository.CrudRepository;

import WebBackendBlog.models.entities.Commentary;

public interface ICommentary extends CrudRepository <Commentary, Integer> {

}
