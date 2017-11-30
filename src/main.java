import java.util.Set;

/**
 * Created by Jonas on 27.11.2017.
 */
public class main {

    public static void main(String[] args){

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB,10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD,12);
        nodeB.addDestination(nodeF,15);

        nodeC.addDestination(nodeE,10);

        nodeD.addDestination(nodeE,2);
        nodeD.addDestination(nodeF,1);

        nodeF.addDestination(nodeE,5);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        Set set = Dijkstra.calcShortestPathFromSource(graph, nodeA);
        Dijkstra.printResult(set);




        /*
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                    {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                    {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                    {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                    {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                    {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                    {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                    {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                    {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        ShortestPath sp = new ShortestPath();
        sp.dijkstra(graph,0);
*/
    }
    }
