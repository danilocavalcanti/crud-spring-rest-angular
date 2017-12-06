package crud.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crud.rest.exception.NegocioException;
import crud.rest.model.Cliente;
import crud.rest.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService service;

	@GetMapping(value = "/encontrar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> encontrarPorId(@PathVariable Long id) {
		Cliente cliente = null;
		try {
			cliente = service.encontrarPorId(id);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		} catch (NegocioException e) {
			System.out.println(e.getMensagem());
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> clientes = service.listar();
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}

	@GetMapping(value = "/encontrar/{id}/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> encontrarPorIdENome(
			@PathVariable Long id, @PathVariable String nome) {
		List<Cliente> clientes = service.encontrarPorIdENome(id, nome);
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}

	@PostMapping(value = "/criar/{nome}")
	public void novoClientePorNome(@PathVariable String nome) {
		service.novoClientePorNome(nome);
	}
	
	@PutMapping(value="/associar/{idCliente}/{idPlano}")
	public void associarClienteAPlano(@PathVariable Long idCliente, @PathVariable Long idPlano) {
		service.associarClienteAPlano(idCliente, idPlano);
	}
	
	@PostMapping(value="/criar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void criarByJson(@RequestBody Cliente cliente) {
		service.novoClientePorJson(cliente);
	}
}
