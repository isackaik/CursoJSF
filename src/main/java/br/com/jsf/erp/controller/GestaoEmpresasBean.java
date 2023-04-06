package br.com.jsf.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jsf.erp.model.Empresa;
import br.com.jsf.erp.repository.EmpresaRepository;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaRepository empresaRepository;
	
	private List<Empresa> listaEmpresas;
	
	public void todasEmpresas() {
		listaEmpresas = empresaRepository.todas();
	}
	
	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}
	
}
