import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

	private String in;
	private String del;
	private Graph g;

	public Parser(String in, String del, Graph g) {
		this.in = in;
		this.del = del;
		this.g = g;
	}

	public void parse() throws IOException {

		FileReader fr = new FileReader(in); 
		BufferedReader br = new BufferedReader(fr);

		String line;

		while ((line = br.readLine()) != null) {

			String[] parts = line.split(del);

			String orig = parts[0];
			int weight = Integer.parseInt(parts[1]);
			String term = parts[2];

			Node ori;
			Node ter;

			if (!(g.getNodes().containsKey(orig))) {

				ori = new Node(orig);
				g.addNode(ori);
			}

			else 
				ori = g.getNodes().get(orig);

			if (!(g.getNodes().containsKey(term))) {

				ter = new Node(term);
				g.addNode(ter);
			}

			else
				ter = g.getNodes().get(term);

			ori.addDestination(ter, weight);
			ori.getAdjacentNodes().put(ter, weight);
		}

		br.close();
	}
}