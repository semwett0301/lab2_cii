package uninformedSearch;

import utils.City;
import utils.Graph;

abstract public class UninformedAlgorithm {
    protected City start;
    protected City finish;
    protected Graph graph;

    public UninformedAlgorithm(City start, City finish, Graph graph) {
        this.start = start;
        this.finish = finish;
        this.graph = graph;
    }

    public abstract void search();
}

