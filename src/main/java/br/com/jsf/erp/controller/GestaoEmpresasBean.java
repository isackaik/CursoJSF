package br.com.jsf.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jsf.erp.model.Empresa;
import br.com.jsf.erp.model.RamoAtividade;
import br.com.jsf.erp.model.TipoEmpresa;
import br.com.jsf.erp.repository.EmpresaRepository;
import br.com.jsf.erp.repository.RamoAtividadeRepository;
import br.com.jsf.erp.service.CadastroEmpresaService;
import br.com.jsf.erp.util.FacesMessages;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmpresaRepository empresaRepository;

	@Inject
	private FacesMessages messages;

	@Inject
	private RamoAtividadeRepository ramoAtividadeRepository;
	
	@Inject
	private CadastroEmpresaService cadastroEmpresaService;

	private Converter ramoAtividadeConverter;
	
	private Empresa empresa;

	private List<Empresa> listaEmpresas;

	private String termoPesquisa;
	
	public void prepararNovaEmpresa() {
		empresa = new Empresa();
	}
	
	public void salvar() {
		cadastroEmpresaService.salvar(empresa);
		
		if (verificarPesquisa()) {
			pesquisar();
		}
		
		messages.info("Empresa cadastrada com sucesso!");
	}

	public void pesquisar() {
		listaEmpresas = empresaRepository.pesquisar(termoPesquisa);

		if (listaEmpresas.isEmpty()) {
			messages.info("Sem registros para essa consulta.");
		}
	}
	
	private boolean verificarPesquisa() {
		return termoPesquisa != null && "".equals(termoPesquisa);
	}
	public void todasEmpresas() {
		listaEmpresas = empresaRepository.todas();
	}

	public List<RamoAtividade> completarRamoAtividade(String termo) {
		List<RamoAtividade> listaRamoAtividades = ramoAtividadeRepository.pesquisar(termo);

		ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividades);

		return listaRamoAtividades;
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

	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}

	public Converter getRamoAtividadeConverter() {
		return ramoAtividadeConverter;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

}
