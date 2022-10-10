package informedSearch;

import uninformedSearch.UninformedAlgorithm;
import utils.City;
import utils.WeightedVerticalsGraph;

abstract public class InformedAlgorithm extends UninformedAlgorithm {
    protected WeightedVerticalsGraph graph;

    public InformedAlgorithm(City start, City finish) {
        super(start, finish);
        graph = new WeightedVerticalsGraph();
    }
}
