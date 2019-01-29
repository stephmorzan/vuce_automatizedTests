package com.testing.propertiesReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


import com.testing.tool.cte.ValReportsCte;
import com.testing.tool.cte.BaseCte;
import com.testing.tool.cte.PathsCte;

public class PropertiesFileReader {

	private Properties properties;
	private final String propertyFilePath = PathsCte.PATH_DEFAULT;

	public PropertiesFileReader() {
		// TODO Auto-generated constructor stub
		BufferedReader reader;

		try {
			FileReader in = new FileReader(propertyFilePath);
			reader = new BufferedReader(in);
			properties = new Properties();

			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("config.properties no se encuentra en " + propertyFilePath);

		}
	}

	public String getLoginRuc() {
		String resultado = properties.getProperty(BaseCte.VTBA_RUC);
		if (resultado != null) {
			return resultado;
		}else {
			throw new RuntimeException("Url no esta especificado en archivo config.properties");
		}
	}
	
	public String getLoginUser() {
		String resultado = properties.getProperty(BaseCte.VTBA_USER);
		if (resultado != null) {
			return resultado;
		}else {
			throw new RuntimeException("Url no esta especificado en archivo config.properties");
		}
	}
	
	public String getUrlBase() {
		String resultado = properties.getProperty(BaseCte.VTBA_URLBASE);
		if (resultado != null) {
			return resultado;
		}else {
			throw new RuntimeException("Url no esta especificado en archivo config.properties");
		}
	}
	
	public String getCodActa() {
		String resultado = properties.getProperty(ValReportsCte.VREP_CODACTA);
		if (resultado != null) {
			return resultado;
		}else {
			throw new RuntimeException("Url no esta especificado en archivo config.properties");
		}
	}

	public String getFormatoActa() {
		String resultado = properties.getProperty(ValReportsCte.VREP_FORMATO);
		if (resultado != null) {
			return resultado;
		}else {
			throw new RuntimeException("Url no esta especificado en archivo config.properties");
		}
	}

	public String getNroTupaActa() {
		String resultado = properties.getProperty(ValReportsCte.VREP_NRO_TUPA);
		if (resultado != null) {
			return resultado;
		}else {
			throw new RuntimeException("Url no esta especificado en archivo config.properties");
		}
	}

	public String getVersionActa() {
		String resultado = properties.getProperty(ValReportsCte.VREP_VERSION);
		if (resultado != null) {
			return resultado;
		}else {
			throw new RuntimeException("Url no esta especificado en archivo config.properties");
		}
	}

	public String getUnidadOrgActa() {
		String resultado = properties.getProperty(ValReportsCte.VREP_UNID_ORG);
		if (resultado != null) {
			return resultado;
		}else {
			throw new RuntimeException("Url no esta especificado en archivo config.properties");
		}
	}
	
	/*
	 * Este método es solo para DGM007
	 */
	public String getTipoTramite() {
		String resultado = properties.getProperty("tipoTramite");
		if (resultado != null) {
			return resultado;
		}else {
			throw new RuntimeException("Url no esta especificado en archivo config.properties");
		}
	}
}
