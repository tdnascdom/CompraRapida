package br.com.loader.domain.enums;

public enum StatusPagamento {

	APROVADO(1, "Aprovado"), NEGADO(2, "Negado"), CANCELADO(3, "Negado"), PENDENTE(4, "Pendente");

	private int cod;
	private String descricao;

	private StatusPagamento(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusPagamento toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (StatusPagamento x : StatusPagamento.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido" + cod);

	}

}
