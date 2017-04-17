package br.com.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;

@Entity
public class Pergunta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(nullable = false, insertable = false, updatable = false)
	@Expose
	private int id;

	@ManyToOne
	@Expose
	private Marca marca;

	@ManyToOne
	@Expose
	private Modelo modelo;

	@Column(nullable = true)
	@Expose
	private String estado;

	@Column(nullable = true)
	@Expose
	private String cidade;

	@Column(nullable = true)
	@Expose
	private String categoria;

	@Column(nullable = true)
	@Expose
	private String texto;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataCriada;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Expose
	private List<Resposta> respostas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<Resposta> getRespostas() {
		if (respostas == null) {
			respostas = new ArrayList<Resposta>();
		}
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	public Date getDataCriada() {
		if (dataCriada == null) {
			dataCriada = new Date();
		}
		return dataCriada;
	}

	public void setDataCriada(Date dataCriada) {
		this.dataCriada = dataCriada;
	}

}
