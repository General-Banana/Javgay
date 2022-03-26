package name.panitz.ludens.rmi.game;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
public class RMIGameServer {
  public static void main(String args[]) {
    try {
      RMIGameImpl obj = new RMIGameImpl();
      RMIGame stub
        = (RMIGame) UnicastRemoteObject.exportObject(obj, 0);
      Registry registry = LocateRegistry.getRegistry();
      registry.bind("rmigame", stub);
      System.err.println("Server ready");
    } catch (Exception e) {
      System.err.println("Server exception: " + e.toString());
      e.printStackTrace();
    }
  }
}

