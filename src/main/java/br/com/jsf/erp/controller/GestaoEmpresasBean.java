package br.com.jsf.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jsf.erp.model.Empresa;
import br.com.jsf.erp.repository.EmpresaRepository;
import br.com.jsf.erp.util.FacesMessages;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmpresaRepository empresaRepository;

	@Inject
	private FacesMessages messages;

	private List<Empresa> listaEmpresas;

	private String termoPesquisa;

	public void pesquisar() {
		listaEmpresas = empresaRepository.pesquisar(termoPesquisa);

		if (listaEmpresas.isEmpty()) {
			messages.info("Sem registros para essa consulta.");
		}
	}

	public void todasEmpresas() {
		listaEmpresas = empresaRepository.todas();
	}

	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}

}
