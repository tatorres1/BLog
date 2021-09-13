package WebBackendBlog.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import WebBackendBlog.models.entities.Publication;
import WebBackendBlog.models.service.intefaces.IPublicationService;



@RestController
@RequestMapping("/publication")
public class PublicationController {
	@Autowired
	IPublicationService service;
		
	//CRUD - L
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Publication v) {
		try {
			service.save(v);
			return ResponseEntity.status(HttpStatus.CREATED).body("La publicacion se creo satisfactoriamente");
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<Publication> v = service.findById(id);
			if(v.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Publicacion no encontrada");
			}
			return ResponseEntity.ok(v);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Publication v) {
		try {
			v.setId_Publication(id);
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
			Optional<Publication> v = service.findById(id);
			if(v.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Publication no encontrada");
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
			List<Publication> vars = service.findAll();
			if(vars.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay Publicationes registradas");
			}
			return ResponseEntity.ok(vars);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}

}
