package com.exam.onebox.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

import com.exam.onebox.actions.AnagramicoAction;
import com.exam.onebox.interfaces.Accion;
import com.exam.onebox.model.Poema;
import com.exam.onebox.utils.FileUtils;
import com.exam.onebox.utils.PoemConverter;

public class App {

	private static final Logger log = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {

		BufferedReader reader = null;
		Poema objPoema = null;
		Accion isAnagramicoAction = null;
		Boolean result = Boolean.FALSE;

		if (args.length != 1) {
			System.exit(1);
		}

		String filePoem = args[0];

		App.log.info("Parametro filePoem : " + filePoem);

		try {

			//Leemos fichero
			reader = FileUtils.getFileInputStream(filePoem);
			objPoema = PoemConverter.fromFile(reader);

			//inicializamos accion y ejecutamos
			isAnagramicoAction = new AnagramicoAction();
			isAnagramicoAction.initialize(objPoema);
			result = isAnagramicoAction.execute();

			//tratamos el resultado
			if (result){
				//Es anagrama
				App.log.info("SI es un poema anagramatico : " + result);
			}else{
				//No es anagrama
				App.log.info("NO es un poema anagramatico : " + result);
			}

		} catch (FileNotFoundException fnfe) {
			App.log.severe("[main] --> FileNotFoundException" + fnfe);
			System.exit(1);
		} catch (IOException ioe) {
			App.log.severe("[main] --> IOException" + ioe);
			System.exit(1);
		} catch (Exception e) {
			App.log.severe("[main] --> Exception" + e);
			System.exit(1);
		}
		System.exit(0);
	}
}
