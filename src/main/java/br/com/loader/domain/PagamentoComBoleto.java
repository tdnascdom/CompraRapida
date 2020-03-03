package br.com.loader.domain;

import java.time.Instant;

import javax.persistence.Entity;

import br.com.loader.domain.enums.StatusPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {

	private static final long serialVersionUID = 1L;

	private Instant dataPag;
	private Instant dataVenc;

	public PagamentoComBoleto() {

	}

	public PagamentoComBoleto(Integer id, StatusPagamento status, Pedido pedido, Instant dataPag, Instant dataVenc) {
		super(id, status, pedido);
		this.dataPag = dataPag;
		this.dataVenc = dataVenc;

	}

	public Instant getDataPag() {
		return dataPag;
	}

	public void setDataPag(Instant dataPag) {
		this.dataPag = dataPag;
	}

	public Instant getDataVenc() {
		return dataVenc;
	}

	public void setDataVenc(Instant dataVenc) {
		this.dataVenc = dataVenc;
	}

}
