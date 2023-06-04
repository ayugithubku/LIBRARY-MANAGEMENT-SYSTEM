package Library;


import java.sql.ResultSet;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Class_04_ViewLibrarian extends JFrame implements ActionListener{
	
	String x[] = {"Lid","Name","Password","Email","Contact","Address","City"};
	JButton bt;
	String y[][]= new String[20][7];
	int i=0, j=0;
	JTable t;
	Font f1,f2;
	
	
	Class_04_ViewLibrarian() {
		super("Librarian Information");
		setLocation(1,1);
		setSize(1000, 400);
		
		f1 = new Font("Arial", Font.BOLD, 15);
		
		try {
			Class_0_ConnectionClass obj = new Class_0_ConnectionClass();
			String q = "Select * from tree";
			ResultSet rest = obj.stm.executeQuery(q);
			while(rest.next()) {
				y[i][j++]= rest.getString("Lid");
				y[i][j++]= rest.getString("Name");
				y[i][j++]= rest.getString("Password");
				y[i][j++]= rest.getString("Email");
				y[i][j++]= rest.getString("Contact");
				y[i][j++]= rest.getString("Address");
				y[i][j++]= rest.getString("City");
				i++;
				j=0;
			}
			t= new JTable(y, x);
			t.setFont(f1);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		JScrollPane sp = new JScrollPane(t);
		add(sp);
		
		
	}
	
	public static void main(String[] args) {
		System.out.println("Testing....");
		new Class_04_ViewLibrarian().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
