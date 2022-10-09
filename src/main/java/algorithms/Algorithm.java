package algorithms;

import utils.City;
import utils.Graph;

abstract public class Algorithm {
    protected City start;
    protected City finish;
    protected final Graph graph;

    public Algorithm(City start, City finish, Graph graph) {
        this.start = start;
        this.finish = finish;
        this.graph = graph;
    }

    public abstract void search();
}

