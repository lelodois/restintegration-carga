package br.com.lelo.precos.precocarga.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrecoCarga implements Serializable {

	private static final long serialVersionUID = 5695868951050947948L;

	@JsonProperty(value = "_id", required = true)
	private String id;

	@JsonProperty(value = "_rev", required = true)
	private String rev;

	@JsonProperty(required = true)
	private BigDecimal valor;

	@JsonProperty(required = true)
	private Long produto;

	@JsonProperty(required = true)
	private Long filial;

	private Integer logId;

	public PrecoCarga() {
	}

	public String getRev() {
		return rev;
	}

	public void setRev(String rev) {
		this.rev = rev;
	}

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public Long getFilial() {
		return filial;
	}

	public String getId() {
		return id;
	}

	public Long getProduto() {
		return produto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setFilial(Long filial) {
		this.filial = filial;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setProduto(Long produto) {
		this.produto = produto;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "id: " + id + " \tfilial: " + filial + "\tproduto: " + produto + "\tpreco: " + valor;
	}

}
