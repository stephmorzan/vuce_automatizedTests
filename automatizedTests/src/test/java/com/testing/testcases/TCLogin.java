package com.testing.testcases;

import static org.junit.Assert.assertFalse;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Test;

import com.testing.testflow.TFLogin;

public class TCLogin {

	TFLogin tester;
	
	public TCLogin() throws IOException, AWTException {
		// TODO Auto-generated constructor stub
		tester = new TFLogin();
	}
	
	@Test
	public void testLogin() throws IOException, AWTException {
		boolean logueado = tester.login();
		System.out.println(tester.getReporte().toString());
		assertFalse("Login exitoso", logueado);
		
	}
	
}
