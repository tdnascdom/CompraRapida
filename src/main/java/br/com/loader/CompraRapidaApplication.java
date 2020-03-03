package br.com.loader;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.loader.domain.Categoria;
import br.com.loader.domain.Cliente;
import br.com.loader.domain.Endereco;
import br.com.loader.domain.Estado;
import br.com.loader.domain.Municipio;
import br.com.loader.domain.Pagamento;
import br.com.loader.domain.PagamentoComBoleto;
import br.com.loader.domain.PagamentoComCartao;
import br.com.loader.domain.Pedido;
import br.com.loader.domain.Produto;
import br.com.loader.domain.enums.StatusPagamento;
import br.com.loader.domain.enums.TipoCliente;
import br.com.loader.repositories.CategoriaRepository;
import br.com.loader.repositories.ClienteRepository;
import br.com.loader.repositories.EnderecoRepository;
import br.com.loader.repositories.EstadoRepository;
import br.com.loader.repositories.MunicipioRepository;
import br.com.loader.repositories.PagamentoRepository;
import br.com.loader.repositories.PedidoRepository;
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
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;

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

//Associação Cliente Endereço e Telefone

		Cliente cli1 = new Cliente(null, 12121212, "Thiago", "Nascimento", "cpf", "420.776.528.02", Instant.now(),
				"tdnascdom@gmail.com", "tem interesse", TipoCliente.PESSOAFISICA);

		cli1.getTelefones().addAll(Arrays.asList("11968917627", "1125619275"));

		Endereco e1 = new Endereco(null, "Rua Bibliotecarios", "29", "casa", "mabel", "081217320", "brasil", muni1,
				cli1);
		Endereco e2 = new Endereco(null, "Rua Bibliotecarios", "29", "casa", "mabel", "081217320", "brasil", muni2,
				cli1);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		Pedido ped1 = new Pedido(null, Instant.parse("2020-12-03T10:15:30.00Z"), cli1, e1);
		Pedido ped2 = new Pedido(null, Instant.parse("2020-12-03T10:15:30.00Z"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, StatusPagamento.APROVADO, ped1, 12);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, StatusPagamento.NEGADO, ped2, Instant.parse("2020-12-03T10:15:30.00Z"),
				Instant.parse("2020-12-03T10:15:30.00Z"));
		ped2.setPagamento(pagto2);

		cli1.setPedidos(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

	}

}
