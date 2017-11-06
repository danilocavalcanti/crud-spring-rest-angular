package crud.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.rest.exception.NegocioException;
import crud.rest.model.Cliente;
import crud.rest.repository.ClienteRepository;
import crud.rest.repository.ClienteRepositoryCustom;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repository;
	
	@Autowired
	ClienteRepositoryCustom repositoryCustom;

	public Cliente encontrarPorId(Long id) throws NegocioException {

		if (id == null || id < 0) {
			throw new NegocioException("Id inválido!");
		}

		Cliente cliente = new Cliente();

		cliente = repository.findById(id);
		
		if (cliente == null) {
			throw new NegocioException("Cliente não encontrado!");
		}
//		
		return cliente;
	}
	
	public List<Cliente> listar() {
		return repository.findAll();
	}

	public List<Cliente> encontrarPorIdENome(Long id, String nome) {
		return repositoryCustom.encontrarPorIdENome(id, nome);
	}
}