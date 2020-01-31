package br.com.compra.rapida.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compra.rapida.domain.Categoria;
import br.com.compra.rapida.repositories.CategoriasRepository;

@Service
public class CategoriaService {
	@Autowired
	CategoriasRepository repo;

	public Categoria buscar() {
		return null;
		
		//repo.//problemas com versão de jpad
		
	}
}
