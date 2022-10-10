package uninformedSearch;

import utils.City;
import utils.Graph;

abstract public class UninformedAlgorithm {
    protected City start;
    protected City finish;
    protected Graph graph;
    protected String type;

    public UninformedAlgorithm(City start, City finish) {
        this.start = start;
        this.finish = finish;
        this.graph = new Graph();
    }

    public void runSearch() {
        System.out.println("- " + type + " -\n--------------------------------------------------------------------");
        search();
        System.out.println("--------------------------------------------------------------------");
    }

    protected abstract void search();
}

