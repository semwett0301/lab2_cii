package informedSearch;

import utils.City;
import utils.Edge;

import java.util.*;

public class StarAlgorithm extends InformedAlgorithm {
    public StarAlgorithm(City start, City finish) {
        super(start, finish);
        type = "A* algorithm";
    }

    @Override
    protected City searchResults() {
        Map<City, Integer> currentLengths = new HashMap<>();
        currentLengths.put(start, 0);

        TreeSet<City> citySet = new TreeSet<>((o1, o2) -> {
            int a = currentLengths.get(o1) + graph.getWeights().get(o1);
            int b = currentLengths.get(o2) + graph.getWeights().get(o2);

            if (b > a) {
                return 1;
            } else if (b < a) {
                return  -1;
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
                    if (currentLengths.containsKey(edge.getGoal())) {
                        if (currentLengths.get(edge.getGoal()) > currentLengths.get(currentCity) + edge.getWeight()) {
                            currentLengths.put(edge.getGoal(), currentLengths.get(currentCity) + edge.getWeight());
                            waysFrom.put(edge.getGoal(), currentCity);
                        }
                    } else {
                        currentLengths.put(edge.getGoal(), currentLengths.get(currentCity) + edge.getWeight());
                        waysFrom.put(edge.getGoal(), currentCity);
                    }
                    citySet.add(edge.getGoal());
                }
            }
        }

        return currentCity;
    }
}
