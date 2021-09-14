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

import WebBackendBlog.models.entities.User;
import WebBackendBlog.models.service.intefaces.IUserService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserService service;

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody User v) {
		try {
			service.save(v);
			return ResponseEntity.status(HttpStatus.CREATED).body(v);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<User> v = service.findById(id);
			if(v.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
			}
			return ResponseEntity.ok(v);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody User v) {
		try {
			v.setId_User(id);
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
			Optional<User> v = service.findById(id);
			if(v.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuari@ no encontrad@");
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
			List<User> vars = service.findAll();
			if(vars.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay Usuari@s registrad@s");
			}
			return ResponseEntity.ok(vars);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	 
	//LOGIN!get inseguro!
	//primero el Post ya que recibo un user como es compuesto es body y es post 
	@PostMapping("/login")
	//paradevolverel codigo del stado y el body
	public ResponseEntity<?> Login(@RequestBody User v){
		//cuestiones de logica
		//dedicado a enviar codigos htttp
		try {
			//aqui devuelveel usuario con el id
			User u = service.findByIdUsers(v.getId_Users());
			//primero verifico si esta vacio luego crede
			if(u == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");		
			}
			//si el usuario no es nulo, means que el usuario paso pero verific a contrasena
			//si las dos correspondes, responde un ok
			if(u.getUser_Password().equals(v.getUser_Password())) {
				return ResponseEntity.status(HttpStatus.OK).body("Verified!");		
			}
			//si no hay ok es porque las contra no son iguales y regresa el no autorizado ya que si existe pero no es correcta
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error!");	
		}catch(Exception ex) {
			//falla de logica
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	
	
	
}







