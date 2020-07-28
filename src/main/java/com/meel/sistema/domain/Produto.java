package com.meel.sistema.domain;

import java.io.Serializable;

public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;

	public Produto() {
	}

	private Integer id;

	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
}
