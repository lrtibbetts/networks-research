import java.time.LocalDateTime;
import java.util.Random;

public class producerThread extends Thread {

    private volatile boolean flag = true;
    private Graph g;
    private int count; // number of events generated

    public producerThread(Graph myGraph) {
        count = 0;
        g = myGraph;
    }

    public void stopRunning() {
        flag = false;
        System.out.println(count + " events were generated.");
    }

    public void run() {
        Random rand = new Random();
        while(flag) {
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
            count++;
        }
    }
}