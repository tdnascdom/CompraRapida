package br.com.loader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.loader.domain.Categoria;

@SpringBootApplication
public class TesteJPA {

	public static void main(String[] args) {
		SpringApplication.run(CompraRapidaApplication.class, args);
		
		Categoria p1 = new Categoria(null, "Informatica");
		Categoria p2 = new Categoria(null,"Escritorio");
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("data-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();		
		em.persist(p1);// criando dados na base
		em.persist(p2);
		
		
		//Produto p = em.find(Produto.class, 3);//busca antes de remover	
		
		//em.remove(p);//remove apenas entidade monitoradas
		
		em.getTransaction().commit();//usa_lo sempre que for uma transação que não seja uma simples consulta 
		System.out.println("pronto!");
		//emf.close();
		//em.close();
		
		
	}

}
