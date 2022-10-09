import algorithms.Algorithm;
import algorithms.BFS;
import utils.City;
import utils.Graph;

public class Main {
    public static void main(String[] args) {
        final City start = City.KAZAN;
        final City finish = City.TALLINN;

        Algorithm bfs = new BFS(start, finish, new Graph());
        bfs.search();
    }
}
