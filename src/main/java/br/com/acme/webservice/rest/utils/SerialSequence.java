package br.com.acme.webservice.rest.utils;

import java.util.UUID;

public class SerialSequence {

	
	/**
	 * @author jean.bezerra
	 * @return String
	 * Retorna uma identificação única para a nomeclatura do arquivo
	 * @since 01/10/2017
	 */
	public static String serialGen() {

		try {

			UUID uniqueSerial = UUID.randomUUID();
			return uniqueSerial.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
