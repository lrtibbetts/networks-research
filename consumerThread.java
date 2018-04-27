import java.util.ArrayList;

public class consumerThread extends Thread {
    public void start(Graph g) {
        run(g);
    }

    public void run(Graph g) {
        // start at first edge in graph
        Edge edge = g.getEdge(0);
        System.out.println("Removing from edge " + edge.getId());
        ArrayList <Event> events = edge.getEvents();
        while(true) {
            while(events.size() != 0) {
                events.remove(0); // remove event from front of array list
                System.out.println("Removed event from edge " + edge.getId());
            }
            // find adjacent edge
            boolean edgeFound = false;
            int i = 1;
            int vertex1 = edge.getVertex1();
            int vertex2 = edge.getVertex2();
            while(!edgeFound) {
                if(i == g.getNumVertices()) {
                    System.out.println("No adjacent edges");
                    this.interrupt();
                }
                Edge newEdge = g.getEdge(i);
                if(vertex1 == newEdge.getVertex1() || vertex1 == newEdge.getVertex1()
                        || vertex2 == newEdge.getVertex2() || vertex2 == newEdge.getVertex2()) {
                    edge = newEdge;
                    edgeFound = true;
                }
            }
        }
    }
}