import java.util.*; 

public class GraphsImpl implements Graphs{

    Map<String, Graph> graphs;

    GraphsImpl() {
        graphs = new HashMap<String, Graph>();
        // see the capacity of HashMap
    }

    public void add_graph(String graph_identifier, int num_nodes)
    {
        Graph new_graph = new Graph(num_nodes);
        graphs.put(graph_identifier, new_graph);
        return;
    }
    public void add_edge(String graph_identifier, int u, int v, int w)
    {
        Graph given_graph = graphs.get(graph_identifier);
        given_graph.add_edge(u, v, w);
        return;
    }

    public int get_mst(String graph_identifier)
    {
        return 0;
    }

    public void print_graph(String graph_identifier)
    {
        System.err.println(graph_identifier);
        Graph given_graph = graphs.get(graph_identifier);
        System.err.println("Number of nodes in the graph are " + given_graph.num_vertices);
        Vector<Edge> edges = given_graph.edges;
        System.err.println("Number of edges in the graph are " + edges.size());
        for(int i=0;i<edges.size();i++)
        {
            System.err.println(edges.get(i).vtx1 + " " + edges.get(i).vtx2 + " " + edges.get(i).wt);
        }
    }
}