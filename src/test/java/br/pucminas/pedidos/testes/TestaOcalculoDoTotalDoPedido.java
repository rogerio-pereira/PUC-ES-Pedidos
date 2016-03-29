package br.pucminas.pedidos.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.pucminas.pedidos.dominio.Pedido;import br.pucminas.pedidos.dominio.Produto;

public class TestaOcalculoDoTotalDoPedido {

	@Test
	public void oTotalDoPedidoDeveraRetornarZeroParaUmPedidoSemItens() {
		Pedido pedido = new Pedido(0);
		assertEquals(0.0, pedido.calculaTotal(), 0.01);
	}
	
	@Test
	public void oTotalDoPedidoDeveraRetornarSomaPedidoComUmItem() {
		Pedido pedido = new Pedido(1);
		Produto produto1 =  new Produto(1, "Produto 1", 20.0);
		pedido.incluiItem(produto1, 2);
		assertEquals(40.0, pedido.calculaTotal(), 0.01);
	}

}
