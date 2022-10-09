package utils;

import java.util.*;

public class Graph {
    private final Map<City, LinkedList<City>> graph = new HashMap<>();
    private final Map<City, Boolean> visited = new HashMap<>();

    public Graph() {
        addGraph(City.VILNUS, City.BREST);
        addGraph(City.VITEBSK, City.BREST);
        addGraph(City.VITEBSK, City.VILNUS);
        addGraph(City.VORONEZ, City.VITEBSK);
        addGraph(City.VORONEZ, City.VOLGOGRAD);
        addGraph(City.VOLGOGRAD, City.VITEBSK);
        addGraph(City.VITEBSK, City.NIZ_NOVGOROD);
        addGraph(City.VILNUS, City.DAUGAVPILS);
        addGraph(City.KALININGRAD, City.BREST);
        addGraph(City.KALININGRAD, City.VILNUS);
        addGraph(City.KAUNAS, City.VILNUS);
        addGraph(City.KIEV, City.VILNUS);
        addGraph(City.KIEV, City.ZHITOMIR);
        addGraph(City.ZHITOMIR, City.DONETSK);
        addGraph(City.ZHITOMIR, City.VOLGOGRAD);
        addGraph(City.KISHINEV, City.KIEV);
        addGraph(City.KISHINEV, City.DONETSK);
        addGraph(City.ST_PETERBURG, City.VITEBSK);
        addGraph(City.ST_PETERBURG, City.KALININGRAD);
        addGraph(City.ST_PETERBURG, City.RIGA);
        addGraph(City.MOSCOW, City.KAZAN);
        addGraph(City.MOSCOW, City.NIZ_NOVGOROD);
        addGraph(City.MOSCOW, City.MINSK);
        addGraph(City.MOSCOW, City.DONETSK);
        addGraph(City.MOSCOW, City.ST_PETERBURG);
        addGraph(City.MURMANSK, City.ST_PETERBURG);
        addGraph(City.MURMANSK, City.MINSK);
        addGraph(City.OREL, City.VITEBSK);
        addGraph(City.OREL, City.DONETSK);
        addGraph(City.OREL, City.MOSCOW);
        addGraph(City.ODESSA, City.KIEV);
        addGraph(City.RIGA, City.KAUNAS);
        addGraph(City.TALLINN, City.RIGA);
        addGraph(City.KHARKIV, City.KIEV);
        addGraph(City.KHARKIV, City.SIMFEROPOL);
        addGraph(City.YAROSLAVL, City.VORONEZ);
        addGraph(City.YAROSLAVL, City.MINSK);
        addGraph(City.UFA, City.KAZAN);
        addGraph(City.UFA, City.SAMARA);
    }

    public Map<City, LinkedList<City>> getGraph() {
        return graph;
    }

    public Map<City, Boolean> getVisited() {
        return visited;
    }

    private void addGraph(City city1, City city2) {
        graph.computeIfAbsent(city1, k -> new LinkedList<>());
        graph.computeIfAbsent(city2, k -> new LinkedList<>());

        LinkedList<City> c1 = graph.get(city1);
        c1.add(city2);
        graph.put(city1, c1);

        LinkedList<City> c2 = graph.get(city2);
        c2.add(city1);
        graph.put(city2, c2);

        visited.put(city1, false);
        visited.put(city2, false);
    }

}