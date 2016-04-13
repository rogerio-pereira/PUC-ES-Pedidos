package br.pucminas.pedidos.testes;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.pucminas.pedidos.dominio.Produto;
import br.pucminas.pedidos.dominio.Pedido;


public class TestaOcalculoDoDescontoDoPedido {
	private static 	Produto caneta;
	private static 	Produto lapis;
	private static 	Produto lapiseira;
	private static 	Produto regua;
	private static 	Produto borracha;
	private static 	Produto apontador;
	private static 	Produto grafite;
	private static 	Produto estojo;
	private static 	Produto caderno;
	private 		Pedido 	pedido;
	
	/*
	 * -----------------------------------------------------------------------
	 * CONFIGURAÇÕES DA CLASSE
	 * -----------------------------------------------------------------------
	 */
	@BeforeClass
	public static void configuraClasseDeTeste()
	{
		caneta 		= new Produto(1, "Caneta", 		1.00);
		lapis 		= new Produto(2, "Lapis", 		1.00);
		lapiseira 	= new Produto(3, "lapiseira", 	1.00);
		regua 		= new Produto(4, "Régua", 		1.00);
		borracha 	= new Produto(5, "Borracha", 	1.00);
		apontador 	= new Produto(6, "Apontador", 	1.00);
		grafite 	= new Produto(7, "Grafite", 	1.00);
		estojo 		= new Produto(8, "Estojo", 		1.00);
		caderno 	= new Produto(9, "Caderno", 	1.00);
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
	public void oTotalDoPedidoDeveraRetornarDescontoDeDoisPorcentoParaPedidosComAteCincoItens() 
	{
		pedido.incluiItem(caneta, 2);
		pedido.incluiItem(lapis, 2);
		pedido.incluiItem(lapiseira, 2);

		assertEquals(0.12, pedido.calculaDesconto(), 0.01);
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