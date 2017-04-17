package br.com.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.google.gson.annotations.Expose;

@Entity
public class Pais implements Serializable {

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
	private String codigoFormat; //en_us, pt_br

}
