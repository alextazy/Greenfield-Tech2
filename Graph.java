import java.util.HashMap;
import java.util.Map;

public class Graph {

    private Map<String, Node> nodes = new HashMap<String, Node>();

    public void addNode(Node nodeA) {
        nodes.put(nodeA.getName(), nodeA);
    }

    public Map<String, Node> getNodes() {
        return nodes;
    }
    
}