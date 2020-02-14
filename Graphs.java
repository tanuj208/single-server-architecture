public interface Graphs
	extends java.rmi.Remote {
		public void add_graph(String graph_identifier, Integer num_nodes)
			throws java.rmi.RemoteException;
		
		public void add_edge(String graph_identifier, Integer u, Integer v, Integer w)
			throws java.rmi.RemoteException;

		public Integer get_mst(String graph_identifier)
			throws java.rmi.RemoteException;

		public void print_graph(String graph_identifier)
			throws java.rmi.RemoteException;
	}
