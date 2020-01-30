package br.com.compra.rapida.entrada;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.compra.rapida.dominio.Categoria;

@RestController
@RequestMapping(value = "/compras")
public class ServicoRest {

	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> buscarCategorias() {
		Categoria cat1 = new Categoria(1, "Informatica");
		Categoria cat2 = new Categoria(2, "Escritório");
		List<Categoria> listaCategorias = new ArrayList<>();
		listaCategorias.add(cat1);
		listaCategorias.add(cat2);
		return listaCategorias;
	}

}
