package crud.rest.repository;

import java.util.List;

import crud.rest.model.Cliente;

public interface ClienteRepositoryCustom {

	List<Cliente> encontrarPorIdENome(Long id, String nome);
}
