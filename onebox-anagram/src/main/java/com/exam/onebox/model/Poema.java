package com.exam.onebox.model;

import java.util.ArrayList;
import java.util.List;

public class Poema {

	List<String> lstVersos;

	public Poema(){
		this.lstVersos = new ArrayList<String>();
	}

	public List<String> getLstVersos() {
		return this.lstVersos;
	}

	public void setLstVersos(List<String> lstVersos) {
		this.lstVersos = lstVersos;
	}

	@Override
	public String toString() {
		return "Poema [lstVersos=" + this.lstVersos + "]";
	}

}
