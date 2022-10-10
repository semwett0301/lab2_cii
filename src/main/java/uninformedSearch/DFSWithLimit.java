package uninformedSearch;

import utils.City;
import utils.Graph;

public class DFSWithLimit extends DFS {

    protected int limit = 5;
    protected int currentLevel = -1;
    private City achievedCity;

    public DFSWithLimit(City start, City finish, Graph graph) {
        super(start, finish, graph);
        type = "DFS with limit";
    }

    @Override
    protected boolean DFS(City currentCity) {
        currentLevel++;

        totalWay.add(currentCity);

        if (currentCity.equals(finish)) {
            System.out.println(currentCity.getName());
            achievedCity = currentCity;
            return true;
        }

        System.out.print(currentCity.getName() + " -> ");

        for (City nextCity : graph.getGraph().get(currentCity)) {
                if (currentLevel == limit) {
                    return false;
                }

                if (DFS(nextCity)) {
                    return true;
                }

                System.out.print("\u001B[31m" + "Возврат на " + currentCity.getName() + " -> " + "\u001B[0m");

                totalWay.pollLast();
                currentLevel--;
        }

        return false;
    }

    @Override
    protected void printWay() {
        if (achievedCity == finish) {
            super.printWay();
        } else {
            System.out.println("\nНельзя добраться!");
        }
    }
}
