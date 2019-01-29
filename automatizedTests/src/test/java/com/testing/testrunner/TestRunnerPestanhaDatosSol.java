package com.testing.testrunner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.testing.testcases.TCDatosSolicitantePestanha;

public class TestRunnerPestanhaDatosSol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String autor = "Yo";
		System.setProperty("autor", autor);
		
		Result result = JUnitCore.runClasses(TCDatosSolicitantePestanha.class);
		
		//Result result = JUnitCore.runClasses(TestCasesModificarEtiqueta.class, TestCaseGuardarFormulario.class, TestCaseClonarRequisito.class);
		
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
//			sc.close();
		}
		
	}

}
