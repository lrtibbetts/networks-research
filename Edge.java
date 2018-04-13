import java.util.ArrayList;

public class Edge {
    private String id;
    private int vertex1;
    private int vertex2;
    private float weight; // more events = greater weight
    private ArrayList<Event> events; // array list of events

    // constructor
    public Edge(int v1, int v2) {
        id = v1 + "-" + v2;
        vertex1 = v1;
        vertex2 = v2;
        weight = 0; // no events registered when edge is created
        events = new ArrayList<Event>();
    }

    public String getId() {
        return id;
    }

    public void printEdge() {
        System.out.println("Edge from vertex " + vertex1 + " to " + vertex2);
    }

    public void addEvent(Event newEvent){
        events.add(newEvent);
        weight++; // increase weight by one for each new event
    }

    public int getVertex1() {
        return vertex1;
    }

    public int getVertex2() {
        return vertex2;
    }

    public float getWeight() {
        return weight;
    }
}