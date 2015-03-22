package com.exam.onebox.poem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.exam.onebox.actions.AnagramicoAction;
import com.exam.onebox.interfaces.Accion;
import com.exam.onebox.model.Poema;
import com.exam.onebox.utils.FileUtils;
import com.exam.onebox.utils.PoemConverter;

public class TestPoema {

	private static final String NOMBRE_FICHERO = "poema.txt";

	private Poema poema;

	private static final String LINEA_1 = "ábc";
	private static final String LINEA_2 = "aàá";
	private static final String LINEA_3 = "uié%";

	private static final String VALOR_ESPERADO_1 = "abc";
	private static final String VALOR_ESPERADO_2 = "aaa";
	private static final String VALOR_ESPERADO_3 = "eiu";

	@Before
	public void init() {
		BufferedReader reader;
		try {
			reader = FileUtils.getFileInputStream(TestPoema.NOMBRE_FICHERO);
			if (reader != null) {
				this.poema = PoemConverter.fromFile(reader);
			}
		} catch (FileNotFoundException e) {
			Assert.fail();
		} catch (IOException ioe) {
			Assert.fail();
		}

	}

	@Test
	public void testBuscadorRutas() {

		if (this.poema == null) {
			Assert.fail();
		}

		Accion isAnagramicoAction = new AnagramicoAction();
		isAnagramicoAction.initialize(this.poema);

		Assert.assertTrue(isAnagramicoAction.execute());

	}

	@Test
	public void testTratamientoLinea(){
		Assert.assertEquals(PoemConverter.tratarLinea(TestPoema.LINEA_1), TestPoema.VALOR_ESPERADO_1);
		Assert.assertEquals(PoemConverter.tratarLinea(TestPoema.LINEA_2), TestPoema.VALOR_ESPERADO_2);
		Assert.assertEquals(PoemConverter.tratarLinea(TestPoema.LINEA_3), TestPoema.VALOR_ESPERADO_3);
	}

}
