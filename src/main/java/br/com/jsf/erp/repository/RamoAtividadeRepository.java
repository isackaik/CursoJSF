package br.com.jsf.erp.repository;

import java.io.Serializable;
import java.util.List;

import br.com.jsf.erp.model.RamoAtividade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class RamoAtividadeRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	public RamoAtividadeRepository() {

	}

	public RamoAtividadeRepository(EntityManager manager) {
		this.manager = manager;
	}

	public List<RamoAtividade> pesquisar(String descricao) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();

		CriteriaQuery<RamoAtividade> criteriaQuery = criteriaBuilder.createQuery(RamoAtividade.class);
		Root<RamoAtividade> root = criteriaQuery.from(RamoAtividade.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.like(root.get("descricao"), descricao + "%"));

		TypedQuery<RamoAtividade> query = manager.createQuery(criteriaQuery);

		return query.getResultList();
	}

}
