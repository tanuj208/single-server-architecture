import java.util.*; 

public class Graph {
    int num_vertices;
    Vector<Edge> edges;

    public Graph(int num_vertices) {
        this.num_vertices = num_vertices;
        this.edges = new Vector<Edge> ();
    }

    public void add_edge(int u, int v, int w) {
        Edge e = new Edge(u, v, w);
        edges.add(e);
    }

}