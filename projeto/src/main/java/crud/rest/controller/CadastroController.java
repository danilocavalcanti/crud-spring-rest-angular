package crud.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CadastroController {

	@RequestMapping(value = "/cadastro")
	public String cadastro() {
		return "cadastro";
	}
}
