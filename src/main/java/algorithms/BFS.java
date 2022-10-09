package algorithms;

import utils.City;
import utils.Graph;

import java.util.*;

public class BFS extends Algorithm {

    public BFS(City start, City finish, Graph graph) {
        super(start, finish, graph);
        System.out.println("- BFS -\n--------------------------------------------------------------------");
    }

    @Override
    public void search() {
        Queue<City> currentQueue = new ArrayDeque<>();
        currentQueue.add(start);

        graph.getVisited().put(start, true);

        List<List<City>> traveledPaths = new LinkedList<>();
        traveledPaths.add(new LinkedList<>());
        traveledPaths.get(0).add(start);

        int counter = 1;

        while (!currentQueue.isEmpty()) {
            City currentCity = currentQueue.poll();
            System.out.println(counter + ". " + currentCity.getName());
            counter++;

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
            if (currentQueue.contains(finish)) {
                break;
            }
        }

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
                System.out.println("");
                System.out.print("Путь: ");
                while(!totalWay.isEmpty()) {
                    if (totalWay.size() != 1) System.out.print(totalWay.pop().getName() + " -> ");
                    else System.out.println(totalWay.pop().getName());
                }
                System.out.println("\nАлгоритм нашел путь!\n");
                break;
            }
        }

        System.out.println("--------------------------------------------------------------------");
    }
}
