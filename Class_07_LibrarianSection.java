package Library;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Class_07_LibrarianSection extends JFrame implements ActionListener{
	
	JLabel l1;
	JButton bt1;
	JPanel p1, p2;
	Font f1,f2;

	Class_07_LibrarianSection() {
		super("Librarian Page");
		setLocation(0,0);
		setSize(1500, 800);
		
		f1 = new Font("Arial", Font.BOLD, 25);
		f2 = new Font("Arial", Font.BOLD, 20);
		
		ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Library/icon/image20.jpg"));
		Image img = ic.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
		ImageIcon ic1 = new ImageIcon(img);
		l1 = new JLabel(ic1);
		
		JMenuBar m1 = new JMenuBar();
		JMenu men1 = new JMenu("Add ");
		JMenuItem jmt1 = new JMenuItem("Add Books");
		
		JMenu men2 = new JMenu("View ");
		JMenuItem jmt2 = new JMenuItem("View Books");
		JMenuItem jmt3 = new JMenuItem("View issue Books");
		
		JMenu men3 = new JMenu("Issue ");
		JMenuItem jmt4 = new JMenuItem("Book Issue");
		
		JMenu men4 = new JMenu("Return ");
		JMenuItem jmt5 = new JMenuItem("Return Books");
		
		JMenu men5 = new JMenu("Exit");
		JMenuItem jmt6 = new JMenuItem("Logout");
		
		men1.add(jmt1);
		men2.add(jmt2);
		men2.add(jmt3);
		men3.add(jmt4);
		men4.add(jmt5);
		men5.add(jmt6);
		
		m1.add(men1);
		m1.add(men2);
		m1.add(men3);
		m1.add(men4);
		m1.add(men5);
		
		men1.setFont(f1);
		men2.setFont(f1);
		men3.setFont(f1);
		men4.setFont(f1);
		men5.setFont(f1);
		
		jmt1.setFont(f1);
		jmt2.setFont(f1);
		jmt3.setFont(f1);
		jmt4.setFont(f1);
		jmt5.setFont(f1);
		jmt6.setFont(f1);
		
		jmt1.addActionListener(this);
		jmt2.addActionListener(this);
		jmt3.addActionListener(this);
		jmt4.addActionListener(this);
		jmt5.addActionListener(this);
		jmt6.addActionListener(this);
		
		setJMenuBar(m1);
		add(l1);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmnd = e.getActionCommand();
		if(cmnd.equals("Add Books")) {
			new Class_08_AddBooks().setVisible(true);
		}
		else if(cmnd.equals("View Books")) {
			new Class_09_ViewBook().setVisible(true);
		}
		else if(cmnd.equals("Book Issue")) {
//			new Class_10_IssueBooks().setVisible(true);
		}
		else if(cmnd.equals("Return Books")) {
			new Class_11_ReturnBook().setVisible(true);
		}
		else if(cmnd.equals("Logout")) {
			System.exit(0);
		}
		
	}
		
	
	public static void main(String[] args) {
		System.out.println("Testing...");
		new Class_07_LibrarianSection().setVisible(true);
	}

	
}
