import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Created by Jonas on 30.11.2017.
 */
public class Dijkstra {

    public static Set<Node> calcShortestPathFromSource(Graph graph, Node source){
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while(unsettledNodes.size() != 0){
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for(Map.Entry< Node, Integer > adjacencyPair : currentNode.getAdjacentNodes().entrySet()){
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if(!settledNodes.contains(adjacentNode)){
                    calculateMinimumDistance(adjacentNode, edgeWeight,currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return settledNodes;
    }

    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode){
        Integer sourceDistance = sourceNode.getDistance();
        if(sourceDistance + edgeWeight < evaluationNode.getDistance()){
            evaluationNode.setDistance(sourceDistance + edgeWeight);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    /**
     *returns the node with the lowest distance from the unsettled nodes set.
     */
    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for(Node node: unsettledNodes){
            int nodeDistance = node.getDistance();
            if(nodeDistance < lowestDistance){
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    public static void printResult(Set<Node> settledNodes){
        for(Node n: settledNodes){
            System.out.println("Name: " + n.getName() + " Distance from source: "    +n.getDistance());
        }
    }
}
