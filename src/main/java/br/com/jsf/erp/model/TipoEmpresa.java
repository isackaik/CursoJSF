package br.com.jsf.erp.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public enum TipoEmpresa {
	
	MEI("Microempreendedor Individual"), 
	EIRELI("Empresa Individual de Responsabilidade Limitada"),
	LTDA("Sociedade Limitada"),
	SA("Sociedade Anônima");
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;

	TipoEmpresa(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
