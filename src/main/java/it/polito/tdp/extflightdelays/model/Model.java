package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	private SimpleWeightedGraph<Airport, DefaultWeightedEdge> grafo;
	private Map<Integer, Airport> idMap;
	private ExtFlightDelaysDAO dao;
	
	public  Model(){
		this.dao = new ExtFlightDelaysDAO();
		this.idMap = new HashMap<>();
		dao.loadAllAirports(idMap);
		
	}
	
	
	public void creaGrafo(int distMedia){
		this.grafo = new SimpleWeightedGraph<>( DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(this.grafo, idMap.values());
		
		for(Rotta rotta : dao.getRotte(idMap, distMedia)) {
			
			DefaultWeightedEdge edge = this.grafo.getEdge(rotta.a1, rotta.a2);
			
			if( edge == null) {
				Graphs.addEdge(this.grafo, rotta.a1, rotta.a2, rotta.peso);
			} else {
				double peso = grafo.getEdgeWeight(edge);
				peso = (peso + rotta.peso)/ 2;
				grafo.setEdgeWeight(edge, peso);
			}
		}
		
		
	}
	
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
	
	public List<Rotta> getRotte(){
		//uso la classe Rotta per salvare gli archi del grafo con il relativo peso
		List<Rotta> rotte = new ArrayList<Rotta>();
		for(DefaultWeightedEdge e : this.grafo.edgeSet()) {
			rotte.add(new Rotta(this.grafo.getEdgeSource(e), this.grafo.getEdgeTarget(e), this.grafo.getEdgeWeight(e)));
		}
		return rotte;
	}
	
}

