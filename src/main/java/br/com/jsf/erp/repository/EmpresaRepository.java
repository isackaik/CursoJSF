package br.com.jsf.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jsf.erp.model.Empresa;

public class EmpresaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public EmpresaRepository() {

	}

	public EmpresaRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Empresa findById(Long id) {
		return manager.find(Empresa.class, id);
	}

	public List<Empresa> todas() {
		 return manager.createQuery("from Empresa ", Empresa.class).getResultList();
	}

	public Empresa guardar(Empresa empresa) {
		return manager.merge(empresa);
	}

	public void remover(Empresa empresa) {
		empresa = findById(empresa.getId());
		manager.remove(empresa);
	}
}
