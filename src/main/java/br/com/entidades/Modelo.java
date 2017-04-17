package br.com.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import com.google.gson.annotations.Expose;

import br.com.entidades.rest.VeiculoNivel1;

@Entity
public class Modelo implements Serializable {

	private static final long serialVersionUID = 1L;

	public Modelo() {
	}

	public Modelo(VeiculoNivel1 v1) {
		setNome(v1.getName());
	}

	@Id
	@GeneratedValue
	@Column(nullable = false, insertable = false, updatable = false)
	@Expose
	private int id;

	@Column(nullable = false)
	@Expose
	private String nome;

	@Column(nullable = true)
	@Expose
	private Integer anoFabricacao;

	@Column(nullable = true)
	@Expose
	private Integer anoModelo;

	@Column(nullable = true)
	@Expose
	private BigDecimal tamanhoMotor;

	@Column(nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean hibrido;

	@Column(nullable = true)
	@Expose
	private String codigoFipe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public BigDecimal getTamanhoMotor() {
		return tamanhoMotor;
	}

	public void setTamanhoMotor(BigDecimal tamanhoMotor) {
		this.tamanhoMotor = tamanhoMotor;
	}

	public Boolean getHibrido() {
		return hibrido;
	}

	public void setHibrido(Boolean hibrido) {
		this.hibrido = hibrido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoFabricacao == null) ? 0 : anoFabricacao.hashCode());
		result = prime * result + ((anoModelo == null) ? 0 : anoModelo.hashCode());
		result = prime * result + ((hibrido == null) ? 0 : hibrido.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tamanhoMotor == null) ? 0 : tamanhoMotor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modelo other = (Modelo) obj;
		if (anoFabricacao == null) {
			if (other.anoFabricacao != null)
				return false;
		} else if (!anoFabricacao.equals(other.anoFabricacao))
			return false;
		if (anoModelo == null) {
			if (other.anoModelo != null)
				return false;
		} else if (!anoModelo.equals(other.anoModelo))
			return false;
		if (hibrido == null) {
			if (other.hibrido != null)
				return false;
		} else if (!hibrido.equals(other.hibrido))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tamanhoMotor == null) {
			if (other.tamanhoMotor != null)
				return false;
		} else if (!tamanhoMotor.equals(other.tamanhoMotor))
			return false;
		return true;
	}

	public String getCodigoFipe() {
		return codigoFipe;
	}

	public void setCodigoFipe(String codigoFipe) {
		this.codigoFipe = codigoFipe;
	}

}
