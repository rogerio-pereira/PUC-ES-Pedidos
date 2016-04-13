package br.pucminas.pedidos.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class Pedido {
	private int numero;
	private Calendar dataDaRealizacao;
	private Collection<ItemDoPedido> itensDoPedido;

	public Pedido(int numero) {
		this.numero = numero;
		this.dataDaRealizacao = Calendar.getInstance();
		this.itensDoPedido = new ArrayList<ItemDoPedido>();
	}

	public void incluiItem(Produto produto, double quantidade) {
		this.itensDoPedido.add(new ItemDoPedido(produto, quantidade));
	}

	public double calculaTotal(){
		double total = 0.0;
		for (ItemDoPedido itemDoPedido: itensDoPedido){
			total += itemDoPedido.calculaTotal();
		}
		return total;
	}
	
	//2% de desconto para 5 itens
	//3.5% para pedidos entre 5 e 8 itens
	//5% para pedidos com mais de 8 itens
	public double calculaDesconto()
	{
		int total = itensDoPedido.size();
		
		if(total < 5)
			return calculaTotal() * 0.02;
		else if(total > 8)
			return calculaTotal() * 0.05;
		else
			return calculaTotal() * 0.035;	
	}
	
	@Override
	public String toString() {
		return String.format("Pedido %03d# data=%2$te/%2$tm/%2$tY", this.numero,
				this.dataDaRealizacao);
	}
}
