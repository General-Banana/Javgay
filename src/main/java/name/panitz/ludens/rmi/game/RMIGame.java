package name.panitz.ludens.rmi.game;
import java.rmi.*;

public interface RMIGame extends Remote {

  public void createPlayer(String name) throws RemoteException;

  public void move(String name)         throws RemoteException;
  public void turnRight(String name)    throws RemoteException;
  public void turnLeft(String name)     throws RemoteException;
  public void shoot(String name)        throws RemoteException;

  public State getState()               throws RemoteException;
}

