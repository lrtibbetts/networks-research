import java.util.*;

// TODO: thread to generate events, thread to take care of events
// start with producer thread, use some random function, randomly generate events (mark the time)
// track how long the events wait

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
            // newEdge.printEdge();
            g.addEdge(newEdge);
        }

        // create producer thread
        producerThread pthread = new producerThread();
        pthread.run(g);
    }
}