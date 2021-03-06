package br.com.entidades;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.google.gson.annotations.Expose;

import br.com.util.Util;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(nullable = false, insertable = false, updatable = false)
	@Expose
	private int id;

	@Column(nullable = false)
	@Expose
	private String nome;

	@Column(nullable = false)
	@Expose
	private String email;

	@Column(nullable = false)
	@Expose
	private String senha;

	@Column(nullable = true)
	@Expose
	private String estado;

	@Column(nullable = true)
	@Expose
	private String cidade;

	@Column(nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean ativo = true;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@Expose
	private Date dataCriado;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Carro> carros;

	@Transient
	private String confirmacaoSenha;

	@Transient
	private List<Pergunta> perguntas;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public String getPrimeiroNome() {
		if (this.nome.contains(" ")) {
			return this.nome.substring(0, this.nome.indexOf(" "));
		}
		return this.nome;
	}

	public void setSenha(String senha) {
		// this.senha = getHexString(senha);
		this.senha = getEncodedPassword(senha);
	}

	private String getEncodedPassword(String senha) {
		return new String(Util.encodeBase64(senha.concat("acjp").getBytes()));
	}

	@SuppressWarnings("unused")
	private String getHexString(String s) {

		MessageDigest d = null;

		try {
			d = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		StringBuffer sb = new StringBuffer();
		byte[] b = d.digest(s.getBytes());
		for (int i = 0; i < b.length; i++) {
			sb.append(Integer.toHexString(0xFF & b[i]));
		}
		return sb.toString();
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = getEncodedPassword(confirmacaoSenha);
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Date getDataCriado() {
		return dataCriado;
	}

	public void setDataCriado(Date dataCriado) {
		this.dataCriado = dataCriado;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Usuario other = (Usuario) obj;
		if (ativo != other.ativo)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
