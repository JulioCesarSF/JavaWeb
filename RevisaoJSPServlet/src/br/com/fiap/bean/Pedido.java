package br.com.fiap.bean;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Pedido implements Serializable{

	private int id;
	
	private int quarto;
	
	private double valor;
	
	private String descricao;
	
	private String status;
	
	private String dataPedido;

	public Pedido() {
		super();
	}

	public Pedido(int quarto, double valor, String descricao, String status,
			String dataPedido) {
		super();
		this.quarto = quarto;
		this.valor = valor;
		this.descricao = descricao;
		this.status = status;
		this.dataPedido = dataPedido;
	}
	public Pedido(int id, int quarto, double valor, String descricao, String status,
			String dataPedido) {
		super();
		this.id = id;
		this.quarto = quarto;
		this.valor = valor;
		this.descricao = descricao;
		this.status = status;
		this.dataPedido = dataPedido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuarto() {
		return quarto;
	}

	public void setQuarto(int quarto) {
		this.quarto = quarto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}
		
}
