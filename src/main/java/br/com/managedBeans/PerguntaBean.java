package br.com.managedBeans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.entidades.Marca;
import br.com.entidades.Pergunta;
import br.com.entidades.Resposta;
import br.com.enumeradores.EnumCategoria;
import br.com.enumeradores.EnumEstados;
import br.com.service.PerguntaService;
import br.com.util.ListFactory;

@ManagedBean
@ViewScoped
public class PerguntaBean {

	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;

	@ManagedProperty("#{listFactory}")
	private ListFactory listFactory;

	@Inject
	private PerguntaService perguntaService;

	private Pergunta perguntaAdd;
	private Pergunta perguntaSelecionada;
	private Pergunta perguntaFilter;

	private Resposta respostaAdd;

	private List<String> perguntasFAQ;
	private List<Pergunta> perguntasFiltradas;

	@PostConstruct
	public void init() {
		String idPergunta = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("perguntaSelecionada");
		if (idPergunta != null) {
			setPerguntaSelecionada(perguntaService.buscarPorId(Integer.parseInt(idPergunta)));
		}
	}

	public void atualizaFAQ() {
		setPerguntasFAQ(null);
		if (getPerguntaAdd().getCategoria().equalsIgnoreCase("Motor")) {
			getPerguntasFAQ().add("Motor deu problema?");
			getPerguntasFAQ().add("Aceita gasolina + alcóol sem problema?");
		} else if (getPerguntaAdd().getCategoria().equalsIgnoreCase("Acabamento")) {
			getPerguntasFAQ().add("Os bancos de couro são resistentes?");
			getPerguntasFAQ().add("O painel é de plástico rígido?");
		}
	}

	public String verRespostas() {
		return "respostas";
	}

	public String responder() {
		return "responder";
	}

	public String adicionarResposta() {
		getPerguntaSelecionada().getRespostas().add(getRespostaAdd());
		perguntaService.update(getPerguntaSelecionada());
		getLoginBean().atualizarPerguntasUsuarioLogado();
		return "perguntas";
	}

	public String adicionarPergunta() {
		getPerguntaAdd().setDataCriada(new Date());
		perguntaService.inserir(getPerguntaAdd());
		getLoginBean().atualizarPerguntasUsuarioLogado();
		return "perguntas";
	}

	public void setarPosicao() {
		Map<String, String> requestParamMap = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap();
		String lat = requestParamMap.get("lat");
		String longi = requestParamMap.get("longitude");
		System.out.println("Latitude: " + lat + " Longitude: " + longi);
	}

	public Pergunta getPerguntaAdd() {
		if (perguntaAdd == null) {
			perguntaAdd = new Pergunta();
		}
		return perguntaAdd;
	}

	public void setPerguntaAdd(Pergunta perguntaAdd) {
		this.perguntaAdd = perguntaAdd;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public Pergunta getPerguntaSelecionada() {
		return perguntaSelecionada;
	}

	public void setPerguntaSelecionada(Pergunta perguntaSelecionada) {
		this.perguntaSelecionada = perguntaSelecionada;
	}

	public Resposta getRespostaAdd() {
		if (respostaAdd == null) {
			respostaAdd = new Resposta();
		}
		return respostaAdd;
	}

	public void setRespostaAdd(Resposta respostaAdd) {
		this.respostaAdd = respostaAdd;
	}

	public List<String> getPerguntasFAQ() {
		if (perguntasFAQ == null) {
			perguntasFAQ = new ArrayList<>();
		}
		return perguntasFAQ;
	}

	public void setPerguntasFAQ(List<String> perguntasFAQ) {
		this.perguntasFAQ = perguntasFAQ;
	}

	public Pergunta getPerguntaFilter() {
		if (perguntaFilter == null) {
			perguntaFilter = new Pergunta();
		}
		return perguntaFilter;
	}

	public void setPerguntaFilter(Pergunta perguntaFilter) {
		this.perguntaFilter = perguntaFilter;
	}

	public List<Pergunta> getPerguntasFiltradas() {
		if (perguntasFiltradas == null) {
			perguntasFiltradas = new ArrayList<>();
		}
		return perguntasFiltradas;
	}

	public void setPerguntasFiltradas(List<Pergunta> perguntasFiltradas) {
		this.perguntasFiltradas = perguntasFiltradas;
	}

	public List<EnumEstados> completeEstado(String query) {
		List<EnumEstados> allEstado = Arrays.asList(EnumEstados.values());
		List<EnumEstados> filteredEstados = new ArrayList<EnumEstados>();

		for (EnumEstados est : allEstado) {
			if (est.getNome().toLowerCase().startsWith(query.toLowerCase())
					|| est.getSigla().toLowerCase().startsWith(query.toLowerCase())) {
				filteredEstados.add(est);
			}
		}

		return filteredEstados;
	}

	public List<EnumCategoria> completeCategoria(String query) {
		List<EnumCategoria> allCategoria = Arrays.asList(EnumCategoria.values());
		List<EnumCategoria> filteredCategoria = new ArrayList<EnumCategoria>();

		for (EnumCategoria cat : allCategoria) {
			if (cat.getNome().toLowerCase().startsWith(query.toLowerCase())) {
				filteredCategoria.add(cat);
			}
		}

		return filteredCategoria;
	}

	public List<Marca> completeMarca(String query) {
		List<Marca> allMarcas = getListFactory().getListaMarca();
		List<Marca> filteredMarcas = new ArrayList<Marca>();

		for (Marca marca : allMarcas) {
			if (marca.getNome().toLowerCase().startsWith(query.toLowerCase())) {
				filteredMarcas.add(marca);
			}
		}

		return filteredMarcas;
	}

	public char getMarcaGroup(Marca marca) {
		return marca.getNome().charAt(0);
	}

	public char getEstadoGroup(EnumEstados est) {
		return est.getNome().charAt(0);
	}

	public ListFactory getListFactory() {
		return listFactory;
	}

	public void setListFactory(ListFactory listFactory) {
		this.listFactory = listFactory;
	}

}
