package _7Homework;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class additional_AddressBookFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton add;
	private JButton first;
	private JButton next;
	private JButton previous;
	private JButton last;
	
	private JTextField jtfName;
	private String name;
	private JTextField jtfStreet;
	private String street;
	private JTextField jtfCity;
	private String city;
	private JTextField jtfState;
	private String state;
	private JTextField jtfZip;
	private String zip;
	
	
	public additional_AddressBookFrame(){
		initialization();
		this.setLayout(new BorderLayout());
		
		JPanel info = new JPanel(new GridLayout(3,1,5,14));
		info.setBorder(new LineBorder(Color.gray));
		
		JPanel info1 = new JPanel(new BorderLayout());
		info1.add(new JLabel("Name:"), BorderLayout.WEST);
		info1.add(jtfName,BorderLayout.CENTER);
		
		JPanel info2 = new JPanel(new BorderLayout());
		info2.add(new JLabel("Street:"),BorderLayout.WEST);
		info2.add(jtfStreet,BorderLayout.CENTER);
		
		JPanel info3 = new JPanel(new GridLayout(1,2));
		JPanel info3Left = new JPanel(new BorderLayout());
		info3Left.add(new JLabel("City:"),BorderLayout.WEST);
		info3Left.add(jtfCity,BorderLayout.CENTER);
		
		JPanel info3Right = new JPanel(new GridLayout(1,2));
		
		JPanel info3RightState = new JPanel(new BorderLayout());
		info3RightState.add(new JLabel("State:"),BorderLayout.WEST);
		info3RightState.add(jtfState,BorderLayout.CENTER);
		
		JPanel info3RightZip = new JPanel(new BorderLayout());
		info3RightZip.add(new JLabel("Zip:"),BorderLayout.WEST);
		info3RightZip.add(jtfZip,BorderLayout.CENTER);
		info3Right.add(info3RightState);
		info3Right.add(info3RightZip);
		info3.add(info3Left);
		info3.add(info3Right);
		info.add(info1);
		info.add(info2);
		info.add(info3);
		JPanel button = new JPanel(new GridLayout(1,5,3,3));
		button.add(add);
		button.add(first);
		button.add(next);
		button.add(previous);
		button.add(last);
		this.add(info,BorderLayout.CENTER);
		this.add(button, BorderLayout.SOUTH);
		addListener();
	}
	
	private void initialization(){
		add = new JButton("Add");
		add.setVisible(true);
		first = new JButton("First");
		first.setVisible(true);
		next = new JButton("Next");
		next.setVisible(true);
		previous = new JButton("Previous");
		previous.setVisible(true);
		last = new JButton("Last");
		last.setVisible(true);
		jtfName = new JTextField("");
		jtfStreet = new JTextField("");
		jtfCity = new JTextField("");
		jtfState = new JTextField("");
		jtfZip = new JTextField("");
		this.setResizable(false);
		this.setTitle("AddressBook");
		this.setSize(440,190);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void setText(additional_AddressItem item){
		jtfName.setText(item.name);
		jtfStreet.setText(item.street);
		jtfState.setText(item.state);
		jtfCity.setText(item.city);
		jtfZip.setText(item.zip);
	}
	private void setEmpty(){
		jtfName.setText("");
		jtfStreet.setText("");
		jtfState.setText("");
		jtfCity.setText("");
		jtfZip.setText("");
	}
	private void addListener(){
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//AddressBookActivator.output.writeObject();
				additional_AddressItem temp = new additional_AddressItem(name,street,city,state,zip);
				//AddressBookActivator.items[AddressBookActivator.itemCount] = temp;
				try {
					additional_AddressBookActivator.output.writeObject(temp);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				additional_AddressBookActivator.itemCount++;
				setEmpty();
				//AddressBookActivator.pointer = AddressBookActivator.itemCount;
				JOptionPane.showMessageDialog(null,"You've written an address item~","Infomation",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		first.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(additional_AddressBookActivator.itemCount == 0)
					JOptionPane.showMessageDialog(null,"No address!","Warning",JOptionPane.INFORMATION_MESSAGE);
				else{
					try {
						additional_AddressItem temp = (additional_AddressItem)additional_AddressBookActivator.input.readObject();
						setText(temp);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					additional_AddressBookActivator.pointer = 0;
				}
			}
		});
		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(additional_AddressBookActivator.pointer == -1 || additional_AddressBookActivator.pointer == additional_AddressBookActivator.itemCount)
					JOptionPane.showMessageDialog(null,"No next!","Warning",JOptionPane.INFORMATION_MESSAGE);
				else{
					try{
						for(int i = 0;i < additional_AddressBookActivator.pointer+1;i++){
							additional_AddressItem temp = (additional_AddressItem)additional_AddressBookActivator.input.readObject();
							setText(temp);
						}
					}catch(Exception e1){
						e1.printStackTrace();
					}
					additional_AddressBookActivator.pointer++;
				}
			}
		});
		previous.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(additional_AddressBookActivator.pointer == -1 || additional_AddressBookActivator.pointer == 0)
					JOptionPane.showMessageDialog(null,"No previous!","Warning",JOptionPane.INFORMATION_MESSAGE);
				else{
					try{
						for(int i = 0;i < additional_AddressBookActivator.pointer - 1;i++){
							additional_AddressItem temp = (additional_AddressItem)additional_AddressBookActivator.input.readObject();
							setText(temp);
						}
					}catch(Exception e1){
						e1.printStackTrace();
					}
					additional_AddressBookActivator.pointer--;
				}
			}
		});
		last.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(additional_AddressBookActivator.itemCount == 0)
					JOptionPane.showMessageDialog(null,"No address!","Warning",JOptionPane.INFORMATION_MESSAGE);
				else{
					try{
						for(int i = 0;i < additional_AddressBookActivator.itemCount;i++){
							additional_AddressItem temp = (additional_AddressItem)additional_AddressBookActivator.input.readObject();
							setText(temp);
						}
					}catch(Exception ex){
						ex.printStackTrace();
					}
					additional_AddressBookActivator.pointer = additional_AddressBookActivator.itemCount;
				}
			}
		});
		jtfName.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				name = jtfName.getText();
			}
			public void changedUpdate(DocumentEvent e){
				name = jtfName.getText();
			}
			public void removeUpdate(DocumentEvent e){
				name = jtfName.getText();
			}
		});
		jtfStreet.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				street = jtfStreet.getText();
			}
			public void changedUpdate(DocumentEvent e){
				street = jtfStreet.getText();
			}
			public void removeUpdate(DocumentEvent e){
				street = jtfStreet.getText();
			}
		});
		jtfCity.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				city = jtfCity.getText();
			}
			public void changedUpdate(DocumentEvent e){
				city = jtfCity.getText();
			}
			public void removeUpdate(DocumentEvent e){
				city = jtfCity.getText();
			}
		});
		jtfState.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				state = jtfState.getText();
			}
			public void changedUpdate(DocumentEvent e){
				state = jtfState.getText();
			}
			public void removeUpdate(DocumentEvent e){
				state = jtfState.getText();
			}
		});
		jtfZip.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				zip = jtfZip.getText();
			}
			public void changedUpdate(DocumentEvent e){
				zip = jtfZip.getText();
			}
			public void removeUpdate(DocumentEvent e){
				zip = jtfZip.getText();
			}
		});
	}
}
