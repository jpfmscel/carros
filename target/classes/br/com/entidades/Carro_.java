package br.com.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-10-28T12:27:09.743-0200")
@StaticMetamodel(Carro.class)
public class Carro_ {
	public static volatile SingularAttribute<Carro, Integer> id;
	public static volatile SingularAttribute<Carro, Marca> marca;
	public static volatile SingularAttribute<Carro, Modelo> modelo;
	public static volatile SingularAttribute<Carro, String> cor;
	public static volatile SingularAttribute<Carro, String> placa;
	public static volatile SingularAttribute<Carro, Boolean> automatico;
}
