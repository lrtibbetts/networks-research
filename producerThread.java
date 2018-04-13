import java.time.LocalDateTime;
import java.util.Random;

public class producerThread extends Thread {
    public void run(Graph g) {
        Random rand = new Random();
        for(int j = 0; j < 50; j++) {
            // randomly select edge
            int index = rand.nextInt(g.getNumEdges());
            Edge edge = g.getEdge(index);

            int priority = rand.nextInt(50);
            LocalDateTime currentTime = LocalDateTime.now();

            // generate and add new event
            Event newEvent = new Event(edge, priority, currentTime);
            edge.addEvent(newEvent);
            System.out.println("New event added to edge " + edge.getId() + " with priority " + priority +
                    " at time " + currentTime);
        }
    }
}