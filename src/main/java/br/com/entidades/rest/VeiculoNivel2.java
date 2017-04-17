package br.com.entidades.rest;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class VeiculoNivel2 implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Expose
	private String fipe_codigo;
	@Expose
	private String name;
	@Expose
	private String key;
	@Expose
	private String veiculo;
	@Expose
	private String id;

	public String getFipe_codigo() {
		return fipe_codigo;
	}

	public void setFipe_codigo(String fipe_codigo) {
		this.fipe_codigo = fipe_codigo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
