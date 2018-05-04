import java.util.ArrayList;

// TODO: fix path-finding algorithm

public class consumerThread extends Thread {

    private volatile boolean flag = true;
    private Graph g;

    public consumerThread(Graph myGraph) {
        g = myGraph;
    }

    public void stopRunning() {
        flag = false;
    }

    public void run() {
        int edgeIndex = 0; // start at first edge in graph
        while(flag) {
            Edge edge = g.getEdge(edgeIndex);
            System.out.println("Removing from edge " + edge.getId());
            ArrayList <Event> events = edge.getEvents();
            System.out.println("Edge " + edge.getId() + " has " + events.size() + " events to remove.");

            int index = events.size() - 1;
            // remove any events from edge
            while(events.size() != 0) {
                events.remove(index); // remove event from back of array list
                System.out.println("Removed event from edge " + edge.getId());
                index--;
            }

            // find adjacent edge
            System.out.println("Looking for edge with events to remove.");
            boolean edgeFound = false;
            int i = 0;
            int vertex1 = edge.getVertex1();
            int vertex2 = edge.getVertex2();

            while(!edgeFound) {
                if(i == g.getNumVertices() - 1) {
                    System.out.println("No path to an edge with events to remove");
                    // need to modify path-finding algorithm
                    // currently the algorithm only moves forward through the list of edges
                    flag = false;
                    break;
                } else {
                    Edge newEdge = g.getEdge(i);
                    if ((!newEdge.getId().equals(edge.getId())) && (newEdge.getEvents().size() > 0) &&
                            (vertex1 == newEdge.getVertex1() || vertex1 == newEdge.getVertex2()
                             || vertex2 == newEdge.getVertex1() || vertex2 == newEdge.getVertex2())) {
                        // found adjacent edge with events to remove
                        edgeIndex = i;
                        edgeFound = true;
                    }
                }
                i++;
            }
        }
    }
}