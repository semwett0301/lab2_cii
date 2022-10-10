package utils;

import java.util.*;

public class Graph {
    private final Map<City, LinkedList<Edge>> graph = new HashMap<>();
    private final Map<City, Boolean> visited = new HashMap<>();

    public Graph() {
        addGraph(City.VILNUS, City.BREST, 531);
        addGraph(City.VITEBSK, City.BREST, 638);
        addGraph(City.VITEBSK, City.VILNUS, 360);
        addGraph(City.VORONEZ, City.VITEBSK, 869);
        addGraph(City.VORONEZ, City.VOLGOGRAD, 581);
        addGraph(City.VOLGOGRAD, City.VITEBSK, 1455);
        addGraph(City.VITEBSK, City.NIZ_NOVGOROD, 911);
        addGraph(City.VILNUS, City.DAUGAVPILS, 211);
        addGraph(City.KALININGRAD, City.BREST, 699);
        addGraph(City.KALININGRAD, City.VILNUS, 333);
        addGraph(City.KAUNAS, City.VILNUS, 102);
        addGraph(City.KIEV, City.VILNUS, 734);
        addGraph(City.KIEV, City.ZHITOMIR, 131);
        addGraph(City.ZHITOMIR, City.DONETSK, 863);
        addGraph(City.ZHITOMIR, City.VOLGOGRAD, 1493);
        addGraph(City.KISHINEV, City.KIEV, 467);
        addGraph(City.KISHINEV, City.DONETSK, 812);
        addGraph(City.ST_PETERBURG, City.VITEBSK, 602);
        addGraph(City.ST_PETERBURG, City.KALININGRAD, 739);
        addGraph(City.ST_PETERBURG, City.RIGA, 641);
        addGraph(City.MOSCOW, City.KAZAN, 815);
        addGraph(City.MOSCOW, City.NIZ_NOVGOROD, 411);
        addGraph(City.MOSCOW, City.MINSK, 690);
        addGraph(City.MOSCOW, City.DONETSK, 1084);
        addGraph(City.MOSCOW, City.ST_PETERBURG, 664);
        addGraph(City.MURMANSK, City.ST_PETERBURG, 1412);
        addGraph(City.MURMANSK, City.MINSK, 2238);
        addGraph(City.OREL, City.VITEBSK, 522);
        addGraph(City.OREL, City.DONETSK, 709);
        addGraph(City.OREL, City.MOSCOW, 368);
        addGraph(City.ODESSA, City.KIEV, 487);
        addGraph(City.RIGA, City.KAUNAS, 267);
        addGraph(City.TALLINN, City.RIGA, 308);
        addGraph(City.KHARKIV, City.KIEV, 471);
        addGraph(City.KHARKIV, City.SIMFEROPOL, 639);
        addGraph(City.YAROSLAVL, City.VORONEZ, 739);
        addGraph(City.YAROSLAVL, City.MINSK, 940);
        addGraph(City.UFA, City.KAZAN, 525);
        addGraph(City.UFA, City.SAMARA, 461);
    }

    public Map<City, LinkedList<Edge>> getGraph() {
        return graph;
    }

    public Map<City, Boolean> getVisited() {
        return visited;
    }

    private void addGraph(City city1, City city2, int weight) {
        graph.computeIfAbsent(city1, k -> new LinkedList<>());
        graph.computeIfAbsent(city2, k -> new LinkedList<>());

        LinkedList<Edge> c1 = graph.get(city1);
        c1.add(new Edge(city2, weight));
        graph.put(city1, c1);

        LinkedList<Edge> c2 = graph.get(city2);
        c2.add(new Edge(city1, weight));
        graph.put(city2, c2);

        visited.put(city1, false);
        visited.put(city2, false);
    }

}