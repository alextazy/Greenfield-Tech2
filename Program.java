import java.io.IOException;
import java.util.Map.Entry;

public class Program {

	public static final float COMPLETE  = 100; // 100%

	public static void main(String[] args) throws IOException {

		Graph graph = new Graph();

		Parser parser = new Parser("words.txt", ":", graph);

		parser.parse();

		//Enter here the search node
		String nodeName = "newspaper";

		if (graph.getNodes().containsKey(nodeName)) {

			Node node = graph.getNodes().get(nodeName);

			if (node.iSterminationNode())
				System.out.println("The node is Termination Node! nothing to check");

			else
				printNodeProbability(node, COMPLETE);		
		}
		else 
			System.out.println("Error: No such node in the graph !");
	}

	private static void printNodeProbability(Node node, float percentage) {

		if (node.iSterminationNode())
			System.out.println("Probability of Node " + node.getName() + " is " + percentage + "%");

		float sum = calculateWeightSumOfOutgoingEdges(node);

		for (Entry<Node, Integer> adjacencyPair : node.getAdjacentNodes().entrySet()) {

			Node n = adjacencyPair.getKey();
			int weight = adjacencyPair.getValue();
			printNodeProbability(n, (weight/sum) * percentage );
		}
	}

	private static int calculateWeightSumOfOutgoingEdges(Node node) {

		int res = 0;

		for (Entry<Node, Integer> adjacencyPair : node.getAdjacentNodes().entrySet()) {

			int weight = adjacencyPair.getValue();
			res += weight;
		}
		return res;
	}
}