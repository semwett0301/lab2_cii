package uninformedSearch;

import utils.City;
import utils.Edge;
import utils.Graph;

import java.util.*;

public class BFSDouble extends BFS {

    private final LinkedList<City> firstTraveledWay = new LinkedList<>();
    private final LinkedList<City> secondTraveledWay = new LinkedList<>();

    private City connectedCity = start;

    public BFSDouble(City start, City finish) {
        super(start, finish);
        type = "Double BFS";
    }

    @Override
    protected void searchWay() {
        final Map<City, Boolean> firstSearchVisited = graph.getVisited();
        final Map<City, Boolean> secondSearchVisited = new HashMap<>(firstSearchVisited);

        Queue<City> firstCurrentQueue = new ArrayDeque<>();
        Queue<City> secondCurrentQueue = new ArrayDeque<>();

        firstCurrentQueue.add(start);
        secondCurrentQueue.add(finish);

        firstSearchVisited.put(start, true);
        secondSearchVisited.put(finish, true);
        try {
            while (!firstCurrentQueue.isEmpty() && !secondCurrentQueue.isEmpty()) {
                City firstCurrentCity = firstCurrentQueue.poll();
                City secondCurrentCity = secondCurrentQueue.poll();

                firstTraveledWay.add(firstCurrentCity);
                secondTraveledWay.add(secondCurrentCity);

                for (Edge edge : graph.getGraph().get(firstCurrentCity)) {
                    if (!firstSearchVisited.get(edge.getGoal())) {
                        firstSearchVisited.put(edge.getGoal(), true);
                        firstCurrentQueue.add(edge.getGoal());
                    }
                }

                for (Edge edge : graph.getGraph().get(secondCurrentCity)) {
                    if (!secondSearchVisited.get(edge.getGoal())) {
                        secondSearchVisited.put(edge.getGoal(), true);
                        secondCurrentQueue.add(edge.getGoal());
                    }
                }


                for (City curCity : firstTraveledWay) {
                    if (secondTraveledWay.contains(curCity)) {
                        connectedCity = curCity;
                        break;
                    }
                }

                if (connectedCity != start) break;
            }
        } catch (NullPointerException e) {
            connectedCity = start;
        }

    }

    @Override
    protected void printWay() {
        if (connectedCity != start) {
            Stack<City> firstTotalWay = new Stack<>();
            Stack<City> secondTotalWay = new Stack<>();

            City currentCity = firstTraveledWay.poll();
            System.out.print("???????????????? ???? ???????????? ?????? ???????????? ???? ????????????: ");
            while (currentCity != connectedCity) {
                System.out.print(currentCity.getName() + " -> ");
                firstTotalWay.push(currentCity);
                currentCity = firstTraveledWay.poll();
            }
            System.out.print(currentCity.getName());
            System.out.println();

            currentCity = secondTraveledWay.poll();
            System.out.print("???????????????? ???? ???????????? ?????? ???????????? ?? ??????????: ");
            while (currentCity != connectedCity) {
                System.out.print(currentCity.getName() + " -> ");
                secondTotalWay.push(currentCity);
                currentCity = secondTraveledWay.poll();
            }
            System.out.print(currentCity.getName());
            System.out.println();

            System.out.print("????????: ");

            while (!firstTotalWay.isEmpty()) {
                System.out.print(firstTotalWay.pop().getName() + " -> ");
            }
            System.out.print(connectedCity.getName() + " -> ");

            while (!secondTotalWay.isEmpty()) {
                if (secondTotalWay.size() != 1) System.out.print(secondTotalWay.pop().getName() + " -> ");
                else System.out.print(secondTotalWay.pop().getName());
            }
        } else {
            System.out.println("???????? ???????????????????? ??????????!");
        }
        System.out.println();
    }
}
