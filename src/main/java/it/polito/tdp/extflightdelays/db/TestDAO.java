package it.polito.tdp.extflightdelays.db;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;

import it.polito.tdp.extflightdelays.model.Airport;

public class TestDAO {

	public static void main(String[] args) {

		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();

		/*
		 * System.out.println(dao.loadAllAirlines());
		System.out.println(dao.loadAllAirports());
		System.out.println(dao.loadAllFlights().size());
		
		Graph<Airport, DefaultWeightedEdge> grafo = dao.getGrafo(1000);
		
		System.out.println("Grafo creato con "+ grafo.vertexSet().size() +
				" vertici e " + grafo.edgeSet().size() + " archi") ;
		//System.out.println(grafo);
		
		for( Airport s: grafo.vertexSet() ) {
			System.out.println("Vertex "+s.getAirportName()) ;
			for( DefaultWeightedEdge e: grafo.edgesOf(s) ) {
				//System.out.println( e);
				Airport a = Graphs.getOppositeVertex(grafo, e, s);
				System.out.print( " collegato a: " + Graphs.getOppositeVertex(grafo, e, s).getAirportName()  + " distante: " + grafo.getEdgeWeight(e) + "\n") ;
			}
			
		}
	
		
		 */
		
		
	
	
	}	
}
