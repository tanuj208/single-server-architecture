# Simple Single Server Architecture

## Architecture
- `Graphs.java` is the remote interface containing description of following methods :
    - `add_graph(graph_identifier, num_nodes)` - Adds a graph with given graph_identifier and number of nodes.
    - `add_edge(graph_identifier, u, v, w` - Adds an edge in graph with graph_identifier between vertices u and v with weight w.
    - `get_mst(graph_identifier)` - Returns total weight of Minimum Spanning Tree of from the graph of given graph_identifier.
    - `print_graph(graph_identifier)` - Prints the graph denoted by graph_identifier, used only for debugging purposes.
- `GraphsImpl.java` implements the abstract methods of remote interface.
- `Graph.java` contains class Graph with information about the graph. It contains a method to add an edge to the graph.
- `Edge.java` contains class Edge with information about an edge.
- `Server.java` is the main Server program.
- `Client.java` is the main Client program.

## Algorithm Implementation
- There is a map used for mapping between graph_identifier and Graph.
- Kruskal's algorithm is used to get minimum spanning tree of graph.
    - Edges are sorted according to weight.
    - One by one edges are traversed starting from minimum weight and added into the minimum spanning tree.
    - If there is an edge that is creating cycle in MST, that edge is not added.
    - Cycle Detection is done using DSU.