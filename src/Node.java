import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jonas on 30.11.2017.
 */

/**
 * A Node can have a name, a List with the shortest paths to each node in the Graph,
 * a distance from the source, and an adjacency list, where immediate neighbours can
 * be stored with their edge length.
 */
public class Node {

    private String name;
    private List<Node> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;
    Map<Node,Integer> adjacentNodes = new HashMap<>();

    public Node(String name){
        this.name = name;
    }

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Integer getDistance() {
        return distance;
    }

    public Map<Node,Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public String getName() {
        return name;
    }
}
