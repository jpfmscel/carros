package br.com.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-10-28T12:27:09.795-0200")
@StaticMetamodel(Modelo.class)
public class Modelo_ {
	public static volatile SingularAttribute<Modelo, Integer> id;
	public static volatile SingularAttribute<Modelo, String> nome;
	public static volatile SingularAttribute<Modelo, Integer> anoFabricacao;
	public static volatile SingularAttribute<Modelo, Integer> anoModelo;
	public static volatile SingularAttribute<Modelo, BigDecimal> tamanhoMotor;
	public static volatile SingularAttribute<Modelo, Boolean> hibrido;
	public static volatile SingularAttribute<Modelo, String> codigoFipe;
}
