package uninformedSearch;

import utils.City;
import utils.Graph;

import java.util.LinkedList;

public class DFSIterable extends DFSWithLimit{

    public DFSIterable(City start, City finish, Graph graph) {
        super(start, finish, graph);
    }

    @Override
    public void search() {
        for (limit = 1; limit <= 5; limit++) {
            type = "Iterable DFS (deep: " + limit + ")";
            super.search();
            totalWay = new LinkedList<>();
            currentLevel = -1;
        }
    }
}
