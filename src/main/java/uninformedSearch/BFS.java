package uninformedSearch;

import utils.City;
import utils.Edge;
import utils.Graph;

import java.util.*;

public class BFS extends UninformedAlgorithm {

    private final List<List<City>> traveledPaths = new LinkedList<>();

    public BFS(City start, City finish) {
        super(start, finish);
        type = "BFS";
    }

    @Override
    public void search() {
        searchWay();
        printWay();
    }

    protected void searchWay() {
        Queue<City> currentQueue = new ArrayDeque<>();
        currentQueue.add(start);

        graph.getVisited().put(start, true);

        traveledPaths.add(new LinkedList<>());
        traveledPaths.get(0).add(start);


        System.out.print("Движение по дереву: ");
        while (!currentQueue.isEmpty()) {
            City currentCity = currentQueue.poll();

            traveledPaths.add(new LinkedList<>());
            traveledPaths.get(traveledPaths.size() - 1).add(currentCity);

            for (Edge edge : graph.getGraph().get(currentCity)) {
                traveledPaths.get(traveledPaths.size() - 1).add(edge.getGoal());
            }

            for (Edge edge : graph.getGraph().get(currentCity)) {
                if (!graph.getVisited().get(edge.getGoal())) {
                    graph.getVisited().put(edge.getGoal(), true);
                    currentQueue.add(edge.getGoal());
                }
            }

            System.out.print(currentCity.getName() + " -> ");
            if (currentQueue.contains(finish)) {
                break;
            }

        }
    }

    protected void printWay() {
        if (graph.getVisited().containsKey(finish) && graph.getVisited().get(finish)) {
            Stack<City> totalWay = new Stack<>();
            while (true) {
                for (List<City> cityList : traveledPaths) {
                    if (cityList.contains(finish)) {
                        totalWay.push(finish);
                        finish = cityList.get(0);
                        break;
                    }
                }

                if (finish.equals(start)) {
                    totalWay.push(start);
                    System.out.println();
                    System.out.print("Путь: ");
                    while (!totalWay.isEmpty()) {
                        if (totalWay.size() != 1) System.out.print(totalWay.pop().getName() + " -> ");
                        else System.out.println(totalWay.pop().getName());
                    }
                    break;
                }
            }
        } else {
            System.out.println("Невозможно найти путь!");
        }
    }
}
