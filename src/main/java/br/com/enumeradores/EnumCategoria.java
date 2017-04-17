package br.com.enumeradores;

public enum EnumCategoria {

	

	ESTILO(1,"Estilo"),
	ACABAMENTO(2,"Acabamento"),
	POSICAO_DIRIGIR(3,"Posição de dirigir"),
	INSTRUMENTOS(4,"Instrumentos"),
	INTERIOR(5,"Interior"),
	PORTA_MALAS(6,"Porta-malas"),
	DESEMPENHO(7,"Desempenho"),
	MOTOR(8,"Motor"),
	CAMBIO(9,"Câmbio"),
	FREIOS(10,"Freios"),
	SUSPENSAO(11,"Suspensão"),
	CONSUMO(12,"Consumo"),
	ESTABILIDADE(13,"Estabilidade"),
	CUSTO_BENEFICIO(14,"Custo-Benefício"),
	RECOMENDACAO(15,"Recomendação");

	
	EnumCategoria (int id, String nome){
		this.id = id;
		this.nome = nome;
	}
	
	private int id;
	private String nome;
	
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
	
	
}
