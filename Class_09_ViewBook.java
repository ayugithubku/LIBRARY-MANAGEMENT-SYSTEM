package Library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.sql.*;
import java.awt.*;

public class Class_09_ViewBook extends JFrame implements ActionListener {
	
	String x[] = {"Id","Book No","Book Name","Author","Publisher","Quantity","IssuedBook", "Date"};
	JButton bt;
	String y[][]= new String[20][8];
	int i=0, j=0;
	JTable t;
	Font f1,f2;

	Class_09_ViewBook() {
		super("Books Information");
		setLocation(1,1);
		setSize(1000, 400);
		
		f1 = new Font("Arial", Font.BOLD, 15);
		
		try {
			Class_0_ConnectionClass obj = new Class_0_ConnectionClass();
			String q = "Select * from addbook";
			ResultSet rest = obj.stm.executeQuery(q);
			while(rest.next()) {
				y[i][j++]= rest.getString("id");
				y[i][j++]= rest.getString("BookNo");
				y[i][j++]= rest.getString("bookName");
				y[i][j++]= rest.getString("author");
				y[i][j++]= rest.getString("publisher");
				y[i][j++]= rest.getString("quantity");
				y[i][j++]= rest.getString("issueBook");
				y[i][j++]= rest.getString("date");
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		System.out.println("Testing...");
		new Class_09_ViewBook().setVisible(true);
	}

}
