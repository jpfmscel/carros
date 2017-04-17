package br.com.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-10-28T12:27:09.791-0200")
@StaticMetamodel(Imagem.class)
public class Imagem_ {
	public static volatile SingularAttribute<Imagem, Integer> id;
	public static volatile SingularAttribute<Imagem, String> nomeArquivo;
	public static volatile SingularAttribute<Imagem, byte[]> data;
	public static volatile SingularAttribute<Imagem, Date> dataCriado;
}
