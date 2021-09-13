package WebBackendBlog.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import WebBackendBlog.models.entities.Commentary;
import WebBackendBlog.models.service.intefaces.ICommentaryService;
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

@RestController
@RequestMapping("/commentary")
public class CommentaryController {


	@Autowired
	ICommentaryService service;
		
	//CRUD - L
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Commentary v) {
		try {
			service.save(v);
			return ResponseEntity.status(HttpStatus.CREATED).body("El comentario se creo satisfactoriamente");
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<Commentary> v = service.findById(id);
			if(v.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comentario no encontrado");
			}
			return ResponseEntity.ok(v);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Commentary v) {
		try {
			//v.setId(id);
			service.save(v);
			return ResponseEntity.ok(v);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id) {
		try {
			Optional<Commentary> v = service.findById(id);
			if(v.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comentario no encontrado");
			}
			service.delete(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(v);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	//List
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			List<Commentary> vars = service.findAll();
			if(vars.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay comentarios registrados");
			}
			return ResponseEntity.ok(vars);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}

	
}
