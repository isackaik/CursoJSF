package br.com.jsf.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.jsf.erp.model.Empresa;
import br.com.jsf.erp.repository.EmpresaRepository;
import br.com.jsf.erp.util.Transacional;

public class CadastroEmpresaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaRepository empresas;
	
	@Transacional
	public void salvar(Empresa empresa) {
		empresas.guardar(empresa);
	}
	
	@Transacional
	public void excluir(Empresa empresa) {
		empresas.remover(empresa);
	}

}
