package uninformedSearch;

import utils.City;
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

            for (City city : graph.getGraph().get(currentCity)) {
                traveledPaths.get(traveledPaths.size() - 1).add(city);
            }

            for (City city : graph.getGraph().get(currentCity)) {
                if (!graph.getVisited().get(city)) {
                    graph.getVisited().put(city, true);
                    currentQueue.add(city);
                }
            }

            System.out.print(currentCity.getName() + " -> ");
            if (currentQueue.contains(finish)) {
                break;
            }

        }

        System.out.print(finish.getName());
    }

    protected void printWay() {
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
    }
}
