import java.util.*;

// TODO: run the threads concurrently
// TODO: track how long the events wait before they are removed

public class Test {
    public static void main(String[] args) {
        int numVertices = 10;
        Graph g = new Graph(numVertices);

        Random rand = new Random();

        // add 50 random edges to graph
        for(int i = 0; i < 50; i++) {
            int start = rand.nextInt(numVertices);
            int end = rand.nextInt(numVertices);
            while(end == start)
                end = rand.nextInt(numVertices); // ensure that start and end are different vertices
            Edge newEdge = new Edge(start, end);
            newEdge.printEdge();
            g.addEdge(newEdge);
        }

        // create producer and consumer threads
        producerThread pthread = new producerThread(g);
        consumerThread cthread = new consumerThread(g);

        // start the producer thread first
        pthread.start();
        try {
            pthread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pthread.stopRunning();

        // start the consumer thread
        cthread.start();
        try {
            cthread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cthread.stopRunning();
    }
}