import java.util.*;

// event class: location, priority, time generated
// simulation: 2 threads, producer and consumer (dependent on path plan)
// edge class: vertices, weight, array list containing events, id
// store number and urgency of events

public class Graph {

    private int numVertices; // number of vertices in graph
    private int numEdges; // number of edges in a graph
    private ArrayList<Edge> edges; // array list to store edge objects

    public Graph(int v) {
        numVertices = v;
        numEdges = 0;
        edges = new ArrayList<Edge>();
    }

    // adds an edge to the array list
    public void addEdge(Edge w) {
        edges.add(w);
        numEdges++;
    }

    public Edge getEdge(int index) {
        return edges.get(index);
    }

    // get number of vertices, edges
    public int getNumVertices() { return numVertices; }
    public int getNumEdges() { return numEdges; }
}