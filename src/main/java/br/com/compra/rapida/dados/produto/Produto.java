package br.com.compra.rapida.dados.produto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer codigoProduto;
	private String nomeProduto;
	private String descricaoProduto;

	public Produto() {
	}

	public Produto(Integer id, Integer codigoProduto, String nomeProduto, String descricaoProduto) {
		super();
		this.id = id;
		this.codigoProduto = codigoProduto;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", codigoProduto=" + codigoProduto + ", nomeProduto=" + nomeProduto
				+ ", descricaoProduto=" + descricaoProduto + "]";
	}

}
