package br.pucminas.pedidos.dominio;

public class Produto {

	private int codigo;
	private String nome;
	private double preco;

	public Produto(int codigo, String nome, double preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}

	public int obtemCodigo() {
		return this.codigo;
	}

	public String obtemNome() {
		return this.nome;
	}

	public double obtemPreco() {
		return this.preco;
	}

	@Override
	public String toString() {
		return String.format("Produto %03d# nome=%s, preco=%.2f", this.codigo,
				this.nome, this.preco);
	}
}
