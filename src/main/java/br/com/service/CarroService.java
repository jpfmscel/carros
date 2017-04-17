package br.com.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.entidades.Marca;
import br.com.entidades.Modelo;
import br.com.entidades.rest.VeiculoNivel1;

public class CarroService {

	@Inject
	private VeiculoFipeService veiculoFipeService;

	public List<Modelo> getModelosByMarca(Marca m) {
		List<Modelo> modelos = new ArrayList<>();

		for (VeiculoNivel1 f : veiculoFipeService.getCarrosByMarca(m)) {
			modelos.add(new Modelo(f));
		}

		return modelos;
	}
	
//	public List<Modelo> getModelosByMarca(Marca m) {
//		List<Modelo> modelos = new ArrayList<>();
//
//		for (VeiculoNivel1 f : veiculoFipeService.getCarrosByMarca(m)) {
//			modelos.add(new Modelo(f));
//		}
//
//		return modelos;
//	}

	// public List<CarroFipe> getCarrosByMarca(Marca m){
	// return marcaFipeService.getMarcas();
	// }

}
