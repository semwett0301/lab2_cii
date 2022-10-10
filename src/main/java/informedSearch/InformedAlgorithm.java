package informedSearch;

import uninformedSearch.UninformedAlgorithm;
import utils.City;
import utils.WeightedVerticalsGraph;

import java.util.LinkedList;
import java.util.Queue;

abstract public class InformedAlgorithm extends UninformedAlgorithm {
    protected WeightedVerticalsGraph graph;
    protected Queue<City> totalPath = new LinkedList<>();

    public InformedAlgorithm(City start, City finish) {
        super(start, finish);
        graph = new WeightedVerticalsGraph();
    }

    @Override
    protected void search() {
        City res = searchResults();
        printResult(res);
    }

    abstract protected City searchResults();

    private void printResult(City stoppedCity) {
        if (stoppedCity == finish) {
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
