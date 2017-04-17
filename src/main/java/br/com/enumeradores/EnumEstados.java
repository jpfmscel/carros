package br.com.enumeradores;


public enum EnumEstados {

	RO(11,"RO","Rondônia"),
	AC(12,"AC","Acre"),
	AM(13,"AM","Amazonas"),
	RR(14,"RR","Roraima"),
	PA(15,"PA","Pará"),
	AP(16,"AP","Amapá"),
	TO(17,"TO","Tocantins"),
	MA(21,"MA","Maranhão"),
	PI(22,"PI","Piauí"),
	CE(23,"CE","Ceará"),
	RN(24,"RN","Rio Grande do Norte"),
	PB(25,"PB","Paraíba"),
	PE(26,"PE","Pernambuco"),
	AL(27,"AL","Alagoas"),
	SE(28,"SE","Sergipe"),
	BA(29,"BA","Bahia"),
	MG(31,"MG","Minas Gerais"),
	ES(32,"ES","Espírito Santo"),
	RJ(33,"RJ","Rio de Janeiro"),
	SP(35,"SP","São Paulo"),
	PR(41,"PR","Paraná"),
	SC(42,"SC","Santa Catarina"),
	RS(43,"RS","Rio Grande do Sul"),
	MS(50,"MS","Mato Grosso do Sul"),
	MT(51,"MT","Mato Grosso"),
	GO(52,"GO","Goiás"),
	DF(53,"DF","Distrito Federal");

	private final int codigoIbge;
	private final String nome;
	private final String sigla;

	private EnumEstados(int codigoIbge, String sigla, String nome) {
		this.codigoIbge = codigoIbge;
		this.nome = nome;
		this.sigla = sigla;
	}
	
	public String getCodigo() {
		return Integer.toString(codigoIbge);
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getCodigoIbge(){
		return codigoIbge;
	}

	public String getSigla() {
		return sigla;
	}
}