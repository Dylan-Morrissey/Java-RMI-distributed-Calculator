/*
Author: Dylan Morrissey
Filename: ServerRMI.java
Description: Server Connected to Remote Interface
Classname: Server
Comment: The Server.
*/

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Server extends UnicastRemoteObject implements ServerRMI {
  // Text area for displaying contents
  private static JTextArea jta = new JTextArea();
  private JFrame jframe = new JFrame();
  

  public Server() throws RemoteException {
	  super();
	  ServerGUI();
  }
  
  public void ServerGUI() {
	  jframe.setLayout(new BorderLayout());
	  jframe.add(new JScrollPane(jta), BorderLayout.CENTER);
	  jframe.setTitle("Server");
	  jframe.setSize(500, 300);
	  jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  jframe.setVisible(true); // It is necessary to show the frame here!

  }
  
  public String GetClientIP() {
	  try {
		  jta.append("\nClient Connected at IP: " + getClientHost());
		  
	  } catch (ServerNotActiveException ex) {
		  System.out.println(ex);
	  }
	  return "Client Connected";
  }
  
  public int Add(int x, int y) {
	  int add = x + y;
	  try {
			jta.append("\nCalculation request from: " + getClientHost() 
			+ "\nx value: " + x 
			+ "\ny value: " + y 
			+ "\nOperator: +" + "\nOutput to Client: " + add );
		} catch (ServerNotActiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return add;
  }
  
  public int Multiply(int x, int y) {
	  	int multiply = x * y;
	  	try {
			jta.append("\nCalculation request from: " + getClientHost() 
			+ "\nx value: " + x 
			+ "\ny value: " + y 
			+ "\nOperator: *" + "\nOutput to Client: " + multiply );
		} catch (ServerNotActiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	return multiply;	
	}
	
  public int Divide(int x, int y) {
		double divide = (double)x/(double)y;
		try {
			jta.append("\nCalculation request from: " + getClientHost() 
			+ "\nx value: " + x 
			+ "\ny value: " + y 
			+ "\nOperator: /" + "\nOutput to Client: " + divide );
		} catch (ServerNotActiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	
		return (int)divide;	
	}
	
	public int Minus(int x, int y) {
		int minus = x - y;	
		try {
			jta.append("\nCalculation request from: " + getClientHost() 
			+ "\nx value: " + x 
			+ "\ny value: " + y 
			+ "\nOperator: -" + "\nOutput to Client: " + minus );
		} catch (ServerNotActiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return minus;	
	}
  
  public static void main(String[] args) {
	  try {
		  Server obj = new Server();
		  jta.append("Server started at " + new Date() + '\n');
		  Registry registry = LocateRegistry.createRegistry( 1200 );
		  registry.rebind("ServerRMI", obj);
		  jta.append("Server bound in registry");
	  }
	  catch (Exception e) {
		  System.out.println("Server error: " + e.getMessage());
		  e.printStackTrace();
	  }
  }
}
