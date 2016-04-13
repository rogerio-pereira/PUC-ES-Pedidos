package br.pucminas.pedidos.testes;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.pucminas.pedidos.dominio.Produto;
import br.pucminas.pedidos.dominio.Pedido;


public class TestaOcalculoDoTotalDoPedido {
	private static 	Produto caneta;
	private static 	Produto lapis;
	private 		Pedido 	pedido;
	
	/*
	 * -----------------------------------------------------------------------
	 * CONFIGURAÇÕES DA CLASSE
	 * -----------------------------------------------------------------------
	 */
	@BeforeClass
	public static void configuraClasseDeTeste()
	{
		caneta 	= new Produto(1, "Caneta", 1.50);
		lapis 	= new Produto(2, "Lapis", 1.00);
	}
	
	@Before
	public void configura()
	{
		pedido = new Pedido(0);
	}
	
	
	/*
	 * -----------------------------------------------------------------------
	 * TESTES
	 * -----------------------------------------------------------------------
	 */
	@Test
	public void oTotalDoPedidoDeveraRetornarZeroParaUmPedidoSemItens() 
	{
		assertEquals(0.0, pedido.calculaTotal(), 0.01);
	}

	@Test
	public void oTotalDoPedidoDeveraRetornarUmValorParaUmPedidoCom1Item() 
	{
		pedido.incluiItem(caneta, 2);
		
		assertEquals(3.0, pedido.calculaTotal(), 0.01);
	}

	@Test
	public void oTotalDoPedidoDeveraRetornarUmValorParaUmPedidoCom2Itens() 
	{
		pedido.incluiItem(caneta, 2);
		pedido.incluiItem(lapis, 3);

		assertEquals(6.0, pedido.calculaTotal(), 0.01);
	}
	
	/*
	 * -----------------------------------------------------------------------
	 * DESCONFIGURAÇÕES DA CLASSE
	 * -----------------------------------------------------------------------
	 */
	@After
	public void desconfigura()
	{
		pedido = null;
	}
	
	@AfterClass
	public static void desconfiguraClasseDeTeste()
	{
		caneta 	= null;
		lapis 	= null;
	}
}