package br.com.loader;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.loader.domain.Categoria;
import br.com.loader.repositories.CategoriaRepository;

@SpringBootApplication
public class CompraRapidaApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(CompraRapidaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		repo.saveAll(Arrays.asList(cat1, cat2));
	}

}
