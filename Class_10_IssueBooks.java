package Library;

import java.awt.event.ActionEvent;

import java.sql.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Class_10_IssueBooks extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6, l7, l8;
	JButton bt1, bt2;
	JPanel p1, p2;
	Font f1, f2;
	Choice ch;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6;
	
	Class_10_IssueBooks() {
		super("Issue Book");
		setSize(650, 400);
		setLocation(0, 0);
		
		f1 = new Font("Arial", Font.BOLD, 25);
		f2 = new Font("Arial", Font.BOLD, 20);
		
		l1 = new JLabel("Issue Book");
		l2 = new JLabel("Book Id");
		l3 = new JLabel("Book No");
		l4 = new JLabel("Book Name");
		l5 = new JLabel("Student Id");
		l6 = new JLabel("Student Name");
		l7 = new JLabel("Student Contact");
		l8 = new JLabel("Book Quantity");
		
		
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setForeground(Color.WHITE);
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		tf6 = new JTextField();
		
		bt1 = new JButton("Issue Book");
		bt2 = new JButton("Cancel");
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		l1.setFont(f1);
		l2.setFont(f2);
		l3.setFont(f2);
		l4.setFont(f2);
		l5.setFont(f2);
		l6.setFont(f2);
		l7.setFont(f2);
		l8.setFont(f2);
		
		tf1.setFont(f2);
		tf2.setFont(f2);
		tf3.setFont(f2);
		tf4.setFont(f2);
		tf5.setFont(f2);
		tf6.setFont(f2);
		tf6.setEditable(false);
		tf6.setForeground(Color.RED);
		
		bt1.setFont(f2);
		bt2.setFont(f2);
		
		
		
		ch = new Choice();
		try {
			Class_0_ConnectionClass obj = new Class_0_ConnectionClass();
			String q = "select id from addbook";
			ResultSet rest = obj.stm.executeQuery(q);
			while(rest.next()) {
				ch.add(rest.getString("id"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		ch.setFont(f2);
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 1, 10, 10));
		p1.add(l1);
		p1.setBackground(Color.BLUE);
		
		p2 = new JPanel();
		p2.setLayout(new GridLayout(8, 2, 10, 10));
		p2.add(l2);
		p2.add(ch);
		
		p2.add(l3);
		p2.add(tf1);
		p2.add(l4);
		p2.add(tf2);
		p2.add(l5);
		p2.add(tf3);
		p2.add(l6);
		p2.add(tf4);
		p2.add(l7);
		p2.add(tf5);
		p2.add(l8);
		p2.add(tf6);
		
		p2.add(bt1);
		p2.add(bt2);
		
		setLayout(new BorderLayout(10, 10));
		add(p1, "North");
		add(p2, "Center");
		
		ch.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					try {
						Class_0_ConnectionClass obj2 = new Class_0_ConnectionClass();
						int id = Integer.parseInt(ch.getSelectedItem());
						String q1 = "select * from addbook where id = '"+id+"'";
						ResultSet rest1 = obj2.stm.executeQuery(q1);
						while(rest1.next()) {
							tf1.setText(rest1.getString("BookNo"));
							tf2.setText(rest1.getString("bookname"));
							tf6.setText(rest1.getString("quantity"));
						}
						
					}catch(Exception exx){
						exx.printStackTrace();
					}
				}
			
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1) {
			int qnt = 0;
			int id = Integer.parseInt(ch.getSelectedItem());
			String bookno = tf1.getText();
			String bookname = tf2.getText();
			int stuid = Integer.parseInt(tf3.getText());
			String stuname = tf4.getText();
			String stucont = tf5.getText();
			String date = new java.util.Date().toString();
			
			try {
				Class_0_ConnectionClass obj3 = new Class_0_ConnectionClass();
				String q0="select quantity from addbook where id = '"+id+"'";
				ResultSet rest0= obj3.stm.executeQuery(q0);
				while(rest0.next()) {
					qnt = Integer.parseInt(rest0.getString("quantity"));
				}
				if(qnt<=0) {
					JOptionPane.showMessageDialog(null, "Book quantity is less ! can't issue");
					this.setVisible(false);
				}
				else {
					String q2 = "insert into issuebook(BookId,bookno,bookname,studentId,studentname,studentcontact,date) values('"+id+"','"+bookno+"','"+bookname+"','"+stuid+"','"+stuname+"','"+stucont+"','"+date+",)";
					String q3 = "update addbook set issuebook = issuebook+1 where id = '"+id+"'";
					String q4 = "update addbook set quantity = quantity-1 where id = '"+id+"'";
					int aa = obj3.stm.executeUpdate(q2);
					int aaa = obj3.stm.executeUpdate(q3);
					int aaaa = obj3.stm.executeUpdate(q4);
					
					if(aa==1) {
						if(aaa==1) {
							if(aaaa==1) {
								JOptionPane.showMessageDialog(null, "your data successfully updated");
								this.setVisible(false);
							}
							else {
								JOptionPane.showMessageDialog(null, "Please ! Fill all details carefully");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Please ! Fill all details carefully");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Please ! Fill all details carefully");
					}
				}
			}catch(Exception ee) {
				ee.printStackTrace();
			}
		}
		if(e.getSource()==bt2) {
			JOptionPane.showMessageDialog(null, "Are you sure !");
			this.setVisible(false);
		}
			
			
		}
	
	
	public static void main(String[] args) {
		System.out.println("Testing...");
		new Class_10_IssueBooks().setVisible(true);
	}



	

}
