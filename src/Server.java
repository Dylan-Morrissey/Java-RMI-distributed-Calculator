import java.awt.BorderLayout;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Server extends UnicastRemoteObject implements ServerRMI {
  // Text area for displaying contents
  private JTextArea jta = new JTextArea();
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
  
  public int Add(int x, int y) {
	  int add = x + y;
	  return add;
  }
  
  public int Multiply(int x, int y) {
	  	int multiply = x * y;
		return multiply;	
	}
	
  public float Divide(float x, float y) {
		float divide = x/y;	
		return divide;	
	}
	
	public int Minus(int x, int y) {
		int minus = x - y;	
		return minus;	
	}
  
  
  
  public static void main(String[] args) {
	  try {
		  Server obj = new Server();
		  Registry registry = LocateRegistry.createRegistry( 1200 );
		  registry.rebind("ServerRMI", obj);
		  System.out.println("Server bound in registry");
	  }
	  catch (Exception e) {
		  System.out.println("Server error: " + e.getMessage());
		  e.printStackTrace();
	  }
  }

@Override
public float Division(float x, float y) throws RemoteException {
	// TODO Auto-generated method stub
	return 0;
}

}