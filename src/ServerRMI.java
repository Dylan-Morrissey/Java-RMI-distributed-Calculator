/*
Author: Dylan Morrissey
Filename: ServerRMI.java
Classname: ServerRMI
Comment: The remote interface.

*/

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerRMI extends Remote {
	
	int Add(int x, int y) throws RemoteException;
	int Multiply(int x, int y) throws RemoteException;
	int Divide(int x, int y) throws RemoteException;
	int Minus(int x, int y) throws RemoteException;
	String GetClientIP() throws RemoteException;

}


