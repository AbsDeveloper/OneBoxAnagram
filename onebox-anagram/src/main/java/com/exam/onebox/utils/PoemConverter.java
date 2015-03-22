package com.exam.onebox.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

import com.exam.onebox.model.Poema;

public class PoemConverter {

	public static final int GRAFO_LENGHT = 3;

	private static final Logger log = Logger.getLogger(PoemConverter.class.getName());

	public static Poema fromFile(final BufferedReader bufferReader) throws IOException {
		String linea;
		Poema objPoema = null;

		if (bufferReader != null) {
			objPoema = new Poema();
			while ((linea = bufferReader.readLine()) != null) {
				// Cada linea del fichero equivale a un verso
				if (!linea.isEmpty()) {
					linea = PoemConverter.tratarLinea(linea);
					objPoema.getLstVersos().add(linea);
				}
			}
		}
		return objPoema;
	}

	public static String tratarLinea(String linea) {
		char[] arrLinea;
		PoemConverter.log.info("[tratarLinea] Linea original : " + linea);
		// todo a mayusculas
		linea = linea.toLowerCase();

		// Eliminamos tildes y caracteres especiales
		linea = PoemConverter.unificarTildes(linea);

		// eliminar caracteres extraños
		linea = linea.replaceAll("\\W", "");

		// Ordenamos los caracteres de la linea
		arrLinea = linea.toCharArray();
		Arrays.sort(arrLinea);
		linea = String.valueOf(arrLinea);

		PoemConverter.log.info("[tratarLinea] Linea final tratada : " + linea);

		return linea;
	}

	private static String unificarTildes(String input) {
		// Cadena de caracteres original a sustituir.
		String original = "áàäéèëíìïóòöúùuÁÀÄÉÈËÍÌÏÓÒÖÚÙÜ";
		// Cadena de caracteres ASCII que reemplazarán los originales.
		String ascii = "aaaeeeiiiooouuuAAAEEEIIIOOOUUU";
		String output = input;
		for (int i = 0; i < original.length(); i++) {
			// Reemplazamos los caracteres especiales.
			output = output.replace(original.charAt(i), ascii.charAt(i));
		}// for i
		return output;
	}

}
