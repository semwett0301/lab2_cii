package informedSearch;

import utils.City;
import utils.Edge;

import java.util.*;


public class PrimaAlgorithm extends InformedAlgorithm {
    public PrimaAlgorithm(City start, City finish) {
        super(start, finish);
        type = "Greedy Algorithm";
    }

    @Override
    public City searchResults() {

        TreeSet<City> citySet = new TreeSet<>((o1, o2) -> {
            int a = graph.getWeights().get(o1);
            int b = graph.getWeights().get(o2);

            if (b > a) {
                return 1;
            } else if (b < a) {
                return -1;
            }
            return 0;
        }
        );
        citySet.add(start);


        City currentCity = start;
        totalPath.add(start);

        while (currentCity != finish && citySet.size() != 0) {
            currentCity = citySet.pollLast();
            graph.getVisited().put(currentCity, true);

            for (Edge edge : graph.getGraph().get(currentCity)) {
                if (!graph.getVisited().get(edge.getGoal())) {
                    waysFrom.put(edge.getGoal(), currentCity);
                    citySet.add(edge.getGoal());
                }
            }
        }

        return currentCity;
    }
}
