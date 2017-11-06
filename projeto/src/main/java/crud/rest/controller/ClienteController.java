package crud.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import crud.rest.exception.NegocioException;
import crud.rest.model.Cliente;
import crud.rest.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService service;

	@RequestMapping(value = "/encontrar/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> encontrarPorId(@PathVariable Long id) {
		Cliente cliente = null;
		try {
			cliente = service.encontrarPorId(id);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.FOUND);
		} catch (NegocioException e) {
			System.out.println(e.getMensagem());
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/listar", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> clientes = service.listar();
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.FOUND);
	}
	
	@GetMapping(value="/encontrar/{id}/{nome}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> encontrarPorIdENome(@PathVariable Long id, @PathVariable String nome) {
		List<Cliente> clientes = service.encontrarPorIdENome(id, nome);
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.FOUND);
	}

}
