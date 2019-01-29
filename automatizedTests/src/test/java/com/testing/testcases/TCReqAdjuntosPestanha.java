package com.testing.testcases;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import com.testing.testflow.TFPestanhaRequisitosAdjuntos;

public class TCReqAdjuntosPestanha {

	TFPestanhaRequisitosAdjuntos tester;

	public TCReqAdjuntosPestanha() throws IOException, AWTException {
		super();
		this.tester = new TFPestanhaRequisitosAdjuntos();
	}
	
	@Test
	public void testHabilitarTransmitir() {
		boolean resultado = tester.sePuedeTransmitir();
		System.out.println(tester.getReporte().toString());
		assertTrue(resultado);
	}
	
	@Ignore
	@Test
	public void testEntrarAPestanhaReqAdjs() {
		tester.listarRequisitosAdjuntos();
		System.out.println(tester.getReporte().toString());
		assertTrue(true);
	}
	
}
