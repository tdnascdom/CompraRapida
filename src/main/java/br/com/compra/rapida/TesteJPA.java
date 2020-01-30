package br.com.compra.rapida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.compra.rapida.dominio.Produto;

@SpringBootApplication
public class TesteJPA {

	public static void main(String[] args) {
		SpringApplication.run(CompraRapidaApplication.class, args);
		
		Produto p1 = new Produto(null, 123456, "Mouse", "informatica");
		Produto p2 = new Produto(null, 123456, "Mouse", "informatica");
		Produto p3 = new Produto(null, 123456, "Mouse", "informatica");
		Produto p4 = new Produto(null, 123456, "Mouse", "informatica");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("data-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();		
		em.persist(p1);// criando dados na base
		em.persist(p2);
		em.persist(p3); 
		em.persist(p4);		
		
		//Produto p = em.find(Produto.class, 3);//busca antes de remover	
		
		//em.remove(p);//remove apenas entidade monitoradas
		
		em.getTransaction().commit();//usa_lo sempre que for uma transação que não seja uma simples consulta 
		System.out.println("pronto!");
		emf.close();
		em.close();
		
		
	}

}
