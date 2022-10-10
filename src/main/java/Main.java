import informedSearch.InformedAlgorithm;
import informedSearch.PrimaAlgorithm;
import uninformedSearch.*;
import utils.City;
import utils.Graph;

public class Main {
    public static void main(String[] args) {
        final City start = City.KAZAN;
        final City finish = City.TALLINN;

        UninformedAlgorithm bfs = new BFS(start, finish);
        bfs.runSearch();
        System.out.println();

        UninformedAlgorithm dfs = new DFS(start, finish);
        dfs.runSearch();
        System.out.println();

        UninformedAlgorithm dfsWithLimit = new DFSWithLimit(start, finish);
        dfsWithLimit.runSearch();
        System.out.println();

        UninformedAlgorithm iterableDfs = new DFSIterable(start, finish);
        iterableDfs.runSearch();
        System.out.println();

        UninformedAlgorithm doubleBfs = new BFSDouble(start, finish);
        doubleBfs.runSearch();
        System.out.println();

        InformedAlgorithm prima = new PrimaAlgorithm(start, finish);
        prima.runSearch();
        System.out.println();
    }
}
