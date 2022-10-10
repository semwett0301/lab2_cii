package informedSearch;

import uninformedSearch.UninformedAlgorithm;
import utils.City;
import utils.WeightedVerticalsGraph;

import java.util.*;

abstract public class InformedAlgorithm extends UninformedAlgorithm {
    protected WeightedVerticalsGraph graph;
    protected Queue<City> totalPath = new LinkedList<>();
    protected Map<City, City> waysFrom = new HashMap<>();


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
            Deque<City> way=new LinkedList<>();
            City cityToWay=finish;
            while(cityToWay!=start){
                way.add(cityToWay);
                cityToWay=waysFrom.get(cityToWay);
            }

            while(!way.isEmpty()){
                totalPath.add(way.pollLast());
            }
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
