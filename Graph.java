import java.util.*; 

public class Graph {
    Integer num_vertices;
    Vector<Edge> edges;

    public Graph(Integer num_vertices) {
        this.num_vertices = num_vertices;
        this.edges = new Vector<Edge> ();
    }

    public void add_edge(Integer u, Integer v, Integer w) {
        Edge e = new Edge(u, v, w);
        edges.add(e);
    }

}