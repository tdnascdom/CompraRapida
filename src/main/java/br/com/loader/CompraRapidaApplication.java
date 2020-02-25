package br.com.loader;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.loader.domain.Categoria;
import br.com.loader.domain.Estado;
import br.com.loader.domain.Municipio;
import br.com.loader.domain.Produto;
import br.com.loader.repositories.CategoriaRepository;
import br.com.loader.repositories.EstadoRepository;
import br.com.loader.repositories.MunicipioRepository;
import br.com.loader.repositories.ProdutoRepository;

@SpringBootApplication
public class CompraRapidaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRespository;
	@Autowired
	private MunicipioRepository municipioRepository;

	public static void main(String[] args) {
		SpringApplication.run(CompraRapidaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, 324234324, "Notebook", "Computador", 1200.00, 0);
		Produto p2 = new Produto(null, 324234325, "Impressora", "Acessorio", 800.00, 0);
		Produto p3 = new Produto(null, 324234326, "Mouse", "Acessorio", 80.00, 0);

//Associando Categorias com Produtos
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

//Associando Produtos com Categorias
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

//Associação Municipio e Estado		
		Municipio muni1 = new Municipio(null, "Uberlândia", est1);
		Municipio muni2 = new Municipio(null, "São Paulo", est2);
		Municipio muni3 = new Municipio(null, "Campinas", est2);

//Associação Estado e Municipio			
		est1.getMunicipios().addAll(Arrays.asList(muni1));
		est1.getMunicipios().addAll(Arrays.asList(muni2, muni3));

		estadoRespository.saveAll(Arrays.asList(est1, est2));
		municipioRepository.saveAll(Arrays.asList(muni1, muni2, muni3));
	}

}
