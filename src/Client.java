/*
Author: Dylan Morrissey
Filename: Client.java
Description: Client Calculator which connects to server
Classname: Client
Comment: The Calculator Client GUI.
*/

import java.awt.EventQueue;
import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client {

	static int add;
	static int multiply;
	static int minus;
	static int division;
	private int x = 0;
	private int y = 0;
	private int selected = -1;
	private boolean operatorSelected = false;
	public JTextArea textArea = new JTextArea();
	public JTextArea textArea_1 = new JTextArea();
	private boolean operator_selected = false;
	
	
	
	static ServerRMI obj = null;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
					window.frame.setVisible(true);
					obj = (ServerRMI)Naming.lookup("//" + "localhost:1200" + "/ServerRMI");
					obj.GetClientIP();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Client() {
		initialize();
	}
	
	public void CalculationRequest() {
		String calculation = textArea.getText().toString();
		String [] numbers;
		if (selected != -1) {
			if (calculation.contains("-")) {
				try {
					numbers = calculation.split("-");
					x = Integer.parseInt(numbers[0]);
					y = Integer.parseInt(numbers[1]);
					textArea_1.setText("Minus Data sent to Server ");
					minus = obj.Minus(x, y);
					textArea.setText("" + minus);
					textArea_1.append("\nMinus data recieved from Server ");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (calculation.contains("+")) {
				try {
					numbers = calculation.split("\\+");
					x = Integer.parseInt(numbers[0]);
					y = Integer.parseInt(numbers[1]);
					textArea_1.setText("Add Data sent to Server ");
					add = obj.Add(x, y);
					textArea.setText("" + add);
					textArea_1.append("\nAdd data recieved from Server ");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			} else if (calculation.contains("*")) {
				try {
					numbers = calculation.split("\\*");
					x = Integer.parseInt(numbers[0]);
					y = Integer.parseInt(numbers[1]);
					textArea_1.setText("Multiply Data sent to Server ");
					multiply = obj.Multiply(x, y);
					textArea.setText("" + multiply);
					textArea_1.append("\nMultiply data recieved from Server ");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (calculation.contains("/")) {
					try {
						numbers = calculation.split("\\/");
						x = Integer.parseInt(numbers[0]);
						y = Integer.parseInt(numbers[1]);
						textArea_1.setText("Divide Data sent to Server ");
						division = obj.Divide(x, y);
						textArea.setText("" + division);
						textArea_1.append("\nDivide data recieved from Server ");
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			}
		} else {
			textArea_1.setText("Please finish calculation.");
		}
		operatorSelected = false;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 276, 414);
		frame.setTitle("Client Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button_divide = new JButton("/");
		button_divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selected != -1) {
					if (operator_selected) {
						CalculationRequest();
					}
					textArea.append("/");
					selected = -1;
					operator_selected = true;
				} else {
					textArea_1.setText("Please enter a number.");
				}
			}
		});
		
		JButton button_multiply = new JButton("*");
		button_multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (operatorSelected == false) {
					if (selected != -1) {
						if (operator_selected) {
							CalculationRequest();
						}
						textArea.append("*");
						selected = -1;
						operator_selected = true;
					} else {
						textArea_1.setText("Please enter a number.");
					}
				} else {
					CalculationRequest();
					textArea.append("*");
					
				}
			}
		});
		
		JButton button_minus = new JButton("-");
		button_minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selected != -1) {
					if (operator_selected) {
						CalculationRequest();
					}
					textArea.append("-");
					selected = -1;
					operator_selected = true;
				} else {
					textArea_1.setText("Please enter a number.");
				}
			}
		});
		
		JButton button_add = new JButton("+");
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selected != -1) {
					if (operator_selected) {
						CalculationRequest();
					}
					textArea.append("+");
					selected = -1;
					operator_selected = true;
				} else {
					textArea_1.setText("Please enter a number.");
				}
			}
		});
		
		JButton button_no7 = new JButton("7");
		button_no7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("7");
				selected = 1;
			}
		});
		
		JButton button_no8 = new JButton("8");
		button_no8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("8");
				selected = 1;
			}
		});
		
		JButton button_no9 = new JButton("9");
		button_no9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("9");
				selected = 1;
			}
		});
		
		JButton button_no4 = new JButton("4");
		button_no4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("4");
				selected = 1;
			}
		});
		
		JButton button_5 = new JButton("5");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("5");
				selected = 1;
			}
		});
		
		JButton button_no6 = new JButton("6");
		button_no6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("6");
				selected = 1;
			}
		});
		
		JButton button_no1 = new JButton("1");
		button_no1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("1");
				selected = 1;
			}
		});
		
		JButton button_no2 = new JButton("2");
		button_no2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("2");
				selected = 1;
			}
		});
		
		JButton button_no3 = new JButton("3");
		button_no3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("3");
				selected = 1;
			}
		});
		
		JButton button_no0 = new JButton("0");
		button_no0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("0");
				selected = 1;
			}
		});
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculationRequest();
			}
		});
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
						.addComponent(btnClear, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
						.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(button_divide, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button_no7, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button_no8, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button_no9, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(button_multiply, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button_no4, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button_no6, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(button_add, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button_no0, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnSubmit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(button_minus, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button_no1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button_no2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button_no3, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_divide, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_no7, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_no8, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_no9, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_multiply, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_no4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_no6, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_minus, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_no1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_no2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_no3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_no0, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_add, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
