package crud.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crud.rest.service.PlanoService;

@RestController
@RequestMapping("/plano")
public class PlanoController {

	@Autowired
	PlanoService service;

	@GetMapping(value = "/criar/{nomePlano}")
	public void criarPlano(@PathVariable String nomePlano) {
		service.criarPlano(nomePlano);
	}
}
