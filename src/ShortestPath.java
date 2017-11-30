/**
 * Created by Jonas on 27.11.2017.
 */
public class ShortestPath {
    static final int V= 9;

    public int minDistance(int dist[], Boolean sptSet[]){
        /**
         * initialize min value
         */
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        /**
         *
         */
        for(int v = 0; v < V; v++){
            if(sptSet[v] == false && dist[v] <= min){
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }
    public void dijkstra(int graph[][], int src){
        /**
         * The output Array. dist[i] will hold the shortest distance from src to i.
         */
        int dist[] = new int[V];
        /**
         * sptSet[i] is true when vertex i is includen in shortest path three
         */
        Boolean sptSet[] = new Boolean[V];
        /**
         * initialize all distances as Infinite(Max) and sptSet as false.
         */
        for(int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        /**
         * set distance from source to 0.
         */
        dist[src] = 0;

        /**
         *
         */
        for(int counter = 0;counter < V-1; counter++){

            int u = minDistance(dist,sptSet);

            sptSet[u] = true;

            for(int v = 0; v <V; v++){
                if(     !sptSet[v]
                        && graph[u][v]!=0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u]+graph[u][v] < dist[v]){
                            dist[v] = dist[u] + graph[u][v];
                        }
            }
        }
    }
}
