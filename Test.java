import java.util.*;

// TODO: thread to take care of events
// track how long the events wait before they are removed
// make a consumer thread: needs to know which edge to remove events from

// https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/representing-graphs
// https://algs4.cs.princeton.edu/41graph/

public class Test {
    public static void main(String[] args) {
        int numVertices = 10;
        Graph g = new Graph(numVertices);

        Random rand = new Random();

        // add 25 random edges to graph
        for(int i = 0; i < 25; i++) {
            int start = rand.nextInt(numVertices);
            int end = rand.nextInt(numVertices);
            while(end == start)
                end = rand.nextInt(numVertices); // ensure that start and end are different vertices
            Edge newEdge = new Edge(start, end);
            newEdge.printEdge();
            g.addEdge(newEdge);
        }

        // create producer and consumer threads
        producerThread pthread = new producerThread();
        consumerThread cthread = new consumerThread();
        cthread.start(g);
        pthread.start(g);
    }
}