package br.com.entidades.rest;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class VeiculoNivel1 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	private Integer id;

	@Expose
	private String name;

	@Expose
	private String fipe_name;

	@Expose
	private String key;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFipe_name() {
		return fipe_name;
	}

	public void setFipe_name(String fipe_name) {
		this.fipe_name = fipe_name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
