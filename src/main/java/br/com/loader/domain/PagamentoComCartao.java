package br.com.loader.domain;

import javax.persistence.Entity;

import br.com.loader.domain.enums.StatusPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {

	private static final long serialVersionUID = 1L;

	private Integer numDeParcelas;

	public PagamentoComCartao() {

	}

	public PagamentoComCartao(Integer id, StatusPagamento status, Pedido pedido, Integer numDeParcelas) {
		super(id, status, pedido);
		this.numDeParcelas = numDeParcelas;

	}

	public Integer getNumDeParcelas() {
		return numDeParcelas;
	}

	public void setNumDeParcelas(Integer numDeParcelas) {
		this.numDeParcelas = numDeParcelas;
	}

}
