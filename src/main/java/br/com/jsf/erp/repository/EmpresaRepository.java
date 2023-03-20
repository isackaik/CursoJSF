package br.com.jsf.erp.repository;

import java.io.Serializable;
import java.util.List;

import br.com.jsf.erp.model.Empresa;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class EmpresaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	public EmpresaRepository() {

	}

	public EmpresaRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Empresa findById(Long id) {
		return manager.find(Empresa.class, id);
	}

	public List<Empresa> pesquisar(String nome) {
		String jpql = "from Empresa where nomeFantasia like :nomeFantasia";

		TypedQuery<Empresa> query = manager.createQuery(jpql, Empresa.class);

		query.setParameter("nomeFantasia", nome + "%");

		return query.getResultList();
	}

	public Empresa guardar(Empresa empresa) {
		return manager.merge(empresa);
	}

	public void remover(Empresa empresa) {
		empresa = findById(empresa.getId());
		manager.remove(empresa);
	}
}
