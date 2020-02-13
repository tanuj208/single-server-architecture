public interface Graphs
	extends java.rmi.Remote {
		public void add_graph(String graph_identifier, int num_nodes)
			throws java.rmi.RemoteException;
		
		public void add_edge(String graph_identifier, int u, int v, int w)
			throws java.rmi.RemoteException;

		public int get_mst(String graph_identifier)
			throws java.rmi.RemoteException;

		public void print_graph(String graph_identifier)
			throws java.rmi.RemoteException;
	}
