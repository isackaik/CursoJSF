package br.com.jsf.erp.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.jsf.erp.model.Empresa;
import br.com.jsf.erp.model.TipoEmpresa;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Empresa empresa;
	
	public void salvar() {
		System.out.println("Razão social: " + empresa.getRazaoSocial()
						+ " - Nome Fantasia: " + empresa.getNomeFantasia()
						+ " - CNPJ: " + empresa.getCnpj()
						+ " - Tipo: " + empresa.getTipo());
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}
	
}
