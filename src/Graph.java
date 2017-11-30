import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jonas on 30.11.2017.
 */

/**
 * A graph will represent a set of nodes.
 */
public class Graph {

    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node nodeA){
        nodes.add(nodeA);
    }
}
