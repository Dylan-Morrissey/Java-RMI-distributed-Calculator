// Filename: ServerRMI.java

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
Classname: ServerRMI
Comment: The remote interface.
*/

public interface ServerRMI extends Remote {
	
	int Add(int x, int y) throws RemoteException;
	int Multiply(int x, int y) throws RemoteException;
	float Division(float x, float y) throws RemoteException;
	int Minus(int x, int y) throws RemoteException;

}


