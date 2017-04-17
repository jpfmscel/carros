package br.com.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import br.com.entidades.Marca;
import br.com.entidades.rest.MarcaFipe;
import br.com.entidades.rest.VeiculoNivel1;
import br.com.entidades.rest.VeiculoNivel2;

public class VeiculoFipeService {

	private Client client = ClientBuilder.newClient();
	private WebTarget target;
	private final String URL_BASE = "http://fipeapi.appspot.com/api/1/carros/veiculos/";

	public List<MarcaFipe> getMarcas() {
		target = client.target("http://fipeapi.appspot.com/api/1/carros/marcas.json");
		return Arrays.asList(target.request(MediaType.APPLICATION_JSON).get(MarcaFipe[].class));
	}

	protected List<VeiculoNivel1> getCarrosByMarca(Marca m) {
		target = client.target(URL_BASE + m.getIdFipe() + ".json");
		return Arrays.asList(target.request(MediaType.APPLICATION_JSON).get(VeiculoNivel1[].class));
	}

	protected List<VeiculoNivel2> getCarrosByModelo(Marca m, VeiculoNivel1 v1) {
		target = client.target(URL_BASE + m.getIdFipe() + "/" + v1.getId() + ".json");
		return Arrays.asList(target.request(MediaType.APPLICATION_JSON).get(VeiculoNivel2[].class));
	}

}
