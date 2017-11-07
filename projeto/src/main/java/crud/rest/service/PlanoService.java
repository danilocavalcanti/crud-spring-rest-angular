package crud.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.rest.model.Plano;
import crud.rest.repository.ClienteRepository;
import crud.rest.repository.PlanoRepository;

@Service
public class PlanoService {

	@Autowired
	PlanoRepository repository;

	@Autowired
	ClienteRepository clienteRepository;

	public void criarPlano(String nomePlano) {
		repository.saveAndFlush(new Plano(nomePlano));
	}
}
