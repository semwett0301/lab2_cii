import uninformedSearch.*;
import utils.City;
import utils.Graph;

public class Main {
    public static void main(String[] args) {
        final City start = City.KAZAN;
        final City finish = City.TALLINN;

        UninformedAlgorithm bfs = new BFS(start, finish, new Graph());
        bfs.search();
        System.out.println();

        UninformedAlgorithm dfs = new DFS(start, finish, new Graph());
        dfs.search();
        System.out.println();

        UninformedAlgorithm dfsWithLimit = new DFSWithLimit(start, finish, new Graph());
        dfsWithLimit.search();
        System.out.println();

        UninformedAlgorithm iterableDfs = new DFSIterable(start, finish, new Graph());
        iterableDfs.search();
        System.out.println();
    }
}
