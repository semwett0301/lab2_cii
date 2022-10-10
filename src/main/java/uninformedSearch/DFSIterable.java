package uninformedSearch;

import utils.City;
import utils.Graph;

import java.util.LinkedList;

public class DFSIterable extends DFSWithLimit{

    public DFSIterable(City start, City finish) {
        super(start, finish);
        type = "Iterable DFS";
    }

    @Override
    public void search() {
        for (limit = 1; limit <= 5; limit++) {
            System.out.println("-- deep: " + limit + " --");
            super.search();
            totalWay = new LinkedList<>();
            currentLevel = -1;
            System.out.println();
        }
    }
}
