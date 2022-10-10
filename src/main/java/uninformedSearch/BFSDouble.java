package uninformedSearch;

import utils.City;
import utils.Graph;

import java.util.*;

public class BFSDouble extends BFS {

    private final LinkedList<City> firstTraveledWay = new LinkedList<>();
    private final LinkedList<City> secondTraveledWay = new LinkedList<>();

    private City connectedCity = start;

    public BFSDouble(City start, City finish, Graph graph) {
        super(start, finish, graph);
        type = "Double BFS";
    }

    @Override
    protected void searchWay() {
        final Map<City, Boolean> firstSearchVisited = graph.getVisited();
        final Map<City, Boolean> secondSearchVisited = new HashMap<>(firstSearchVisited);

        Queue<City> firstCurrentQueue = new ArrayDeque<>();
        Queue<City> secondCurrentQueue = new ArrayDeque<>();

        firstCurrentQueue.add(start);
        secondCurrentQueue.add(finish);

        firstSearchVisited.put(start, true);
        secondSearchVisited.put(finish, true);

        while (!firstCurrentQueue.isEmpty() && !secondCurrentQueue.isEmpty()) {
            City firstCurrentCity = firstCurrentQueue.poll();
            City secondCurrentCity = secondCurrentQueue.poll();

            firstTraveledWay.add(firstCurrentCity);
            secondTraveledWay.add(secondCurrentCity);

            for (City i : graph.getGraph().get(firstCurrentCity)) {
                if (!firstSearchVisited.get(i)) {
                    firstSearchVisited.put(i, true);
                    firstCurrentQueue.add(i);
                }
            }

            for (City i : graph.getGraph().get(secondCurrentCity)) {
                if (!secondSearchVisited.get(i)) {
                    secondSearchVisited.put(i, true);
                    secondCurrentQueue.add(i);
                }
            }

            for (City curCity : firstTraveledWay) {
                if (secondTraveledWay.contains(curCity)) {
                    connectedCity = curCity;
                    break;
                }
            }

            if (connectedCity != start) break;
        }
    }

    @Override
    protected void printWay() {
        if (connectedCity != start) {
            Stack<City> firstTotalWay = new Stack<>();
            Stack<City> secondTotalWay = new Stack<>();

            City currentCity = firstTraveledWay.poll();
            System.out.print("Движение по дереву при обходе со старта: ");
            while (currentCity != connectedCity) {
                System.out.print(currentCity.getName() + " -> ");
                firstTotalWay.push(currentCity);
                currentCity = firstTraveledWay.poll();
            }
            System.out.print(currentCity.getName());
            System.out.println();

            currentCity = secondTraveledWay.poll();
            System.out.print("Движение по дереву при обходе с конца: ");
            while (currentCity != connectedCity) {
                System.out.print(currentCity.getName() + " -> ");
                secondTotalWay.push(currentCity);
                currentCity = secondTraveledWay.poll();
            }
            System.out.print(currentCity.getName());
            System.out.println();

            System.out.print("Путь: ");

            while (!firstTotalWay.isEmpty()) {
                System.out.print(firstTotalWay.pop().getName() + " -> ");
            }
            System.out.print(connectedCity.getName() + " -> ");

            while (!secondTotalWay.isEmpty()) {
                if (secondTotalWay.size() != 1) System.out.print(secondTotalWay.pop().getName() + " -> ");
                else System.out.print(secondTotalWay.pop().getName());
            }
        } else {
            System.out.println("Путь невозможно найти!");
        }
        System.out.println();
    }
}
