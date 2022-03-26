package name.panitz.rmi.date;

import java.util.Date;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GetDate extends Remote {
  Date getDate() throws RemoteException;
}

