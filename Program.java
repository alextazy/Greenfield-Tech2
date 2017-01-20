import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Program {

	public static final float COMPLETE  = 100; // 100%

	public static void main(String[] args) throws IOException {

		Graph graph = new Graph();

		Parser parser = new Parser("words.txt", ":", graph);

		parser.parse();

		/*Enter here the search node*/
		String nodeName = "chalk";

		if (graph.getNodes().containsKey(nodeName)) {

			Node node = graph.getNodes().get(nodeName);

			if (node.iSterminationNode())
				System.out.println("The node is Termination Node! nothing to check");

			else {

				Map<String, Float> resMap = new HashMap<String, Float>();

				calculateNodeProbability(node, COMPLETE, resMap);

				printAns(resMap);
			}
		}

		else 
			System.out.println("Error: No such node in the graph !");

	}

	private static void printAns(Map<String, Float> resMap) {

		for (Entry<String, Float> pair : resMap.entrySet()) 
			System.out.println("Probability of Node " + pair.getKey()  + " is " + pair.getValue() + "%");
	}

	private static void calculateNodeProbability(Node node, float percentage, Map<String, Float> resMap) {

		if (node.iSterminationNode()) {

			String name = node.getName();

			if (resMap.containsKey(name)) {

				float p = resMap.get(name);
				resMap.put(name, (p + percentage));
			}

			else 
				resMap.put(name, percentage);
		}

		float sum = calculateWeightSumOfOutgoingEdges(node);

		for (Entry<Node, Integer> adjacencyPair : node.getAdjacentNodes().entrySet()) {

			Node n = adjacencyPair.getKey();
			int weight = adjacencyPair.getValue();
			calculateNodeProbability(n, ( (weight/sum) * percentage ), resMap);
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
