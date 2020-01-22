package br.com.compra.rapida.entrada;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produtos")
public class ServicoRest {
	String mensagem = "Rest ok!";
	
	@RequestMapping(method = RequestMethod.GET)
	public String buscarProdutos() {
		return mensagem;
	}

}
