package com.exam.onebox.actions;

import java.util.logging.Logger;

import com.exam.onebox.interfaces.Accion;
import com.exam.onebox.model.Poema;

public class AnagramicoAction implements Accion {

	private static final Logger log = Logger.getLogger( AnagramicoAction.class.getName() );

	private Poema poema;

	private String plantilla;

	/**
	 * Como tenemos cada verso ordenado alfabeticamente y hemos eliminado cualquier caracter especial
	 * Solo tenemos que coger el primer verso como plantilla y comprar con los demas, si uno de ellos
	 * no es anagramico, salimos.
	 */
	@Override
	public boolean execute() {

		boolean result = Boolean.TRUE;

		for (String verso : this.poema.getLstVersos()){
			if (!this.plantilla.equals(verso)){
				//Cuando un verso no sea anagrama, salimos
				result = Boolean.FALSE;
				break;
			}
		}

		return result;
	}

	@Override
	public void initialize(Poema pPoema) {
		this.poema = pPoema;
		//Pillamos el primer verso del poema, y al usaremos como plantilla
		//para comparar todos los demas casos

		if (pPoema != null && !pPoema.getLstVersos().isEmpty()){
			this.plantilla = pPoema.getLstVersos().get(0);
		}else{
			AnagramicoAction.log.severe("[initialize] Poema no valido");
			throw new IllegalArgumentException("Poema no valido!");
		}

	}

}
