package br.com.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-10-28T12:27:09.793-0200")
@StaticMetamodel(Marca.class)
public class Marca_ {
	public static volatile SingularAttribute<Marca, Integer> id;
	public static volatile SingularAttribute<Marca, String> nome;
	public static volatile SingularAttribute<Marca, Pais> paisOrigem;
	public static volatile SingularAttribute<Marca, Integer> idFipe;
}
