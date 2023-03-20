package br.com.jsf.erp.repository;

import java.util.List;

import br.com.jsf.erp.model.Empresa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class SchemaGeneration {
	
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoJSF");

		EntityManager em = emf.createEntityManager();
		
		List<Empresa> lista = em.createQuery("from Empresa", Empresa.class)
				.getResultList();
		
		System.out.println(lista);
		
		em.close();
		emf.close();
	}

}
