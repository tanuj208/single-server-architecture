import java.util.*; 

public class GraphsImpl implements Graphs{

    Map<String, Graph> graphs;
    Vector<Integer> p;
    Vector<Integer> d;

    GraphsImpl() {
        graphs = new HashMap<String, Graph>();
        // see the capacity of HashMap
    }

    public void add_graph(String graph_identifier, Integer num_nodes)
    {
        Graph new_graph = new Graph(num_nodes);
        graphs.put(graph_identifier, new_graph);
        return;
    }
    public void add_edge(String graph_identifier, Integer u, Integer v, Integer w)
    {
        Graph given_graph = graphs.get(graph_identifier);
        given_graph.add_edge(u, v, w);
        return;
    }

    private Integer get_parent(Integer v)
    {
        if(p.get(v)==-1 || p.get(v) == v)
            return v;
        p.set(v, get_parent(p.get(v)));
        return p.get(v);
    }

    private boolean check_cycle(Edge e)
    {
        Integer vtx1 = e.vtx1;
        Integer vtx2 = e.vtx2;

        int par_vtx1 = get_parent(vtx1);
        int par_vtx2 = get_parent(vtx2);

        if(par_vtx1 == par_vtx2)
            return true;
        
        if(d.get(par_vtx1) <= d.get(par_vtx2))
        {
            p.set(par_vtx1, par_vtx2);
            d.set(par_vtx2, d.get(par_vtx1) + d.get(par_vtx2));
        }
        else
        {
            p.set(par_vtx2, par_vtx1);
            d.set(par_vtx1, d.get(par_vtx1) + d.get(par_vtx2));
        }
        return false;
    }

    public void sort(Vector<Edge> edges)
    {
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2)
            {
                return e1.wt.compareTo(e2.wt);
            }
        });
    }

    public Integer get_mst(String graph_identifier)
    {
        Graph given_graph = graphs.get(graph_identifier);
        Integer num_nodes = given_graph.num_vertices;
        Vector<Edge> edges = given_graph.edges;
        sort(edges);
        p = new Vector<Integer> ();
        p.setSize(num_nodes + 5);
        Collections.fill(p, -1);

        d = new Vector<Integer> ();
        d.setSize(num_nodes + 5);
        Collections.fill(d, 1);

        Integer total_wt = 0;
        Integer edge_count = 0;

        for(Integer i = 0; i < edges.size(); i++)
        {
            Edge cur_edge = edges.get(i);
            if(!check_cycle(cur_edge))
            {
                edge_count++;
                total_wt += cur_edge.wt;
            }
            if(edge_count == num_nodes-1)
                break;
        }

        p.clear();
        d.clear();

        if(edge_count != num_nodes - 1)
            return -1;
        else
            return total_wt;
    }

    public void print_graph(String graph_identifier)
    {
        System.err.println(graph_identifier);
        Graph given_graph = graphs.get(graph_identifier);
        System.err.println("Number of nodes in the graph are " + given_graph.num_vertices);
        Vector<Edge> edges = given_graph.edges;
        System.err.println("Number of edges in the graph are " + edges.size());
        for(Integer i=0;i<edges.size();i++)
        {
            System.err.println(edges.get(i).vtx1 + " " + edges.get(i).vtx2 + " " + edges.get(i).wt);
        }
    }
}