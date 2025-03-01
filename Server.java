import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.server.UnicastRemoteObject; 

public class Server extends GraphsImpl { 
   public Server() {} 
   public static void main(String args[]) { 
      try {
         System.setProperty("java.rmi.server.hostname", "0.0.0.0");
         // Instantiating the implementation class 
         GraphsImpl obj = new GraphsImpl();
         int port = Integer.parseInt(args[0]);
    
         // Exporting the object of implementation class  
         // (here we are exporting the remote object to the stub) 
         Graphs stub = (Graphs) UnicastRemoteObject.exportObject(obj, 0);  
         
         // Binding the remote object (stub) in the registry 
         Registry registry = LocateRegistry.createRegistry(port); 
         
         registry.bind("Graphs", stub);  
         System.err.println("Server ready"); 
      } catch (Exception e) { 
         System.err.println("Server exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
} 