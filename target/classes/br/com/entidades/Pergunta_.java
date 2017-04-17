package br.com.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-10-28T12:27:09.804-0200")
@StaticMetamodel(Pergunta.class)
public class Pergunta_ {
	public static volatile SingularAttribute<Pergunta, Integer> id;
	public static volatile SingularAttribute<Pergunta, Marca> marca;
	public static volatile SingularAttribute<Pergunta, Modelo> modelo;
	public static volatile SingularAttribute<Pergunta, String> estado;
	public static volatile SingularAttribute<Pergunta, String> cidade;
	public static volatile SingularAttribute<Pergunta, String> categoria;
	public static volatile SingularAttribute<Pergunta, String> texto;
	public static volatile ListAttribute<Pergunta, Resposta> respostas;
}
