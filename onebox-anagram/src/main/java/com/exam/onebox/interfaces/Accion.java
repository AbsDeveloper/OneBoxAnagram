package com.exam.onebox.interfaces;

import com.exam.onebox.model.Poema;

public interface Accion {

	boolean execute();

	void initialize(final Poema pPoema);

}
