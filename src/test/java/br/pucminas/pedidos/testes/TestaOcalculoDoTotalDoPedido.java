package br.pucminas.pedidos.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.pucminas.pedidos.dominio.Pedido;

public class TestaOcalculoDoTotalDoPedido {

	@Test
	public void oTotalDoPedidoDeveraRetornarZeroParaUmPedidoSemItens() {
		Pedido pedido = new Pedido(0);
		assertEquals(0.0, pedido.calculaTotal(), 0.01);
	}

}
