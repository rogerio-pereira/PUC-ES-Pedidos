package br.pucminas.pedidos.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.pucminas.pedidos.dominio.Produto;
import br.pucminas.pedidos.dominio.Pedido;


public class TestaOcalculoDoTotalDoPedido {
	@Test
	public void oTotalDoPedidoDeveraRetornarZeroParaUmPedidoSemItens() {
		Pedido pedido = new Pedido(0);
		assertEquals(0.0, pedido.calculaTotal(), 0.01);
	}

	@Test
	public void oTotalDoPedidoDeveraRetornarUmValorParaUmPedidoCom1Item() {
		Pedido pedido = new Pedido(0);
		Produto caneta = new Produto(1, "Caneta", 1.50);
		pedido.incluiItem(caneta, 2);
		assertEquals(3.0, pedido.calculaTotal(), 0.01);
	}

	@Test
	public void oTotalDoPedidoDeveraRetornarUmValorParaUmPedidoCom2Itens() {

		Pedido pedido = new Pedido(0);
		Produto caneta = new Produto(1, "Caneta", 1.50);
		Produto lapis = new Produto(1, "Lápis", 1.00);

		pedido.incluiItem(caneta, 2);
		pedido.incluiItem(lapis, 3);

		assertEquals(6.0, pedido.calculaTotal(), 0.01);
	}
}