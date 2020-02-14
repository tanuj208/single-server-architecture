import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;  
import java.util.*;

public class Client {  
   private Client() {}  
   public static void main(String[] args) {  
      try {  
         // Getting the registry 
         String server_ip = args[0];
         int server_port = Integer.parseInt(args[1]);
         Registry registry = LocateRegistry.getRegistry(server_ip, server_port); 
    
         // Looking up the registry for the remote object 
         Graphs stub = (Graphs) registry.lookup("Graphs"); 

         Scanner input=new Scanner(System.in);
         String ADD_GRAPH = "add_graph";
         String ADD_EDGE = "add_edge";
         String GET_MST = "get_mst";
        
         while(input.hasNext())
         {
             String command = input.next();

             if(command.equals(ADD_GRAPH))
             {
                String graph_identifier = input.next();
                Integer num_nodes = input.nextInt();
                 stub.add_graph(graph_identifier, num_nodes);
             }
             else if(command.equals(ADD_EDGE))
             {
                String graph_identifier = input.next();
                Integer u = input.nextInt();
                 Integer v = input.nextInt();
                 Integer w = input.nextInt();
                 stub.add_edge(graph_identifier, u, v, w);
             }
             else if(command.equals(GET_MST))
             {
                String graph_identifier = input.next();
                System.out.println(stub.get_mst(graph_identifier));
             }
             else
                 break;
         }
         input.close();
      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}