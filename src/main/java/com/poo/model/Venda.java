package com.poo.model;

/**
 * 15/05/2020 20:55
 * @author Fabio
 */

public class Venda extends Produto{

	
	private Integer idVenda;
	private String data;
	private String pagamento;
	private String parcelamento;
	private Float subTotal;
	private Integer idCliente;
	private Integer idFuncionario;
	
	
	public Venda() {
		
	}
	

	public Venda(Integer idVenda, String data, String pagamento, String parcelamento, Float subTotal) {
		this.idVenda = idVenda;
		this.data = data;
		this.pagamento = pagamento;
		this.parcelamento = parcelamento;
		this.subTotal = subTotal;
	}

	public Venda(Integer id,Integer idVenda, String data, String pagamento, String parcelamento, Float subTotal, Integer idCliente,Integer idFuncionario) {
		
		super(id);
		this.idVenda = idVenda;
		this.data = data;
		this.pagamento = pagamento;
		this.parcelamento = parcelamento;
		this.subTotal = subTotal;
		this.idCliente = idCliente;
		this.idFuncionario = idFuncionario;
	}
	
	
	
	public Venda(Integer id, String nome, Float preco, Integer quantidade, Integer idVenda, String data,
			String pagamento, String parcelamento, Float subTotal, Integer idCliente) {
		super(id, nome, preco, quantidade);
		this.idVenda = idVenda;
		this.data = data;
		this.pagamento = pagamento;
		this.parcelamento = parcelamento;
		this.subTotal = subTotal;
		this.idCliente = idCliente;
	}


	public Venda(Integer id, String nome, Float preco, Integer quantidade, Integer idVenda, String pagamento,
			Float subTotal) {
		super(id, nome, preco, quantidade);
		this.idVenda = idVenda;
		this.pagamento = pagamento;
		this.subTotal = subTotal;
	}



	public Venda(Integer id, String nome, Float preco, Integer quantidade, Integer idVenda, String data, String pagamento, Float subTotal) {
		super(id, nome, preco, quantidade);
		this.idVenda = idVenda;
		this.data = data;
		this.pagamento = pagamento;
		this.subTotal = subTotal;
	}

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	


	public String getParcelamento() {
		return parcelamento;
	}


	public void setParcelamento(String parcelamento) {
		this.parcelamento = parcelamento;
	}


	public Float getSubTotal() {
		  
		return subTotal ;
	}

	public void setSubTotal(Float subTotal) {
		this.subTotal = subTotal;
	}

	public Integer getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}



	public Integer getIdFuncionario() {
		return idFuncionario;
	}



	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
}

