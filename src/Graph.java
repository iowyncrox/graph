public class Graph {
	private static final String NEWLINE = System.getProperty("line.separator");

	private final int V;
	private int E;
	private LinkedList<Integer>[] adj;

	public Graph(int numberOfVertices) {
		if (numberOfVertices < 0)
			throw new IllegalArgumentException();

		V = numberOfVertices;
		E = 0;
		adj = (LinkedList<Integer>[]) new LinkedList[V];

		for (int i = 0; i < numberOfVertices; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public int totalNumberOfVertices() {
		return V;
	}

	public int totalNumberOfEdges() {
		return E;
	}

	private void validateVertex(final int vertexNumber) {
		if (vertexNumber < 0 || vertexNumber >= V)
			throw new IndexOutOfBoundsException();
	}

	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		E++;
		adj[v].insertFirst(w);
		adj[w].insertFirst(v);
	}

	/*
	 * Returns the vertices adjacent to vertex.
	 */

	public Iterable<Integer> verticesAdjacentToVertex(int v) {
		validateVertex(v);
		return adj[v];
	}

	public int degreeOfVertex(int v) {
		validateVertex(v);
		return adj[v].size();
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(V + " vertices, " + E + " edges " + NEWLINE);
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (int w : adj[v]) {
				s.append(w + " ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}

	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(1, 2);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(4, 2);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);

		System.out.println(graph);

	}
}
