package informedSearch;

import utils.City;
import utils.Edge;

import java.util.LinkedList;
import java.util.Queue;

public class StarAlgorithm extends InformedAlgorithm{
    public StarAlgorithm(City start, City finish) {
        super(start, finish);
        type = "A* algorithm";
    }

    @Override
    protected City searchResults() {
        City currentCity = start;
        graph.getVisited().put(start, true);
        totalPath.add(start);

        while (currentCity != finish) {
            int min = Integer.MAX_VALUE;
            City choice = currentCity;
            for (Edge edge : graph.getGraph().get(currentCity)) {
                if (graph.getWeights().get(edge.getGoal()) + edge.getWeight() < min && !graph.getVisited().get(edge.getGoal())) {
                    min = graph.getWeights().get(edge.getGoal()) + edge.getWeight();
                    choice = edge.getGoal();
                }
            }
            graph.getVisited().put(choice, true);

            if (choice != currentCity) {
                totalPath.add(choice);
                currentCity = choice;
            } else {
                break;
            }
        }

        return currentCity;
    }
}
