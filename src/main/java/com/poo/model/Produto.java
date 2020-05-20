package com.poo.model;

/**
 * 15/05/2020 20:55
 * @author Fabio
 */

public class Produto {
	
	private Integer id;
	private String nome;
	protected Float preco;
	private Integer quantidade;
	private String descricao;
	private String categoria;
	private String situacao;
	protected Integer qtdItem;
	
	public Produto() {
	
	}
	
	public Produto(Integer id) {
		this.id = id;
	}

	public Produto(Integer id, String nome, Float preco, Integer quantidade, String descricao, String categoria,
			String situacao) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.categoria = categoria;
		this.situacao = situacao;
	}
	
	

	public Produto(Integer id, String nome, Float preco, Integer quantidade, String categoria) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.categoria = categoria;
	}
	
	

	public Produto(Integer id, String nome, Float preco, Integer quantidade) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Integer getQtdItem() {
		return qtdItem;
	}

	public void setQtdItem(Integer qtdItem) {
		this.qtdItem = qtdItem;
	}
	

}
