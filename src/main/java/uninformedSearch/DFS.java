package uninformedSearch;

import utils.City;
import utils.Graph;

import java.util.LinkedList;

public class DFS extends UninformedAlgorithm {

    protected LinkedList<City> totalWay = new LinkedList<>();

    public DFS(City start, City finish) {
        super(start, finish);
        type = "DFS";
    }

    @Override
    public void search() {
        System.out.print("Движение по дереву: ");
        DFS(start);
        printWay();
    }

    protected boolean DFS(City currentCity) {
        graph.getVisited().put(currentCity, true);
        totalWay.add(currentCity);
        if (currentCity.equals(finish)) {
            System.out.println(currentCity.getName());
            return true;
        }

        System.out.print(currentCity.getName() + " -> ");

        for (City nextCity : graph.getGraph().get(currentCity)) {
            if (!graph.getVisited().get(nextCity)) {
                if (DFS(nextCity)) {
                    return true;
                }

                System.out.print("\u001B[31m" + "Возврат на " + currentCity.getName() + " -> " + "\u001B[0m");

                totalWay.pollLast();
            }
        }

        return false;
    }

    protected void printWay() {
        System.out.print("Путь: ");

        while (totalWay.size() > 0) {
            if (totalWay.size() != 1) System.out.print(totalWay.pop().getName() + " -> ");
            else System.out.println(totalWay.pop().getName());
        }
    }
}
