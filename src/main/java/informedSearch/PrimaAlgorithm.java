package informedSearch;

import utils.City;

import java.util.LinkedList;
import java.util.Queue;

public class PrimaAlgorithm extends InformedAlgorithm {
    public PrimaAlgorithm(City start, City finish) {
        super(start, finish);
        type = "Greedy Algorithm";
    }

    @Override
    public void search() {
        Queue<City> totalPath = new LinkedList<>();
        City currentCity = start;
        graph.getVisited().put(start, true);
        totalPath.add(start);

        while (currentCity != finish) {
            int min = Integer.MAX_VALUE;
            City choice = currentCity;
            for (City city : graph.getGraph().get(currentCity)) {
                if (graph.getWeights().get(city) < min && !graph.getVisited().get(city)) {
                    min = graph.getWeights().get(city);
                    choice = city;
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

        if (currentCity == finish) {
            System.out.print("Путь: ");
            while (!totalPath.isEmpty()) {
                if (totalPath.size() == 1) System.out.print(totalPath.poll().getName());
                else System.out.print(totalPath.poll().getName() + " -> ");
            }
            System.out.println();
        } else {
            System.out.println("Невозможно найти путь!");
        }
    }
}
