package utils;

public class Edge {
    private City goal;
    private int weight;

    public Edge(City first, int weight) {
        this.goal = first;
        this.weight = weight;
    }

    public City getGoal() {
        return goal;
    }

    public int getWeight() {
        return weight;
    }
}
